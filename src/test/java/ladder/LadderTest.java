package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 라인_생성_확인(){
        int numberOfRow = 4;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        Position p1=new Position(0,1);
        Position p2=new Position(1,2);
        Position p3=new Position(2,0);
        Position p4=new Position(3,2);
        ladder.drawLine(p1);
        ladder.drawLine(p2);
        ladder.drawLine(p3);
        ladder.drawLine(p4);
        assertEquals(1,ladder.checkLine(p1));
        assertEquals(1,ladder.checkLine(p2));
        assertEquals(1,ladder.checkLine(p3));
        assertEquals(1,ladder.checkLine(p4));
    }

    @Test
    void 이동_확인(){
        int numberOfRow = 4;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        Position p1=new Position(0,1);
        Position p2=new Position(1,2);
        Position p3=new Position(2,0);
        Position p4=new Position(3,2);
        ladder.drawLine(p1);
        ladder.drawLine(p2);
        ladder.drawLine(p3);
        ladder.drawLine(p4);
        ladder.setStart(2);
        ladder.move();
        ladder.move();
        ladder.move();
        ladder.move();
        assertEquals(4,ladder.getCurLoc().row);
        assertEquals(2,ladder.getCurLoc().col);
    }

    @Test
    void 실행_확인(){
        int numberOfRow = 4;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        Position p1=new Position(0,1);
        Position p2=new Position(1,2);
        Position p3=new Position(2,0);
        Position p4=new Position(3,2);
        ladder.drawLine(p1);
        ladder.drawLine(p2);
        ladder.drawLine(p3);
        ladder.drawLine(p4);
        assertEquals(5,ladder.run(5));
    }
}