package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderHumanCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    LadderCreator ladderCreator;

    @Test
    void Human_run_test(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderHumanGame = LadderGameFactory.getLadderHumanGame(ladderSize);
        LadderHumanCreator ladderHumanCreator = (LadderHumanCreator) ladderHumanGame.getLadderCreator();
        ladderHumanCreator.drawLine(Position.of(1),Position.of(1));
        ladderHumanCreator.drawLine(Position.of(0),Position.of(0));
        ladderHumanCreator.drawLine(Position.of(2),Position.of(2));
        ;

        ladderHumanGame.run(Position.of(1));

    }

    @Test
    void Random_run_test(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderRandomGame = LadderGameFactory.getLadderRandomGame(ladderSize);
        ladderRandomGame.run(Position.of(1));

    }
}