package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    //Getter를 최대한 이용하지 않기 위해 position 연산은 객체 내부에서 처리해준다.
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
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
