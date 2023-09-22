package ladder;

import ladder.creator.DefaultLadderCreator;
import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }


    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }

    public int printLadder(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.runWithLog(position);
    }
}
