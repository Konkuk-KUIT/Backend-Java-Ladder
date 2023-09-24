package ladder.creator;

import ladder.LadderGame;
import ladder.LadderSize;

public class LadderGameFactory {
    public static LadderGame getLadderManulGame(LadderSize ladderSize){
        LadderManualCreator ladderManualCreator = new LadderManualCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderManualCreator);
        return ladderGame;
    }

    public static LadderGame getLadderRandomGame(LadderSize ladderSize){
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderRandomCreator);
        return ladderGame;
    }


}
