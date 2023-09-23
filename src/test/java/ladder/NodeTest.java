package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {

    private Node leftNode;
    private Node rightNode;
    private Node noneNode;

    @BeforeEach
    void setUp() {
        leftNode = Node.of(Direction.LEFT);
        rightNode = Node.of(Direction.RIGHT);
        noneNode = Node.of(Direction.NONE);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = leftNode.move(position);

        //then
        Assertions.assertEquals(0, nextPosition.getPosition());
    }

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = rightNode.move(position);

        //then
        Assertions.assertEquals(2, nextPosition.getPosition());
    }

    @Test
    void 방향_없음_위치_이동_확인() {
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = noneNode.move(position);

        //then
        Assertions.assertEquals(1, nextPosition.getPosition());
    }
}
