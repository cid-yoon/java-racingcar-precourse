package racing;

import racing.domain.Car;
import racing.domain.Track;
import racing.domain.display.DisplayPanel;
import racing.domain.display.NumberPlate;
import racing.infra.UiSystem;
import racing.infra.impl.ConsoleUiSystem;
import racing.infra.validator.NameValidator;
import racing.infra.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)기준으로 구분\n";
    private final String GAS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다. 다시 시도해 주세요\n";

    private UiSystem uiSystem = new ConsoleUiSystem();

    private Track track;

    public void run(  ) {

        List<NumberPlate> numberPlates = createNumberPlate();
        int gasAmount = chargeGasAmount();

        DisplayPanel displayPanel = new DisplayPanel(uiSystem);

        List<Car> cars = createCars(numberPlates, gasAmount);
        track = new Track(cars, gasAmount);
        track.run(displayPanel);
    }


    private List<Car> createCars(List<NumberPlate> numberPlates, int gasAmount) {

        List<Car> cars = new ArrayList<>();
        for (NumberPlate numberPlate : numberPlates) {
            cars.add(Car.create(numberPlate, gasAmount));
        }
        return cars;
    }

    private List<NumberPlate> createNumberPlate() {

        String carNames = "";
        while (true) {

            uiSystem.display(NAME_INPUT_MESSAGE);
            carNames = uiSystem.input();
            if (!NameValidator.isSatisfied(carNames)) {
                uiSystem.display(INVALID_INPUT_MESSAGE);
                continue;
            }
            break;
        }

        List<NumberPlate> numberPlates = new ArrayList<>();
        for (String name : carNames.split(String.valueOf(','))) {
            numberPlates.add(NumberPlate.create(name));
        }
        return numberPlates;
    }

    private int chargeGasAmount() {

        String chargeAmount = "";
        while (true) {
            uiSystem.display(GAS_INPUT_MESSAGE);
            chargeAmount = uiSystem.input();

            if (!NumberValidator.isSatisfied(chargeAmount)) {
                uiSystem.display(INVALID_INPUT_MESSAGE);
                continue;
            }
            break;
        }
        return Integer.parseInt(chargeAmount);
    }


}
