package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("유저 테스트")
public class UserTest {

    Bridge bridge = new Bridge(
            List.of(
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U")
            ));

    @Test
    @DisplayName("사용자의 초기값 : step = 0, live = true")
    void initValue() {
        User user = new User();
        assertThat(user.getStep()).isEqualTo(0);
        assertThat(user.isLive()).isTrue();

        user.move(bridge, "U");
        user.init();
        assertThat(user.getStep()).isEqualTo(0);
        assertThat(user.isLive()).isTrue();
    }
}
