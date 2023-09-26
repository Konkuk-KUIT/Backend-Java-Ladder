package ladder;

public enum Direction {
    LEFT(-1), RIGHT(1), NONE(0);

    private final int value;


    Direction(int value) {
        this.value = value;
    }

    public int getValue(){ //Direction 상수에 대한 값 얻어올 수 있게 처리
        return value;
    }
}
