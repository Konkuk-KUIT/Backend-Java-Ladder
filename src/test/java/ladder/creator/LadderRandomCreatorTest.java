package ladder.creator;

import ladder.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderRandomCreatorTest {

    @Test
    void 랜덤_숫자_중복_테스트(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(ladderSize);

        ladderRandomCreator.getPositionSize();
        ladderRandomCreator.getPositionSize();
        ladderRandomCreator.getPositionSize();
        ladderRandomCreator.getPositionSize();

        ladderRandomCreator.printHash();

    }

    @Test
    void 랜덤_숫자_실행_테스트(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderRandomGame = LadderGameFactory.getLadderRandomGame(ladderSize);

        ladderRandomGame.run(Position.of(1));


    }

}