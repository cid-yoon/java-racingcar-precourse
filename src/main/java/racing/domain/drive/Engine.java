package racing.domain.drive;

import java.util.Random;

/**
 * 연료와 실린더
 */
public class Engine {

    private static final Random random = new Random();
    public static final int DEFAULT_CRITICAL_POINT = 4;
    private final Cylinder cylinder;
    private Gas gas;

    private Engine(Gas gas, Cylinder cylinder) {
        this.gas = gas;
        this.cylinder = cylinder;
    }

    public String getGasAmount() {
        return this.gas.toString();
    }

    public EngineState run() {

        if (!gas.has()) {
            return EngineState.NO_GAS;
        }

        return cylinder.run(accelerator());
    }


    /**
     * 0~9사이의 토크를 생성한다
     */
    private static int accelerator() {
        return random.nextInt(Cylinder.MAX_TORQUE);
    }

    public static Engine create(int gasAmount) {
        return new Engine(new Gas(gasAmount), new Cylinder(DEFAULT_CRITICAL_POINT));
    }

    public static Engine create(int gasAmount, Cylinder cylinder) {
        return new Engine(new Gas(gasAmount), cylinder);
    }


}
