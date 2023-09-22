package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(this.ladderCreator.getRow());
        return ladderRunner.run(position);
    }
}
