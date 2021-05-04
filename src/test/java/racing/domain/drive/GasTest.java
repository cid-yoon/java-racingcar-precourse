package racing.domain.drive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("ALL")
class GasTest {

    @Test
    @DisplayName("연료 충전을 위한 수량을 입력 받을 수 있다")
    void 연료_충전_충전량을_입력받을수_있다() {

        // Given
        int chargeAmount = 9;

        // When
        Gas gas = new Gas(chargeAmount);

        // Then
        assertThat(gas).isNotNull();
        assertThat(gas.toString()).isEqualTo(String.valueOf(chargeAmount));

    }

    @DisplayName("연료 충전시 유효하지 않은 수치(0 미만 또는 최대값)를 입력하면 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, Gas.MAX_GAUGE})
    void 연료_충전_유효하지_않은_수량_예외반환(Integer amount) {

        assertThatIllegalArgumentException().isThrownBy(() -> new Gas(amount));
    }

    @DisplayName("연료 소비시 남은 수량을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"9:8", "2:1", "1:0"}, delimiter = ':')
    void 연료_소비_검증(Integer chargeAmount, Integer remainAmount) {

        // Given
        Gas gas = new Gas(chargeAmount);

        // When
        Gas remainGas = gas.consume();

        // Then
        assertThat(remainGas).isEqualTo(new Gas(chargeAmount - Gas.CONSUME_AMOUNT));
        assertThat(remainGas).isEqualTo(new Gas(remainAmount));
    }

    @DisplayName("연료가 없는데 소비 요청시 IllegalStatement 예외를 반환")
    @Test
    void 연료_소비_연료가_없는경우_예외반환() {

        Gas gas = new Gas(0);
        assertThatIllegalStateException().isThrownBy(gas::consume);
    }

}