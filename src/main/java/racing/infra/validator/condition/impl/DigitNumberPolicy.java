package racing.infra.validator.condition.impl;

import racing.infra.validator.condition.ConditionPolicy;

public class DigitNumberPolicy implements ConditionPolicy {

    // 최대 자릿수
    public static final int DIGIT_NUMBER = 2;

    @Override
    public boolean isSatisfied(String inputString) {
        return inputString.length() < DIGIT_NUMBER;
    }
}
