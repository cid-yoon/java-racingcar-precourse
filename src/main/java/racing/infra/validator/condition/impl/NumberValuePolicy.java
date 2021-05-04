package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class NumberValuePolicy implements ConditionPolicy {
    @Override
    public boolean isSatisfied(String inputString) {

        return !inputString.matches("^[1-9]+$");
    }
}
