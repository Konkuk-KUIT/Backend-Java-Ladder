package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void RunLadderGame() {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.PrintLadderGameResult();
    }
}
