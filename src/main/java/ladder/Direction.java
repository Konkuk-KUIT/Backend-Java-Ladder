package ladder;

public enum Direction {
    LEFT(-1), NONE(0), RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getOppositeValue() {
        if (this.value == LEFT.getValue())
            return RIGHT.getValue();
        if (this.value == RIGHT.getValue())
            return LEFT.getValue();
        return NONE.getValue();
    }
}