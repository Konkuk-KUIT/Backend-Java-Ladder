package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreationTest {

    private Node[][] ladder;
    private LadderCreator ladderCreator;

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
        ladderCreator = new LadderCreator(5, 5);
        ladder = ladderCreator.getLadder();
    }

    @Test
    @DisplayName("빈 사다리 생성")
    void create_empty_ladder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        LadderCreator new_ladder_creator = new LadderCreator(numberOfRow, numberOfPerson);
        Node[][] new_rows = (Node[][])getPrivateField(new_ladder_creator, "ladder");

        //then
        assertThat(new_ladder_creator).isNotNull();
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
        LadderPosition legPoint_1 = LadderPosition.of(2, 3);
        Direction direction_1 = Direction.RIGHT;
        LadderPosition legPoint_2 = LadderPosition.of(4, 4);
        Direction direction_2 = Direction.LEFT;

        // when
        ladderCreator.drawLine(legPoint_1, direction_1);
        ladderCreator.drawLine(legPoint_2, direction_2);
        Node[][] drawed_ladder = (Node[][])getPrivateField(ladderCreator, "ladder");


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
        LadderPosition legPoint_fail_1 = LadderPosition.of(4, 6);
        Direction direction_1 = Direction.RIGHT;
        LadderPosition legPoint_fail_2 = LadderPosition.of(0, 0);
        Direction direction_2 = Direction.LEFT;
        LadderPosition legPoint_success = LadderPosition.of(3, 1);
        Direction direction_success = Direction.RIGHT;
        LadderPosition legPoint_fail_3 = LadderPosition.of(3, 2);
        Direction direction_3 = Direction.RIGHT;


        // when
        ladderCreator.drawLine(legPoint_success, direction_success);

        // then
        // legPoint_fail_1을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladderCreator.drawLine(legPoint_fail_1, direction_1))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("사다리의 크기를 벗어나는 좌표를 지정하였습니다.");

        // legPoint_fail_2을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladderCreator.drawLine(legPoint_fail_2, direction_2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사다리의 노드좌표는 0이상의 값을 가져야 합니다.");

        // legPoint_fail_3을 사용하여 예외 테스트
        assertThatThrownBy(() -> ladderCreator.drawLine(legPoint_fail_3, direction_3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 지점에는 이미 사다리가 존재합니다.");
    }
}