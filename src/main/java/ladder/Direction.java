package ladder;

public enum Direction {
    LEFT(-1), RIGHT(1), NONE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRight() {
        return this.value == RIGHT.getValue();
    }

    public boolean isLeft() {
        return this.value == LEFT.getValue();
    }

    public boolean isNone() {
        return this.value == NONE.getValue();
    }
}