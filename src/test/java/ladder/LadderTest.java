package ladder;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson =  NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void drawLine_테스트(){
        //given
        NaturalNumber numberOfPerson =  NaturalNumber.of(2);

        Row row = new Row(numberOfPerson);

        //when
        row.drawLine(Position.of(1));

        //then
        assertThat(row.nextPosition(Position.of(1)).getValue()).isEqualTo(2);
        assertThat(row.nextPosition(Position.of(2)).getValue()).isEqualTo(1);

    }

    @Test
    void run_테스트_빈_사다리(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson =  NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then (빈 사다리)
        assertThat(ladder.run(Position.of(1))).isEqualTo(1);
        assertThat(ladder.run(Position.of(3))).isEqualTo(3);
        assertThat(ladder.run(Position.of(5))).isEqualTo(5);
    }
    @Test
    public void run_테스트_라인_있을때(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson =  NaturalNumber.of(5);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        ladder.drawLine(Position.of(0), Position.of(1));
        ladder.drawLine(Position.of(1), Position.of(2));
        ladder.drawLine(Position.of(1), Position.of(4));
        ladder.drawLine(Position.of(2), Position.of(4));

        //then
        assertThat(ladder.run(Position.of(1))).isEqualTo(3);
        assertThat(ladder.run(Position.of(2))).isEqualTo(1);
        assertThat(ladder.run(Position.of(3))).isEqualTo(2);
        assertThat(ladder.run(Position.of(4))).isEqualTo(4);
        assertThat(ladder.run(Position.of(5))).isEqualTo(5);
    }

    @Test
    public void 인원_예외_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new NaturalNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    public void drawLine_예외_테스트_배열에_맞는값(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson =  NaturalNumber.of(5);

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(Position.of(0),Position.of(6)));
//        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(Position.of(3),Position.of(1))); // numberOfRow보다 큰 값이 drawline에 입력으로 들어왔을때
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(Position.of(1),Position.of(0)));
    }

    @Test
    public void drawLine_예외_테스트_이미_값이_존재(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson =  NaturalNumber.of(5);

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        ladder.drawLine(Position.of(1), Position.of(1));

        //then
        assertThrows(RuntimeException.class, () -> ladder.drawLine(Position.of(1), Position.of(2)));
    }

}