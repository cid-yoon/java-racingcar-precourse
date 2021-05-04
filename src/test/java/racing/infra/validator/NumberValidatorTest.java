package racing.infra.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("ALL")
class NumberValidatorTest {

    @DisplayName("유효한 숫자 입력 검증- 0 이상, 100 이하")
    @ParameterizedTest
    @CsvSource(value = {"1", "5", "9"})
    void 숫자검사기_유효한_숫자_검증(String inputNum) {

        assertThat(NumberValidator.isSatisfied(inputNum)).isTrue();

    }

    @DisplayName("세자리 이상의 숫자 입력시 예외 발생")
    @Test
    void 숫자검사기_유효범위_초과시_예외() {

        String inputNum = "100";
        assertThatIllegalArgumentException().isThrownBy(() -> NumberValidator.check(inputNum));

    }

    @DisplayName("세자리 이상의 숫자 입력시 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"1a", "a9", "aa"})
    void 숫자검사기_입력된_값이_숫자가_아닌경우_예외(String inputNum) {

        assertThatIllegalArgumentException().isThrownBy(() -> NumberValidator.check(inputNum));

    }

}