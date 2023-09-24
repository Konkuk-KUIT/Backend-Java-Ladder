package ladder;

import ladder.core.LadderSize;
import ladder.utils.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderSizeTest {

    @Test
    void 사다리_크기_가져오기() {
        LadderSize ladderSize = LadderSize.of(NaturalNumber.of(1), NaturalNumber.of(1));
        assertEquals(1,ladderSize.getHeight());
        assertEquals(1,ladderSize.getWidth());
    }
}