package com.github.tens0rfl0w.rl.actionselection;

import com.github.tens0rfl0w.rl.models.QModel;
import com.github.tens0rfl0w.rl.utils.IndexValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 * Created by xschen on 9/28/2015 0028.
 */
public class GibbsSoftMaxActionSelectionStrategy extends AbstractActionSelectionStrategy {

    private final Random random;
    public GibbsSoftMaxActionSelectionStrategy(){
        random = new Random();
    }

    public GibbsSoftMaxActionSelectionStrategy(Random random){
        this.random = random;
    }

    @Override
    public Object clone() {
        return new GibbsSoftMaxActionSelectionStrategy();
    }

    @Override
    public IndexValue selectAction(int stateId, QModel model, Set<Integer> actionsAtState) {
        List <Integer> actions = new ArrayList <>();
        if (actionsAtState == null) {
            for (int i = 0; i < model.getActionCount(); ++i) {
                actions.add(i);
            }
        } else {
            actions.addAll(actionsAtState);
        }

        double sum = 0;
        List <Double> plist = new ArrayList <>();
        for (int actionId : actions) {
            double p = Math.exp(model.getQ(stateId, actionId));
            sum += p;
            plist.add(sum);
        }

        IndexValue iv = new IndexValue();
        iv.setIndex(-1);
        iv.setValue(Double.NEGATIVE_INFINITY);

        double r = sum * random.nextDouble();
        for(int i=0; i < actions.size(); ++i){

            if(plist.get(i) >= r){
                int actionId = actions.get(i);
                iv.setValue(model.getQ(stateId, actionId));
                iv.setIndex(actionId);
                break;
            }
        }

        return iv;
    }
}
