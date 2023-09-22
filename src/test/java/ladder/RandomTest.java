package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    @DisplayName("랜덤 사다리 실행 결과")
    void LadderRun() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        Random random = new Random(ladderSize);
        //when
        for (int i = 0; i < random.lineCount(ladderSize); i++) {
            try {
                ladderCreator.drawLine(random.startRow(ladderSize), random.startPosition(ladderSize));
            } catch (IllegalArgumentException e1) {
                i--;
            }
        }
        //then
        ladderGame.run(Position.of(0));

//        LadderGame ladderGame = new LadderGame(ladderCreator);
//
//        ladderCreator.drawLine(Position.of(0), Position.of(0));
//        ladderCreator.drawLine(Position.of(1), Position.of(1));
//        ladderCreator.drawLine(Position.of(2), Position.of(0));
    }
}
