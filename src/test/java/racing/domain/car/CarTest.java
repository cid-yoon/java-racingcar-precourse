package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    @DisplayName("번호판을 통해 자동차의 이름을 설정/확인할 수 있다")
    void 자동차_이름표시(){

        Car car = Car.create("myCar");

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo("myCar");
        assertThat(car.getName()).isNotEqualTo("myCarr");
    }

}