package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {

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
        Position position = Position.of(1);
        Position nextPosition = leftNode.move(position);
        assertEquals(0, nextPosition.getValue());
    }

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        Position position = Position.of(1);
        Position nextPosition = rightNode.move(position);
        assertEquals(2, nextPosition.getValue());
    }

    @Test
    void 방향_없을_때_방향_위치_이동_확인() {
        Position position = Position.of(1);
        Position nextPosition = noneNode.move(position);
        assertEquals(0, nextPosition.getValue());
    }
}