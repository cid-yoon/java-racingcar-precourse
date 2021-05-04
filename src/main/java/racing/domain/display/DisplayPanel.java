package racing.domain.display;

import racing.infra.UiSystem;

import java.util.ArrayList;
import java.util.List;

public class DisplayPanel {

    private final UiSystem uiSystem;

    private Integer highestDistance = 0;
    private String leaderNames;

    public Integer getHighestDistance() {
        return highestDistance;
    }

    public String getLeaderNames() {
        return leaderNames;
    }

    public DisplayPanel(UiSystem uiSystem) {
        this.uiSystem = uiSystem;
    }

    public int update(List<DriveRecord> records) {

        if(records == null){
            throw new NullPointerException();
        }

        this.highestDistance = calculateHighestDistance(records, this.highestDistance);
        this.leaderNames = calculateLeaderNames(records, highestDistance);

        return highestDistance;
    }

    public void display(List<DriveRecord> records) {
        for (DriveRecord record : records) {
            record.display(uiSystem);
        }
    }

    public void winnerDisplay() {
        this.uiSystem.display(this.leaderNames + "가 최종 우승했습니다");
    }


    private int calculateHighestDistance(List<DriveRecord> records, int highestDistance) {

        int distanceResult = highestDistance;
        for (DriveRecord record : records) {

            if (highestDistance < record.getDistance()) {
                distanceResult = record.getDistance();
            }
        }
        return distanceResult;
    }

    private String calculateLeaderNames(List<DriveRecord> records, int highestDistance) {

        List<String> leaderNameList = new ArrayList<>();
        for (DriveRecord record : records) {
            if (record.getDistance() == highestDistance) {
                leaderNameList.add(record.getName());
            }
        }

        return String.join(",", leaderNameList);
    }


}
