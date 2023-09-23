package ladder;

public class NormalLadderGame {

    private final NormalLadderCreator normalLadderCreator;

    public NormalLadderGame(NormalLadderCreator normalLadderCreator) {
        this.normalLadderCreator = normalLadderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(normalLadderCreator.getRows());
        return ladderRunner.run(position);
    }
}
