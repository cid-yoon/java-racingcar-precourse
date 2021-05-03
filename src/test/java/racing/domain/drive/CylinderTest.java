package racing.domain.drive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CylinderTest {

    @DisplayName("최소, 최대값 허용(0부터 9)으로 실린더 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 실린더_생성_허용되는_회전수_검증(int torque) {
        Cylinder cylinder = new Cylinder(torque);
        assertThat(cylinder).isNotNull();
    }

    @DisplayName("허용된 수치를 초과하는 경우 예외 발생")
    @Test
    void 실린더_생성_허용되지않은_입력값으로_생성시_예외발생() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cylinder(Cylinder.MIN_TORQUE - 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cylinder(Cylinder.MAX_TORQUE + 1);
        });
    }

    @DisplayName("임계점 이하 수치를 입력 받는 경우 제자리 명령을 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 실린더_동작_임계점이하_입력시_제자리_명령_생성(int torque) {

        Cylinder cylinder = new Cylinder(torque);
        EngineState state = cylinder.run(Engine.DEFAULT_CRITICAL_POINT);
        assertThat(state).isEqualTo(EngineState.IDLE);
    }

    @DisplayName("임계점 이상 수치를 입력 받는 경우 이동 명령을 반환")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 실린더_동작_임계점_이상_입력시_이동(int torque) {

        Cylinder cylinder = new Cylinder(torque);
        EngineState state = cylinder.run(Engine.DEFAULT_CRITICAL_POINT);
        assertThat(state).isEqualTo(EngineState.MOVE);
    }

    @DisplayName("회전수를 초과한 임계점을 입력 받는 경우 예외를 반환")
    @Test
    void 실린더_동작_잘못된_임계점_입력시_예외반환() {

        Cylinder cylinder = new Cylinder(5);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            cylinder.run(Cylinder.MIN_TORQUE - 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            cylinder.run(Cylinder.MAX_TORQUE + 1);
        });


    }

}