package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        LadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        randomLadderCreator.drawLine();
        return new LadderGame(randomLadderCreator);
    }

}
