package ladder;

import ladder.Exception.ErrorCode;
import ladder.Exception.ErrorMessage;
import ladder.Exception.LadderPositionOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreationTest {

    private Ladder ladder;
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
        ladderCreator = new LadderCreator();
        ladder = ladderCreator.createLadder(5, 5);
    }

    @Test
    @DisplayName("빈 사다리 생성")
    void create_empty_ladder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        LadderCreator new_ladder_creator = new LadderCreator();
        Ladder new_ladder_obj = new_ladder_creator.createLadder(numberOfRow, numberOfPerson);
        Node[][] new_ladder = (Node[][])getPrivateField(new_ladder_obj, "ladder");

        //then
        assertThat(new_ladder_creator).isNotNull();
        assertThat(new_ladder_obj).isNotNull();
        assertThat(new_ladder).isNotNull();
        assertThat(new_ladder.length).isEqualTo(3);
        assertThat(new_ladder[0]).hasSize(5);
        // 각 행의 요소가 is_NONE() 메서드를 통과하는지 검사
        for (Node[] row : new_ladder) {
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
        ladderCreator.drawLine(ladder, legPoint_1, direction_1);
        ladderCreator.drawLine(ladder, legPoint_2, direction_2);
        Node[][] drawed_ladder = (Node[][])getPrivateField(ladder, "ladder");


        // then
        assertThat(drawed_ladder[2][3].is_NONE()).isFalse();
        assertThat(drawed_ladder[2][4].is_NONE()).isFalse();
        assertThat(drawed_ladder[4][4].is_NONE()).isFalse();
        assertThat(drawed_ladder[4][3].is_NONE()).isFalse();
    }

    @Test
    @DisplayName("높이보다 높은 곳에 다리 생성 실패")
    void drawLadderHeightOOBException(){
        // given
        LadderPosition point = LadderPosition.of(5, 3);
        Direction direction = Direction.RIGHT;

        //when

        // then
        assertThatThrownBy(() -> ladderCreator.drawLine(ladder, point, direction))
                .isInstanceOf(LadderPositionOutOfBoundsException.class)
                .hasMessage(ErrorMessage.LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION.getErrorMessage())
                .extracting(ex -> (LadderPositionOutOfBoundsException) ex)
                .satisfies(ex -> {
                    assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION.getCode());
                });
    }

    @Test
    @DisplayName("너비보다 큰 곳에 다리 생성 실패")
    void drawLadderWidthOOBException(){
        // given
        LadderPosition point = LadderPosition.of(3, 4);
        Direction direction = Direction.RIGHT;

        //when

        // then
        assertThatThrownBy(() -> ladderCreator.drawLine(ladder, point, direction))
                .isInstanceOf(LadderPositionOutOfBoundsException.class)
                .hasMessage(ErrorMessage.LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION.getErrorMessage())
                .extracting(ex -> (LadderPositionOutOfBoundsException) ex)
                .satisfies( ex -> {
                    assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION.getCode());
                });
    }

    @Test
    @DisplayName("원점보다 작은 곳에 다리 생성 실패")
    void drawLadderZeroOOBException(){
        // given
        LadderPosition point = LadderPosition.of(0, 0);
        Direction direction = Direction.LEFT;

        //when

        // then
        assertThatThrownBy(() -> ladderCreator.drawLine(ladder, point, direction))
                .isInstanceOf(LadderPositionOutOfBoundsException.class)
                .hasMessage(ErrorMessage.LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION.getErrorMessage())
                .extracting(ex -> (LadderPositionOutOfBoundsException) ex)
                .satisfies( ex -> {
                    assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.LADDER_ZERO_OUT_OF_BOUND_EXCEPTION.getCode());
                });
    }
}