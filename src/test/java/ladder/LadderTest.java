package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.Position.setPosition;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    @DisplayName("만든 사다리보다 사람이 많을 때")
    void validatePersonOverflow() {
        //given
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(1, numberOfPerson);

        //when
        Position position = setPosition(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //when
        int numberOfPerson = 3;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(setPosition(0),setPosition(1));
        ladder.drawLine(setPosition(1),setPosition(0));
        ladder.drawLine(setPosition(2),setPosition(1));

        //given
        Position startPosition = setPosition(0);

        //then
        assertEquals(2, ladder.run(startPosition));

        startPosition = setPosition(1);

        //then
        assertEquals(1, ladder.run(startPosition));

        //given
        startPosition = setPosition(2);

        //then
        assertEquals(0, ladder.run(startPosition));
    }

}