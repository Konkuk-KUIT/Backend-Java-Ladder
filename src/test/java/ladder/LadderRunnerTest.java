package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.StaticLadderCreator;
import org.junit.jupiter.api.Test;

public class LadderRunnerTest {

    @Test
    void 게임_결과_출력() {
        NaturalNumber numberOfRow = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(5);

        LadderCreator ladderCreator = new StaticLadderCreator(numberOfRow, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        ladderRunner.PrintLadder();
    }
}
