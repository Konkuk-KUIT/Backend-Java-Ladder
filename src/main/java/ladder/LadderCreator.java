package ladder;

import java.awt.*;

public class LadderCreator {

    public Ladder createLadder(int numberOfRow, int numberOfPerson){
        return Ladder.of(numberOfRow, numberOfPerson);
    }

    public void drawLine(Ladder ladder, LadderPosition position, Direction direction) {
        LadderPosition crossed_position = LadderPosition.of(position.getY(), position.getX() + direction.getDirection());
        ladder.setNode(position, direction);
        ladder.setNode(crossed_position, direction.reverse());
    }
}
