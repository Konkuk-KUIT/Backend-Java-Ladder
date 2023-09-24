package ladder;

import java.awt.*;

public class Node {
    private final Direction direction;

    private Node(Direction direction){
        this.direction = direction;
    }

    public boolean is_NONE(){
        return this.direction == Direction.NONE;
    }
    private boolean is_RIGHT() {return this.direction == Direction.RIGHT;}
    private boolean is_LEFT() {return this.direction == Direction.LEFT;}

    public boolean move(LadderPosition position){
        if (is_RIGHT()) {
            position.move_right();
            return true;
        }
        if (is_LEFT()) {
            position.move_left();
            return true;
        }
        return false;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    public void print_Node(){
        System.out.printf("%d", this.direction.getDirection());
    }
}
