package ladder;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public static Node of(Direction direction) {
        return new Node(direction);
    }

    public Position move(Position position) {
        if (this.direction == Direction.RIGHT) {
            return position.next();
        }
        if (this.direction == Direction.LEFT) {
            return position.prev();
        }
        return position;
    }
}
