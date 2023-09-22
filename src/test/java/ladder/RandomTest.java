package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTest {
    //생성
    //작동
    //출력
    @Test
    @DisplayName("랜덤 사다리 실행 결과")
    void LadderRun() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(1));
        ladderCreator.drawLine(Position.of(2), Position.of(0));
    }
}
