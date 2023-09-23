package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public Position move(Position position) {
        if(direction.isRight()) {
            return position.next();
        }
        if(direction.isLeft()) {
            return position.prev();
        }
        return position;
    }

    public static Node of(Direction direction) {
        return new Node(direction);
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isNone() {
        return direction.isNone();
    }

}
