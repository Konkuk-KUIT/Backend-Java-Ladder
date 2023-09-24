package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderSumulationTest {

    private Ladder ladder;
    private LadderRunner ladderRunner;

    /*  LEFT : -1,  RIGHT : 1
    {{0, 0, 0, 0, 0},
    {1, -1, 1, -1, 0},
    {0, 0, 0, 1, -1},
    {0, 1, -1, 0, 0},
    {0, 0, 1, -1, 0}}
     */
    @BeforeEach
    void setup_ladder(){
        LadderCreator ladderCreator = new LadderCreator();
        ladder = ladderCreator.createLadder(5, 5);
        ladderCreator.drawLine(ladder, LadderPosition.of(1, 1), Direction.LEFT);
        ladderCreator.drawLine(ladder, LadderPosition.of(1, 2), Direction.RIGHT);
        ladderCreator.drawLine(ladder, LadderPosition.of(2, 3), Direction.RIGHT);
        ladderCreator.drawLine(ladder, LadderPosition.of(3, 2), Direction.LEFT);
        ladderCreator.drawLine(ladder, LadderPosition.of(4, 3), Direction.LEFT);
        ladderRunner = LadderRunner.of(ladder);
    }


    @Test
    @DisplayName("사다리 도착지점")
    void run_ladder(){
        // given
        int[] players = {0, 1, 2, 3, 4};
        int[] answers = {3, 0, 4, 1, 2};

        // when
        int[] results = new int[5];
        for (int idx = 0; idx < players.length; idx++){
            results[idx] = ladderRunner.run(players[idx]);
        }

        // then
        assertThat(results).isEqualTo(answers);
    }

//    @Test
//    @DisplayName("사다리 출력")
//    void print_ladder(){
//        // given
//        int start = 0;
//        OutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        final String ladder_print =
//                        "-------- 사다리 게임 시작 ---------\n" +
//                                "0* 0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1* -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1* 1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0* 0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1* -1  0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1* 0  0\n" +
//                                "0  0  1  -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1* -1  0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1* 0\n" +
//                                "\n" +
//                                "0  0  0  0  0\n" +
//                                "1  -1  1  -1  0\n" +
//                                "0  0  0  1  -1\n" +
//                                "0  1  -1  0  0\n" +
//                                "0  0  1  -1  0";
//
//
//        // when
//        ladderRunner.run(start);
//        String output = out.toString();
//
//        // then
//        assertThat(output).isEqualTo(ladder_print);
//    }

}
