package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderTest {

    @DisplayName("사다리 생성 확인")
    @Test
    void ladderCreatedConfirm() {
        //given
        int numberOfRow = 3;
        int numberOfCulumn = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfCulumn);
        //then
        assertNotNull(ladder);
    }

    @DisplayName("사다리 도착지점 정상 반환확인")
    @Test
    void testLadderReachesDestination(){
        //given
        int numberOfRow = 3;
        int numberOfCulumn = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfCulumn);
        //then
        int result = ladder.run(1);
        assertThat(result).isGreaterThan(0);
        assertThat(result).isInstanceOf(Integer.class);
        assertThat(result).isBetween(0, numberOfCulumn - 1);
    }

}