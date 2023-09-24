package ladder.creator;

import ladder.*;

public interface LadderCreator {

    void drawLine(LadderPosition ladderPosition);

    Row[] getRows();

}
