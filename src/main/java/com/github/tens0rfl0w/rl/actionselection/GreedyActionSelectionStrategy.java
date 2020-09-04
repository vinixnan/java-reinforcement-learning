package com.github.tens0rfl0w.rl.actionselection;

import com.github.tens0rfl0w.rl.utils.IndexValue;
import com.github.tens0rfl0w.rl.models.QModel;

import java.util.Set;


/**
 * Created by xschen on 9/27/2015 0027.
 */
public class GreedyActionSelectionStrategy extends AbstractActionSelectionStrategy {
    @Override
    public IndexValue selectAction(int stateId, QModel model, Set<Integer> actionsAtState) {
        return model.actionWithMaxQAtState(stateId, actionsAtState);
    }

    @Override
    public Object clone(){
        GreedyActionSelectionStrategy clone = new GreedyActionSelectionStrategy();
        return clone;
    }

    @Override
    public boolean equals(Object obj){
        return obj != null && obj instanceof GreedyActionSelectionStrategy;
    }
}
