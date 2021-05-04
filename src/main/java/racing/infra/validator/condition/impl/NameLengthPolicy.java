package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class NameLengthPolicy implements ConditionPolicy {

    @Override
    public boolean isSatisfied(String input) {

        String[] names = input.split(String.valueOf(SeparationPolicy.SEPARATION_KEY));
        for (String name : names) {

            if (!validName(name)) {
                return true;
            }
        }

        return false;
    }

    private boolean validName(String name) {

        int MIN_NAME_LENGTH = 0;
        if (name.length() <= MIN_NAME_LENGTH) {
            return false;
        }

        int MAX_NAME_LENGTH = 5;
        return name.length() <= MAX_NAME_LENGTH;
    }
}
