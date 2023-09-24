package ladder;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    /*public Direction getDirection() {
        return this.direction;
    }*/

    public Boolean isNONE() {
        return this.direction == Direction.NONE;
    }
    public Boolean isRIGHT() {
        return this.direction == Direction.RIGHT;
    }
    public Boolean isLEFT() {
        return this.direction == Direction.LEFT;
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

    public void printNode(boolean isCurrentNode) {
        if (this.direction != Direction.LEFT) {
            System.out.print(" ");
        }
        System.out.print(this.direction.getValue());
        if (isCurrentNode) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
}
