package ladder;

import ladder.creator.LadderRandomCreator;

public class LadderGame {
    private final LadderRandomCreator ladderCreator;

    public LadderGame(LadderRandomCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(this.ladderCreator.getRow());
        return ladderRunner.run(position);
    }
}
