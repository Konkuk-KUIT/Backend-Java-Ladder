package ladder;

public enum Direction {
    /*매직 넘버 enum으로 대체*/
    EMPTY_COLUMN(2),CREATED_COLUMN(1),FLAGED_COLUMN(0);
    private final int value;
    Direction(int value) {
        this.value=value;
    }
    public  int getValue(){
        return value;
    }
}
