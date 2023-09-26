package ladder;

import creator.CustomLadderCreator;
import creator.LadderCreator;
import creator.RandomLadderCreator;

public class LadderGameFactory {

    private final LadderCreator ladderCreator;

    public LadderGameFactory(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame createRandomLadderGame(RandomLadderCreator ladderCreator){
        return new LadderGame(ladderCreator);
    }

    public static LadderGame createCustomLadderGame(CustomLadderCreator ladderCreator){
        return new LadderGame(ladderCreator);
    }

    public int run(Position position){
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }

}
