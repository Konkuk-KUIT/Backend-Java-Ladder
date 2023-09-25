package ladder.core;

import ladder.Direction;
import ladder.Ladder;
import ladder.LadderPosition;

public class CustomLadderCreator implements LadderCreator {

    @Override
    public Ladder createLadder(int numberOfRow, int numberOfPerson){
        return Ladder.of(numberOfRow, numberOfPerson);
    }

    @Override
    public void drawLine(Ladder ladder, LadderPosition position, Direction direction) {
        LadderPosition crossed_position = LadderPosition.of(position.getY(), position.getX() + direction.getDirection());
        ladder.setNode(position, direction);
        ladder.setNode(crossed_position, direction.reverse());
    }
}
