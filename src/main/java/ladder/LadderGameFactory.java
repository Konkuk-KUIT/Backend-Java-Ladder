package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderRandomCreate;
import ladder.creator.LadderCreate;
public class LadderGameFactory {

    public static LadderGame createLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        LadderCreator ladderCreator = new LadderCreate(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;

    }
    /* 사다리 라인을 그리는 작업은???
            -> 사다리 라인을 만들 위치를 입력받아 사다리를 만들고 테스트를 진행해야 함
            -> 위 메서드로는 테스트 코드에서 drawLine메서드를 통해 사다리 라인을 만들 위치를 입력받지 못함
            -> 위 메서드로 사다리 게임을 만들지는 못했음
    */

    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        LadderCreator ladderCreator = new LadderRandomCreate(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }

}