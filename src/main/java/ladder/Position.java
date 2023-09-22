package ladder;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean equals(Position position) {
        return position.position == this.position;
    }

    public int getValue() {
        return this.position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public Position prev() {
        return new Position(this.position - 1);
    }

    public Position next() {
        return new Position(this.position + 1);
    }
}
