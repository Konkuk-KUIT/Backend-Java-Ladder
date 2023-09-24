package ladder;

import creator.LadderCreator;
import creator.RandomLadderCreator;

public class LadderGame {

    private final RandomLadderCreator ladderCreator;


    public LadderGame(RandomLadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position){
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }
}
