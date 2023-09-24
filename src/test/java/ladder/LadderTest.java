package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_그리기_범위_확인() {
        //given
        int x = 7;
        int y = 2;

        //when
        Ladder ladder = new Ladder(4, 5);

        //then
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            ladder.drawLine(x,y);
        });
        System.out.println(exception.getMessage());

    }

}