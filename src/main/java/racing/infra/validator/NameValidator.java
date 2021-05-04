package racing.infra.validator;

import racing.infra.validator.condition.ConditionPolicy;
import racing.infra.validator.condition.impl.NameLengthPolicy;
import racing.infra.validator.condition.impl.NotEmptyString;
import racing.infra.validator.condition.impl.SeparationPolicy;

public class NameValidator {

    private static final ConditionPolicy[] conditionPolicies = new ConditionPolicy[]{
            new NotEmptyString(),
            new SeparationPolicy(),
            new NameLengthPolicy(),
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
