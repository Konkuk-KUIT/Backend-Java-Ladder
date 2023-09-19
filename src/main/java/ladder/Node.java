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

    public Point move(){
        if (is_NONE()){
            return new Point(0, 1);
        }
        return new Point(this.direction.getDirection(), 0);
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }
}
