package ladder;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void moveRight() {
        position += 1;
    }

    public void moveLeft() {
        position -= 1;
    }

    public static Position setPosition(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int num) {
        if (!isPosition(num)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isPosition(int num) {
        return num >= 0;
    }

    public boolean isSmaller(int position) {
        return this.position < position;
    }

    public boolean isBigger(int position) {
        return this.position > position;
    }

    public boolean isBiggerOrEqual(int position) {
        return this.position >= position;
    }

    public boolean isSmallerOrEqual(int position){
        return this.position <= position;
    }

}
