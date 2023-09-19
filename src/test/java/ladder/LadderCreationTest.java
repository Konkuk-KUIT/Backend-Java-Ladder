package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreationTest {

    private Ladder ladder;

    // 이 메서드는 private 필드에 접근하기 위한 유틸리티 메서드입니다.
    private Object getPrivateField(Object object, String fieldName) {
        try {
            java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @BeforeEach
    void setup_ladder(){
        ladder = new Ladder(5, 5);
    }

    @Test
    @DisplayName("빈 사다리 생성")
    void create_empty_ladder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder new_ladder = new Ladder(numberOfRow, numberOfPerson);
        Node[][] new_rows = (Node[][])getPrivateField(new_ladder, "ladder");

        //then
        assertThat(new_ladder).isNotNull();
        assertThat(new_rows.length).isEqualTo(3);
        assertThat(new_rows[0])
                .hasSize(5);
        // 각 행의 요소가 is_NONE() 메서드를 통과하는지 검사
        for (Node[] row : new_rows) {
            for (Node node : row) {
                assertThat(node.is_NONE()).isTrue();
            }
        }
    }

    @Test
    @DisplayName("사다리에 다리 생성 성공")
    void draw_ladder_leg_success() {
        //given
        Point legPoint_1 = new Point(3, 2);
        Direction direction_1 = Direction.RIGHT;
        Point legPoint_2 = new Point(4, 4);
        Direction direction_2 = Direction.LEFT;

        // when
        ladder.drawLine(legPoint_1, direction_1);
        ladder.drawLine(legPoint_2, direction_2);
        Node[][] drawed_ladder = (Node[][])getPrivateField(ladder, "ladder");


        // then
        assertThat(drawed_ladder[2][3].is_NONE()).isFalse();
        assertThat(drawed_ladder[2][4].is_NONE()).isFalse();
        assertThat(drawed_ladder[4][4].is_NONE()).isFalse();
        assertThat(drawed_ladder[4][3].is_NONE()).isFalse();
    }

    @Test
    @DisplayName("사다리에 다리 생성 실패")
    void draw_ladder_leg_fail(){
        // given
        Point legPoint_fail_1 = new Point(6, 4);
        Direction direction_1 = Direction.RIGHT;
        Point legPoint_fail_2 = new Point(0, 0);
        Direction direction_2 = Direction.LEFT;
        Point legPoint_success = new Point(1, 3);
        Direction direction_success = Direction.RIGHT;
        Point legPoint_fail_3 = new Point(2, 3);
        Direction direction_3 = Direction.RIGHT;


        // when
        ladder.drawLine(legPoint_success, direction_success);

        // then
        // legPoint_fail_1을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladder.drawLine(legPoint_fail_1, direction_1))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("사다리 범위 밖으로는 다리를 그릴 수 없습니다.");

        // legPoint_fail_2을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladder.drawLine(legPoint_fail_2, direction_2))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("사다리 범위 밖으로는 다리를 그릴 수 없습니다.");

        // legPoint_fail_3을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladder.drawLine(legPoint_fail_3, direction_3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 지점에는 이미 사다리가 존재합니다.");
    }
}