package racing.domain.display;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("ALL")
class DriveRecordTest {

    @DisplayName("주행기록 - 이름과 주행 거리를 확인할 수 있다")
    @Test
    void 주행기록_생성() {

        String name = "hello";
        int distance = 10;
        DriveRecord driveRecord = DriveRecord.create(name, distance);

        assertThat(driveRecord).isNotNull();
        assertThat(driveRecord.getName()).isEqualTo(name);
        assertThat(driveRecord.getDistance()).isEqualTo(distance);
    }

    @DisplayName("주행기록 - 음수 입력시 예외를 반환한다")
    @Test
    void 주행기록_주행거리_0_이상만_허용() {


        assertThatIllegalArgumentException().isThrownBy(() -> DriveRecord.create("hello", -10));
    }

    @DisplayName("주행기록 - 이름이 없는 경우 예외를 반환한다")
    @Test
    void 주행기록_이름_필수() {

        assertThatIllegalArgumentException().isThrownBy(() -> DriveRecord.create(null, 10));
    }

}