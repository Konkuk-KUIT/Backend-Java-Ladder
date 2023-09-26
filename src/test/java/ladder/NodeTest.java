package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    private Node leftNode;
    private Node rightNode;
    private Node noneNode;

    @BeforeEach
    void setUp(){
        leftNode = Node.of(Direction.LEFT);
        rightNode = Node.of(Direction.RIGHT);
        noneNode = Node.of(Direction.NONE);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인(){
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = leftNode.move(position);

        //then
        assertEquals(0, nextPosition.getValue());
    }

    @Test
    void 오른쪽_방향_위치_이동_확인(){
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = rightNode.move(position);

        //then
        assertEquals(2, nextPosition.getValue());
    }

    @Test
    void 방향_없을_때_위치_이동_확인(){
        //given
        Position position = Position.of(1);

        //when
        Position nextPosition = noneNode.move(position);

        //then
        assertEquals(1, nextPosition.getValue());
    }
}