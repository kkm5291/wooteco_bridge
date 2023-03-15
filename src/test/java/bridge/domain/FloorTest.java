package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("바닥 테스트")
class FloorTest {

    @Nested
    @DisplayName("바닥 생성 테스트")
    class floorStatus {
        @DisplayName("바닥 상태가 옳다")
        @ParameterizedTest(name = "바닥의 상태는 U,D 이다.")
        @CsvSource({"U", "D"})
        void goodStatus(String status) {
            assertDoesNotThrow(() -> {
                new Floor(status);
            });
        }

        @DisplayName("바닥 상태가 옳지 않다.")
        @ParameterizedTest(name = "바닥의 상태가 U,D가 아니면 예외")
        @CsvSource({"1", "a", "B", "C", "ADSFEFSDf"})
        void badStatus(String status) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Floor(status);
            });
        }
    }

    @Nested
    @DisplayName("부서지는 바닥인지 테스트")
    class floorBroken {

        @DisplayName("바닥이 부서진다")
        @ParameterizedTest(name = "바닥이 {0}이면 {1}일때 부서진다.")
        @CsvSource(value = {"U:D", "D:U"}, delimiter = ':')
        void floorBroken(String status, String input) {
            Floor floor = new Floor(status);
            assertFalse(floor.isSafe(input));
        }

        @DisplayName("바닥이 부서지지 않는다")
        @ParameterizedTest(name = "바닥이 {0}와 {1}가 같기 때문에 부서지지 않는다.")
        @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
        void floorSafe(String status, String input) {
            Floor floor = new Floor(status);
            assertTrue(floor.isSafe(input));
        }
    }

    @DisplayName("잘못된 입력")
    @ParameterizedTest(name = "입력한 상태가 U, D가 아니라면 예외")
    @CsvSource(value = {"D:ㅁㄻㄴㅇㄹ", "U:u", "D: 2", "U:down"}, delimiter = ':')
    void badInput(String status, String input) {
        Floor floor = new Floor(status);
        assertThrows(IllegalArgumentException.class, () -> {
            floor.isSafe(input);
        });
    }

//    @Nested
//    @DisplayName("완전 간단 테스트")
//    class test {
//        @DisplayName("불린 테스트")
//        @ParameterizedTest(name = "심플심플")
//        @CsvSource(value = {"U", "D"})
//        void simpleTest(String status) {
//            Floor floor = new Floor("u");
//            assertTrue(floor.isNotStatus("u"));
//        }
//
//    }

}
