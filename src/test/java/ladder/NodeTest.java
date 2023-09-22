package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    private Node leftNode = Node.of(Direction.LEFT);
    private Node rightNode = Node.of(Direction.RIGHT);
    private Node noneNode = Node.of(Direction.NONE);

    @Test
    void 움직임_확인() {
        Position position = Position.of(2);
        assertEquals(Position.of(3).getValue(), rightNode.move(position).getValue());

        assertEquals(Position.of(1).getValue(), leftNode.move(position).getValue());
    }
}