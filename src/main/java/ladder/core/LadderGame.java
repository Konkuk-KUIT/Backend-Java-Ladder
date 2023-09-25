package ladder.core;

import ladder.Direction;
import ladder.Ladder;
import ladder.LadderPosition;

public class LadderGame {

    private final CustomLadderCreator customLadderCreator = new CustomLadderCreator();
    private final Ladder ladder;
    private LadderRunner ladderRunner;

    public LadderGame(int numberOfRow, int numberOfPerson){
        this.ladder = customLadderCreator.createLadder(numberOfRow, numberOfPerson);
        this.ladderRunner = LadderRunner.of(ladder);
    }

    public int runGame(int start_position){
        return ladderRunner.run(start_position);
    }

    public void drawLine(int y, int x, Direction direction) {
        LadderPosition position = LadderPosition.of(y, x);
        customLadderCreator.drawLine(ladder, position, direction);
    }
}
