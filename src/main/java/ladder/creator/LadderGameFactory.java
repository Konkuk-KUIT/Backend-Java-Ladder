package ladder.creator;

import ladder.LadderGame;
import ladder.LadderSize;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(LadderCreator ladderCreator){
        LadderGame ladderGame;
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderCreator);
        LadderSize ladderSize = ladderCreator.getLadderSize();
        randomLadderCreator.autoLineConstruct(ladderSize);
        ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }
}
