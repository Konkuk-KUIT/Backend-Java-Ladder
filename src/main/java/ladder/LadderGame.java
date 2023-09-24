package ladder;

public class LadderGame {

    private final LadderCreator ladderCreator = new LadderCreator();
    private final Ladder ladder;
    private LadderRunner ladderRunner;

    public LadderGame(int numberOfRow, int numberOfPerson){
        this.ladder = ladderCreator.createLadder(numberOfRow, numberOfPerson);
        this.ladderRunner = LadderRunner.of(ladder);
    }

    public int runGame(int start_position){
        return ladderRunner.run(start_position);
    }

    public void drawLine(int y, int x, Direction direction) {
        LadderPosition position = LadderPosition.of(y, x);
        ladderCreator.drawLine(ladder, position, direction);
    }
}
