package ladder;

// 방향을 +1, -1로 표시하는것이 아니라 enum class로 초기화
public enum Direction {
    LEFT(-1), RIGHT(1), NONE(0);

    private final int value;

    Direction(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
