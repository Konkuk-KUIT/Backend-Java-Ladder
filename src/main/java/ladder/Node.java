package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;         // 왼, 오, none 방향가지도록 사다리 한칸을 node클래스로 정의
    }

    // 각 노드의 direction값을 정수 value로 반환하는 NodeValue 메서드 생성
    public int NodeValue(){
        return direction.getValue();
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
}