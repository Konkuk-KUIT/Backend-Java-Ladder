package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderSumulationTest {

    private Ladder ladder;

    /*  LEFT : -1,  RIGHT : 1
    {{0, 0, 0, 0, 0},
    {1, -1, 1, -1, 0},
    {0, 0, 0, 1, -1},
    {0, 1, -1, 0, 0},
    {0, 0, 1, -1, 0}}
     */
    @BeforeEach
    void setup_ladder(){
        ladder = new Ladder(5, 5);
        ladder.drawLine(new Point(1, 1), Direction.LEFT);
        ladder.drawLine(new Point(2, 1), Direction.RIGHT);
        ladder.drawLine(new Point(3, 2), Direction.RIGHT);
        ladder.drawLine(new Point(2, 3), Direction.LEFT);
        ladder.drawLine(new Point(3, 4), Direction.LEFT);
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
            results[idx] = ladder.run(players[idx]);
        }

        // then
        assertThat(results).isEqualTo(answers);
    }
}
