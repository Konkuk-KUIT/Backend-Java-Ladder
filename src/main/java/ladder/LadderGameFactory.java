package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderHumanCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGameFactory {


    //메서드1
    public static LadderGame getLadderHumanGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new LadderHumanCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }

    //메서드2
    public static LadderGame getLadderRandomGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new LadderRandomCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }
}
