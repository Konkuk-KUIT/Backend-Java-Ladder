package ladder;

public class Node {

    private Direction direction;


    public Node(Direction direction) {
        this.direction = direction;
    }

    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }

        if (isLeft()) {
            return position.prev();
        }
        return position;
    }


    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public static Node of(Direction direction) {
        return new Node(direction);
    }

    public Direction getDirection() {
        return direction;
    }
}
