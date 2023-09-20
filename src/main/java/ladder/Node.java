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

    public void move(LadderPosition position){
        if (is_RIGHT()) position.move_right();
        if (is_LEFT()) position.move_left();
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }
}
