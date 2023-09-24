package ladder;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
    void drawLine_테스트(){
        //given
        int numberOfPerson = 2;

        Row row = new Row(numberOfPerson);

        //when
        row.drawLine(1);

        //then
        assertThat(row.nextPosition(1)).isEqualTo(2);
        assertThat(row.nextPosition(2)).isEqualTo(1);

    }

    @Test
    void run_테스트_빈_사다리(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then (빈 사다리)
        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(3);
        assertThat(ladder.run(5)).isEqualTo(5);
    }
    @Test
    public void run_테스트_라인_있을때(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        ladder.drawLine(0,1);
        ladder.drawLine(1, 2);
        ladder.drawLine(1, 4);
        ladder.drawLine(2, 4);

        //then
        assertThat(ladder.run(1)).isEqualTo(3);
        assertThat(ladder.run(2)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(2);
        assertThat(ladder.run(4)).isEqualTo(4);
        assertThat(ladder.run(5)).isEqualTo(5);
    }

    @Test
    public void 인원_예외_테스트(){
        //given
        int numberOfRow = 5;
        int numberOfPerson = 0;
        //when

        //then
        assertThrows(RuntimeException.class, () -> new Ladder(numberOfRow, numberOfPerson));
    }
    @Test
    public void drawLine_예외_테스트_배열에_맞는값(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        //when

        //then
        assertThrows(RuntimeException.class, () -> ladder.drawLine(0, 6));
        assertThrows(RuntimeException.class, () -> ladder.drawLine(3, 1));
        assertThrows(RuntimeException.class, () -> ladder.drawLine(1, 0));
    }

    @Test
    public void drawLine_예외_테스트_이미_값이_존재(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        ladder.drawLine(1, 1);

        //then
        assertThrows(RuntimeException.class, () -> ladder.drawLine(1, 2));
    }

}