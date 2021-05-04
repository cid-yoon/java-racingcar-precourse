package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.display.DriveRecord;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("ALL")
class CarTest {

    @DisplayName("번호판을 통해 자동차의 이름을 설정/확인할 수 있다")
    @Test
    void 자동차_번호판_등록() {

        Car car = Car.create("myCar", 9);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo("myCar");
        assertThat(car.getName()).isNotEqualTo("myCarr");
    }

    @DisplayName("자동차의 연료를 채울 수 있다(이동 횟수)")
    @Test
    void 자동차_가스_충전() {

        int gasAmount = 9;
        Car car = Car.create("myCar", gasAmount);

        assertThat(String.valueOf(gasAmount)).isEqualTo(car.getGasAmount());
    }

    @DisplayName("자동차의 주행 거리를 확인할 수 있다)")
    @Test
    void 자동차_주행거리_확인() {

        int gasAmount = 9;
        Car car = Car.create("myCar", gasAmount);
        DriveRecord record = car.drive();
        assertThat(record.getDistance()).isEqualTo(car.getMileage());
    }

}