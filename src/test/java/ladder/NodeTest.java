package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("왼쪽 이동 확인")
    void moveLeft() {
        //given
        Position currentPosition = Position.of(2);
        //when
        Position nextPosition = leftNode.move(currentPosition);
        //then
        assertEquals(1, nextPosition.getPosition());
    }

    @Test
    @DisplayName("오른쪽 이동 확인")
    void moveRight() {
        //given
        Position currentPosition = Position.of(2);
        //when
        Position nextPosition = rightNode.move(currentPosition);
        //then
        assertEquals(3, nextPosition.getPosition());
    }

    @Test
    @DisplayName("방향 없을 때 이동 확인")
    void moveDown() {
        //given
        Position initialPosition = Position.of(2);
        //when
        Position nextPosition = noneNode.move(initialPosition);
        //then
        assertEquals(2, nextPosition.getPosition());
    }

    @Test
    @DisplayName("")
    void checkRight() {
        //given
        assertTrue(rightNode.isRight());
        //when
        assertFalse(leftNode.isRight());
        //then
        assertFalse(noneNode.isRight());
    }

    @Test
    @DisplayName("")
    void checkLeft() {
        //given
        assertTrue(leftNode.isLeft());
        //when
        assertFalse(rightNode.isLeft());
        //then
        assertFalse(noneNode.isLeft());
    }
}
