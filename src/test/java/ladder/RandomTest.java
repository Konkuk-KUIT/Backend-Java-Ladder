package ladder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.core.LadderSize;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    @DisplayName("랜덤 사다리 실행 결과")
    void LadderRun() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(ladderSize);

        ladderGame.run(Position.of(0));

        assertNotNull(ladderGame);
    }
}
