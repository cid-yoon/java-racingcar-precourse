package racing.domain;

import racing.domain.display.DriveRecord;
import racing.domain.display.NumberPlate;
import racing.domain.drive.Engine;
import racing.domain.drive.EngineState;

public class Car {

    // 번호판
    private final NumberPlate numberPlate;

    // 엔진
    private final Engine engine;

    //  누적 주행 거리
    private Integer mileage = 0;


    private Car(NumberPlate numberPlate, int gasAmount) {
        this.numberPlate = numberPlate;
        this.engine = Engine.create(gasAmount);
    }

    public String getName() {
        return this.numberPlate.toString();
    }

    public String getGasAmount() {
        return this.engine.getGasAmount();
    }

    public Integer getMileage() {
        return this.mileage;
    }


    public static Car create(String inputName, int gasAmount) {

        NumberPlate numberPlate = NumberPlate.create(inputName);
        return new Car(numberPlate, gasAmount);
    }

    public static Car create(NumberPlate numberPlate, int gasAmount) {

        return new Car(numberPlate, gasAmount);
    }


    public DriveRecord drive() {

        EngineState result = this.engine.run();

        if (EngineState.MOVE.equals(result)) {
            this.mileage++;
        }

        return DriveRecord.create(getName(), this.mileage);
    }


}
