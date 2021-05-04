package racing.infra.validator;

import racing.infra.validator.condition.ConditionPolicy;
import racing.infra.validator.condition.impl.DigitNumberPolicy;
import racing.infra.validator.condition.impl.NotEmptyString;
import racing.infra.validator.condition.impl.NumberValuePolicy;

public class NumberValidator {
    private static final ConditionPolicy[] conditionPolicies = new ConditionPolicy[]{
            new NotEmptyString(),
            new NumberValuePolicy(),
            new DigitNumberPolicy(),
    };

    public static boolean isSatisfied(String inputString) {

        for (ConditionPolicy policy : conditionPolicies) {
            if (policy.isSatisfied(inputString)) {
                return false;
            }
        }
        return true;
    }

    public static void check(String input) {

        boolean validation = isSatisfied(input);
        if (!validation) {
            throw new IllegalArgumentException();
        }

    }
}
