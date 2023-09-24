package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
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

    public String getNodeInfo(){
        String nodeString = "";
        if(isRight()){
            nodeString += "1";
            return nodeString;
        }
        if(isLeft()){
            nodeString += "-1";
            return nodeString;
        }
        nodeString += "0";
        return nodeString;
    }
}
