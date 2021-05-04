package racing.domain;

import racing.domain.display.DisplayPanel;
import racing.domain.display.DriveRecord;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private final List<Car> cars;
    private final int chargeAmount;

    public Track(List<Car> cars, int chargeAmount) {
        this.cars = cars;
        this.chargeAmount = chargeAmount;
    }

    public void run(DisplayPanel display) {

        for (int i = 0; i < chargeAmount; i++) {

            List<DriveRecord> records = onDrive();

            display.update(records);
            display.draw(records);
        }

        display.winnerDisplay();
    }

    private List<DriveRecord> onDrive() {
        List<DriveRecord> recordList = new ArrayList<>();
        for (Car car : cars) {
            DriveRecord record = car.drive();
            recordList.add(record);
        }
        return recordList;
    }
}
