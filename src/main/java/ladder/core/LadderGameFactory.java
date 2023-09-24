package ladder.core;

import ladder.creator.NormalLadderCreator;
import ladder.creator.RandomLadderCreator;


public class LadderGameFactory{
    private LadderGameFactory() {}

    public static LadderGame randomLadderGame(LadderSize ladderSize) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        return new LadderGame(randomLadderCreator);
    }

    public static LadderGame normalLadderGame(LadderSize ladderSize) {
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(ladderSize);
        return new LadderGame(normalLadderCreator);
    }
}