package ladder;

public abstract class LadderGameFactory {
    public LadderGame newLadderGame() {
        return createLadderGame();
    }
    protected abstract LadderGame createLadderGame();
}
