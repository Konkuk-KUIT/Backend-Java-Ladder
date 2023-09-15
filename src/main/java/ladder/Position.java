package ladder;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException("사다리 위치는 1이상 자연수입니다.");
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
