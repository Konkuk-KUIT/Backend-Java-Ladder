package ladder;

import org.junit.jupiter.api.Test;

class LadderPlayerPrintTest {
    @Test
    public void testshowPlayer(){
        Ladder ladder = new Ladder(4,4);

        ladder.drawLine(1, 1);
        ladder.drawLine(1, 3);
        ladder.drawLine(2, 1);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 3);

        //LadderPlayerPrint.printRun(1);
        //LadderPlayerPrint.printRun(2);
        //LadderPlayerPrint.printRun(3);
        //LadderPlayerPrint.printRun(4);
    }

}