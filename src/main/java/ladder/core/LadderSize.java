package ladder.core;

import ladder.utils.NaturalNumber;

public class LadderSize {
    NaturalNumber height;
    NaturalNumber width;

    private LadderSize(NaturalNumber height, NaturalNumber width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height.getNumber();
    }

    public int getWidth() {
        return width.getNumber();
    }

    public int getNumberOfNodes() {
        return height.getNumber() * width.getNumber();
    }

    public static LadderSize of(NaturalNumber height, NaturalNumber width) {
        return new LadderSize(height, width);
    }
}
