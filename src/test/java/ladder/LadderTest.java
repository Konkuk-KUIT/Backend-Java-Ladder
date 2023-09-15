package ladder;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        int numberOfRow = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        ladder.drawLine(1,1);
        //then
        int[][] rows = ladder.getRows();
        assertThat(rows[0][0]).isEqualTo(1);
        assertThat(rows[0][1]).isEqualTo(-1);
    }

    @Test
    void run_테스트() throws Exception{
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        //when

        //then
        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(2)).isEqualTo(2);

        //when
        ladder.drawLine(1,1);
        //then
        assertThat(ladder.run(1)).isEqualTo(2);
        assertThat(ladder.run(2)).isEqualTo(1);
    }

}