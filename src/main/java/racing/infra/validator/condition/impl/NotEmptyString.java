package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class NotEmptyString implements ConditionPolicy {
    @Override
    public boolean isSatisfied(String input) {

        if (input == null) {
            return false;

        }

        if (input.length() == 0) {
            return false;
        }


        return true;
    }
}
