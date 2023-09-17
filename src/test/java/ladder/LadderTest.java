package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    public void 사다리_동작_확인(){
        // 높이 2, 사람 3명인 사다리
        // (1,1)<->(1,2) & (2,2)<->(2,3) 사이에 사다리 라인 생성
        // 1번째 사다리를 타면 3이 출력되야 함

        // given
        int row = 2; int person = 3; int PositionNumber = 2;

        // when
        Ladder ladder = new Ladder(row, person);
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);

        // then
        assertEquals(3, ladder.run(1));
    }

    @Test
    public void 사다리_라인생성_입력오류(){
        // rows의 범위를 넘어가는 칸에 라인을 만들 때 오류 발생해야 함
        // 높이 2, 사람 3명인 사다리
        // (1,4)<->(1,5) 사이에 사다리 라인을 생성하는 경우

        int row = 2; int person = 3;
        Ladder ladder = new Ladder(row, person);
        assertThrows(Exception.class, () -> ladder.drawLine_InputErr(1,4));
    }

    @Test
    public void 사다리_오른쪽끝_라인생성_오류(){
        // 사다리 제일 오른쪽 열에서는 오른쪽으로 형성되는 사다리 라인을 가질 수 없음
        // 높이 2, 사람 3명인 사다리
        // rows[0][2] 요소의 값에 1이 저장되는 경우

        int row = 2; int person = 3;
        Ladder ladder = new Ladder(row, person);
        assertThrows(Exception.class, () -> ladder.drawLine_RightedgeErr(1,3));
    }

    @Test
    public void 사다리_라인_연결_생성오류(){
        // 사다리의 같은 층에서 drawLine()으로 그려지는 라인들이 서로 인접해 있으면 안됨
        // 높이 2, 사람 3명인 사다리
        // (1,1)<->(1,2) 사이에 사다리 라인이 생성된 후 (1,2)<->(1,3) 사이에도 사다리 라인이 생성되는 경우

        int row = 2; int person = 3;
        Ladder ladder = new Ladder(row, person);
        ladder.drawLine(1,1);
        assertThrows(Exception.class, () -> ladder.drawLine_ManylineErr(1,2));
    }


}