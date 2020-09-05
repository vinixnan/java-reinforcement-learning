package com.github.tens0rfl0w.rl.actionselection;

import com.github.tens0rfl0w.rl.models.QModel;
import com.github.tens0rfl0w.rl.utils.IndexValue;

import java.util.Random;
import java.util.Set;


/**
 * Created by xschen on 9/27/2015 0027.
 */
public class SoftMaxActionSelectionStrategy extends AbstractActionSelectionStrategy {
    private Random random = new Random();

    @Override
    public Object clone(){
        return new SoftMaxActionSelectionStrategy(random);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof SoftMaxActionSelectionStrategy;
    }

    public SoftMaxActionSelectionStrategy(){

    }

    public SoftMaxActionSelectionStrategy(Random random){
        this.random = random;
    }

    @Override
    public IndexValue selectAction(int stateId, QModel model, Set<Integer> actionsAtState) {
        return model.actionWithSoftMaxQAtState(stateId, actionsAtState, random);
    }
}
