package racing.domain.drive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EngineTest {

    private final static int DEFAULT_CRITICAL_POINT = 4;

    @DisplayName("엔진 개체를 생성")
    @Test
    void 엔진_생성() {

        Gas newGas = new Gas(10);
        Cylinder newCylinder = new Cylinder(DEFAULT_CRITICAL_POINT);
        Engine engine = new Engine(newGas, newCylinder);
        assertThat(engine).isNotNull();
    }

    @DisplayName("엔진 동작 - 연료가 없으면 NO_GAS 반환")
    @Test
    void 엔진_동작_연료가_부족한_경우() {

        Gas gas = new Gas(0);
        Cylinder newCylinder = new Cylinder(DEFAULT_CRITICAL_POINT);
        Engine engine = new Engine(gas, newCylinder);

        EngineState state = engine.run();
        assertThat(state).isEqualTo(EngineState.NO_GAS);

    }

    @DisplayName("엔진 동작 - 연료가 있으면 NO_GAS이외 메시지 반환")
    @Test
    void 엔진_동작_연료가_충분한_경우() {

        Gas gas = new Gas(5);
        Cylinder newCylinder = new Cylinder(DEFAULT_CRITICAL_POINT);
        Engine engine = new Engine(gas, newCylinder);

        EngineState state = engine.run();
        assertThat(state).isNotEqualTo(EngineState.NO_GAS);

    }

    @DisplayName("엔진 동작 - 임계치 이하이면 제자리")
    @Test
    void 엔진_동작_임계치_이하이면_제자리() {

        Gas gas = new Gas(10);
        Cylinder newCylinder = new Cylinder(Cylinder.MIN_TORQUE);
        Engine engine = new Engine(gas, newCylinder);

        EngineState state = engine.run();
        assertThat(state).isEqualTo(EngineState.IDLE);

    }

    @DisplayName("엔진 동작 - 임계치 이싱이면 이동")
    @Test
    void 엔진_동작_임계치_이싱이면_이동() {

        Gas gas = new Gas(10);
        Cylinder newCylinder = new Cylinder(Cylinder.MAX_TORQUE);
        Engine engine = new Engine(gas, newCylinder);

        EngineState state = engine.run();
        assertThat(state).isEqualTo(EngineState.MOVE);

    }
}
