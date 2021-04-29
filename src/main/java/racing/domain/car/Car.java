package racing.domain.car;

import racing.domain.display.NumberPlate;

public class Car {

    private final NumberPlate numberPlate;


    public Car(NumberPlate numberPlate) {
        this.numberPlate = numberPlate;
    }


    public static Car create(String inputName){

        NumberPlate numberPlate = NumberPlate.create(inputName);
        return new Car(numberPlate);
    }

    public String getName() {
        return this.numberPlate.toString();
    }
}
