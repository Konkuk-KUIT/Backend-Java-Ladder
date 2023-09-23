package ladder;

import ladder.creator.LadderHumanCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 출력_테스트(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderHumanGame = LadderGameFactory.getLadderHumanGame(ladderSize);

        LadderHumanCreator ladderHumanCreator = (LadderHumanCreator) ladderHumanGame.getLadderCreator();
        ladderHumanCreator.drawLine(Position.of(0), Position.of(0));
        ladderHumanCreator.drawLine(Position.of(1), Position.of(1));

        Row[] rows = ladderHumanCreator.getRows();

        String strings = "";
        String[] answer = {" 1-1 0", " 0 1-1"," 0 0 0"};
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            String rowLine = rows[i].getLine().replace("\t", ""); // 탭 문자를 공백으로 대체
            strings = rowLine;
            assertEquals(strings,answer[i]);
        }
    }

    @Test
    void 별_출력_테스트(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderHumanGame = LadderGameFactory.getLadderHumanGame(ladderSize);

        LadderHumanCreator ladderHumanCreator = (LadderHumanCreator) ladderHumanGame.getLadderCreator();
        ladderHumanCreator.drawLine(Position.of(0), Position.of(0));
        ladderHumanCreator.drawLine(Position.of(1), Position.of(1));

        Row[] rows = ladderHumanCreator.getRows();

        String strings = "";
        String[] answer = {" 1*-1 0", " 0 1*-1"," 0 0 0*"};
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            String rowLine = rows[i].getStarLine(i).replace("\t", ""); // 탭 문자를 공백으로 대체
            strings = rowLine;
            assertEquals(strings,answer[i]);
        }
    }

}