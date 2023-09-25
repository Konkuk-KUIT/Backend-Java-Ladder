package ladder.core;

import ladder.Direction;
import ladder.Ladder;
import ladder.LadderPosition;

public class RandomLadderCreator implements LadderCreator{
    CustomLadderCreator ladderCreator;

    RandomLadderCreator(CustomLadderCreator customLadderCreator){
        this.ladderCreator = customLadderCreator;
    }


    @Override
    public Ladder createLadder(int numberOfRow, int numberOfPerson) {
        return null;
    }

    @Override
    public void drawLine(Ladder ladder, LadderPosition position, Direction direction) {

    }
}
