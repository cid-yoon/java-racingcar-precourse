package racing.domain.drive;

/**
 * 연료를 주입받아 폭발하여 힘을 발생하는 기관
 * 회전수를 생성하여 자동차를 움직인다
 * <p>
 * 회전수가 4이상인 경우 이동
 * 회전수가 3이하인 경우에는 이동할수 없음
 */
public class Cylinder {

    public static final int MIN_TORQUE = 0;
    public static final int MAX_TORQUE = 9;

    private final int criticalPoint;    //  실린더 임계치

    public Cylinder(int criticalPoint) {
        torqueValidation(criticalPoint);
        this.criticalPoint = criticalPoint;
    }

    /**
     * 임계점 판단하여 이동 여부를 판별
     * 엔진에서 결정해줌
     *
     * @param torque 회전수
     * @return 엔진의 동작 결과
     */
    public EngineState run(int torque) {
        torqueValidation(torque);
        if (criticalPoint >= torque) {
            return EngineState.MOVE;
        }

        return EngineState.IDLE;
    }

    private void torqueValidation(int torque) {
        if (MIN_TORQUE > torque || torque > MAX_TORQUE)
            throw new IllegalArgumentException();
    }
}
