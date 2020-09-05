package com.github.tens0rfl0w.rl.actionselection;

import com.github.tens0rfl0w.rl.models.QModel;
import com.github.tens0rfl0w.rl.models.UtilityModel;
import com.github.tens0rfl0w.rl.utils.IndexValue;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


/**
 * Created by xschen on 9/27/2015 0027.
 */
public interface ActionSelectionStrategy extends Serializable, Cloneable {
    IndexValue selectAction(int stateId, QModel model, Set<Integer> actionsAtState);
    IndexValue selectAction(int stateId, UtilityModel model, Set<Integer> actionsAtState);
    String getPrototype();
    Map<String, String> getAttributes();
}
