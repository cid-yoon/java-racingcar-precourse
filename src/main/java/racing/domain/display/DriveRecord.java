package racing.domain.display;

import racing.infra.UiSystem;

public class DriveRecord {
    private final String name;
    private final Integer distance;

    // 출력에 사용될 라인 모양
    private static final String LINE_SYMBOL = "-";
    private static final int MIN_DISTANCE = 0;

    private DriveRecord(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void display(UiSystem uiSystem) {
        String driveLine = createDriveLine();
        uiSystem.display(String.format("name : %s\t%s", this.name, driveLine));
    }

    private String createDriveLine() {

        StringBuilder driveLine = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
            driveLine.append(LINE_SYMBOL);
        }
        return driveLine.toString();

    }

    public static DriveRecord create(String name, int distance) {

        if (name == null) {
            throw new IllegalArgumentException();
        }

        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException();
        }

        return new DriveRecord(name, distance);
    }


}
