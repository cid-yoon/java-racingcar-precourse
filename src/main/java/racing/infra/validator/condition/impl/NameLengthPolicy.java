package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class NameLengthPolicy implements ConditionPolicy {

    private final int MIN_NAME_LENGTH = 0;
    private final int MAX_NAME_LENGTH = 5;

    @Override
    public boolean isSatisfied(String input) {

        String[] names = input.split(String.valueOf(SeparationPolicy.SEPARATION_KEY));
        for (String name : names) {

            if (!validName(name)) {
                return false;
            }
        }

        return true;
    }

    private boolean validName(String name) {

        if (name.length() <= MIN_NAME_LENGTH) {
            return false;
        }

        if (name.length() > MAX_NAME_LENGTH) {
            return false;
        }
        return true;
    }
}
