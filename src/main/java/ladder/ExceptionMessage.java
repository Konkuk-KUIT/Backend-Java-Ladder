package ladder;

public enum ExceptionMessage {
    INVALID_LADDER_POSITION("사다리 위치는 1이상 자연수입니다."),
    INVALID_DRAW_POSITION("사다리에서 줄을 그을 수 있는 라인이 없음"),
    INVALID_POSITION("사다리에 이미 줄이 그어져있음");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
