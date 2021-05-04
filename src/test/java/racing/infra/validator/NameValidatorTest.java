package racing.infra.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("ALL")
class NameValidatorTest {


    @DisplayName("유효한 이름 입력 검증- 0글자 이상, 5글자 이하, 콤마 딜리미터 사용")
    @Test
    void 이름검사기_유효한_이름_검증() {

        String names = "a,ab,abc,abcd,abcde";
        assertThat(NameValidator.isSatisfied(names)).isTrue();

    }

    @DisplayName("빈 문자열을 입력 받는 경우 validation 예외를 반환한다")
    @Test
    void 이름검사기_빈문자이름_검증_잘못된_입력예외를_반환() {

        String names = ",iu,gogo";

        assertThatIllegalArgumentException().isThrownBy(() -> NameValidator.check(names));
    }

    @DisplayName("유효하지 않은 자릿수의 이름 길이")
    @Test
    void 이름검사기_유효하지_않은_이름_길이() {

        String names = "123456,abcdef";
        assertThatIllegalArgumentException().isThrownBy(() -> NameValidator.check(names));
    }

    @DisplayName("유효하지 않은 딜리미터가 사용된 경우-콤마")
    @Test
    void 이름검사기_유효하지_않은_딜리미터_사용() {

        String names = "1245:abcde";
        assertThatIllegalArgumentException().isThrownBy(() -> NameValidator.check(names));
    }

}