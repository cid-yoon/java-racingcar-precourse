package racing.domain.display;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("ALL")
public class NumberPlateTest {


    @DisplayName("1글자부터 5글자 사이의 이름을 생성한다")
    @ParameterizedTest
    @CsvSource(value = {
            "a:1", "ab:2", "abc:3", "abcd:4", "abcde:5"},
            delimiter = ':')
    void 번호판_1부터_5사이의_값_생성(String name, int length) {

        NumberPlate numberPlate = NumberPlate.create(name);
        assertThat(numberPlate.length()).isEqualTo(length);
    }

    @DisplayName("공백 문자를 제외한 1부터 5글자 사이의 이름을 생성한다")
    @ParameterizedTest
    @CsvSource(value = {
            " abc de:5", "abc     de:5", "  abc   d e:5"},
            delimiter = ':')
    void 번호판_입력문자에서_공백을_제외한_1부터_5사이_값을_생성(String name, int length) {

        NumberPlate numberPlate = NumberPlate.create(name);
        assertThat(numberPlate.length()).isEqualTo(length);
    }

    @DisplayName("번호판 생성 조건에 어긋난 입력을 받는 경우 예외를 발생한다")
    @Test
    void 번호판_생성규칙에서_어긋난경우_예외발생() {

        String emptyName = "";
        String overflowName = "abcdef";


        assertThatNullPointerException().isThrownBy(() -> {
            NumberPlate.create(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberPlate.create(emptyName);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberPlate.create(overflowName);
        });


    }

}
