package racing.domain.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.infra.UiSystem;
import racing.infra.impl.ConsoleUiSystem;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class DisplayPanelTest {

    private UiSystem uiSystem;

    @BeforeEach
    void setup() {
        this.uiSystem = new ConsoleUiSystem();
    }

    @Test
    void 전광판_사용자_주행_정보출력() {

        DisplayPanel displayPanel = new DisplayPanel(uiSystem);
        List<DriveRecord> records = Arrays.asList(DriveRecord.create("aa", 10),
                DriveRecord.create("bb", 11),
                DriveRecord.create("cc", 12));

        displayPanel.update(records);

        assertThat(displayPanel).isNotNull();
        assertThat(displayPanel.getLeaderNames()).isEqualTo("cc");
        assertThat(displayPanel.getHighestDistance()).isEqualTo(12);
    }

    @Test
    void 전광판_사용자_주행_정보_다중우승자_확인() {

        DisplayPanel displayPanel = new DisplayPanel(uiSystem);
        List<DriveRecord> records = Arrays.asList(DriveRecord.create("aa", 10),
                DriveRecord.create("bb", 12),
                DriveRecord.create("cc", 12));

        displayPanel.update(records);

        assertThat(displayPanel).isNotNull();
        assertThat(displayPanel.getLeaderNames()).contains("bb", "cc");
        assertThat(displayPanel.getHighestDistance()).isEqualTo(12);
    }

    @Test
    void 전광판_사용자_주행_정보_주행기록이_빈값일때_예외() {

        DisplayPanel displayPanel = new DisplayPanel(uiSystem);
        assertThatNullPointerException().isThrownBy(() -> {
            displayPanel.update(null);
        });

    }

}