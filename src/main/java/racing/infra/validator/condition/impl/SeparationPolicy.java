package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class SeparationPolicy implements ConditionPolicy {
    public static final char SEPARATION_KEY = ',';

    @Override
    public boolean isSatisfied(String input) {

        int findPosition = input.indexOf(SEPARATION_KEY);
        return findPosition == -1;
    }
}
