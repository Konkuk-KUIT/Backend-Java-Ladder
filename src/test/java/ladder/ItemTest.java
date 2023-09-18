package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Item.generateItem;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void 왼쪽_이동_테스트() {
        Item leftItem = generateItem(-1);
        Position pos = Position.setPosition(1);
        leftItem.move(pos);
        assertEquals(0, pos.getPosition());
    }

    @Test
    void 오른쪽_이동_테스트(){
        Item rightItem = generateItem(1);
        Position pos = Position.setPosition(1);
        rightItem.move(pos);
        assertEquals(2, pos.getPosition());
    }


}