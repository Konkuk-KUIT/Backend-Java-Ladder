package ladder;

import ladder.core.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderSumulationTest {

    private LadderGame ladderGame;

    /*  LEFT : -1,  RIGHT : 1
    {{0, 0, 0, 0, 0},
    {1, -1, 1, -1, 0},
    {0, 0, 0, 1, -1},
    {0, 1, -1, 0, 0},
    {0, 0, 1, -1, 0}}
     */
    @BeforeEach
    void setup_ladder(){
        ladderGame = new LadderGame(5, 5);
        ladderGame.drawLine(1, 1, Direction.LEFT);
        ladderGame.drawLine(1, 2, Direction.RIGHT);
        ladderGame.drawLine(2, 3, Direction.RIGHT);
        ladderGame.drawLine(3, 2, Direction.LEFT);
        ladderGame.drawLine(4, 3, Direction.LEFT);
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
            results[idx] = ladderGame.runGame(players[idx]);
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
