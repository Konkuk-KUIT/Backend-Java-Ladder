package ladder;

public class Node {
    private Direction direction;

    public Node(Direction direction) {
        this.direction = direction;
    }

    public Position move(Position position){
        if(isRight()){
            return  position.next();
        }
        if(isLeft()){
            return  position.prev();
        }
        return position;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public boolean isNone() {
        return direction == Direction.NONE;
    }

    //정적 팩토리 메소드 of
    public static Node of(Direction direction){
        return new Node(direction);
    }

    public void printNode(boolean printStar2) {
        if(printStar2){
            System.out.print(direction.getValue()+"*  ");
        }
        if(!printStar2){
            System.out.print(direction.getValue()+"   ");
        }
    }
}
