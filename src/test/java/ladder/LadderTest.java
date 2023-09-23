package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderHumanCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    LadderCreator ladderCreator;

    @DisplayName("사다리 생성")
    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator = new LadderHumanCreator(ladderSize);

        //then
        assertNotNull(ladderCreator);
    }

    // 모든 테스트에서 공통적으로 사다리 생성이 되므로 이를 줄이기 위해서 BeforEach로 각 테스트 실행전에 사다리를 생성하게 함
    @BeforeEach
    void setup(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderHumanGame = LadderGameFactory.getLadderHumanGame(ladderSize);
        ladderHumanGame.run(Position.of(1));


        ladderCreator = new LadderHumanCreator(ladderSize);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderCreator ladderCreator = new LadderHumanCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, ()->ladderGame.run(position));
    }

    @DisplayName("drawLine 예외 확인")
    @Test
    void 사다리_줄그리기_예외(){

        //when
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(1),Position.of(3));

        assertAll(
                //줄을 그으려고 하는 사다리 오른쪽에 이미 줄이 그어졌을 때
                ()->assertThrows(Exception.class, ()->ladderCreator.drawLine(Position.of(1),Position.of(2))),
                // 사다리 높이가 생성된 사다리 높이보다 높을 때
                ()->assertThrows(Exception.class, ()->ladderCreator.drawLine(Position.of(4),Position.of(2))),
                // 이미 줄이 그어진 곳에 줄을 그리려고 할 때
                ()->assertThrows(Exception.class, ()->ladderCreator.drawLine(Position.of(1),Position.of(1))),
                // 줄을 그을 수 없는 사다리를 선택했을 때때
                ()->assertThrows(Exception.class, ()->ladderCreator.drawLine(Position.of(4),Position.of(1)))
        );
    }

    @DisplayName("run 확인")
    @Test
    public void run_확인(){
        //given
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        ladderCreator.drawLine(Position.of(0),Position.of(0));
        ladderCreator.drawLine(Position.of(0),Position.of(2));
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(2),Position.of(3));

        Position position = Position.of(1);


        //then
        int answer = ladderGame.run(position); //사다리는 0~4까지 있음 (5명이 하기 때문에)
        assertEquals(answer,0);

    }


    @DisplayName("사다리 출력 테스트")
    @Test
    public void 사다리_출력_확인(){

        LadderGame ladderGame = new LadderGame(ladderCreator);
        //when
        ladderCreator.drawLine(Position.of(0),Position.of(0));
        ladderCreator.drawLine(Position.of(0),Position.of(2));
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(2),Position.of(3));

        ladderGame.run(Position.of(3));
    }
}