package ladder;


public enum Direction {
    RIGHT(1), LEFT(-1), NONE(0);

    private final int direction;

    Direction(int direction){
        this.direction = direction;
    }

    public int getDirection(){
        return direction;
    }

    public Direction reverse(){
        if (direction == Direction.NONE.getDirection()){
            return Direction.NONE;
        }
        if (direction == Direction.RIGHT.getDirection()){
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }
}
