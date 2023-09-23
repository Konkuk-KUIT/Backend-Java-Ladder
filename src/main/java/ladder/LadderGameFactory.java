package ladder;

public abstract class LadderGameFactory {
    public NormalLadderGame newLadderGame() {
        return createLadderGame();
    }
    protected abstract NormalLadderGame createLadderGame();
}
