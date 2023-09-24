package ladder;

public enum ExceptionMessage {
    INVALID_DIRECTION("사다리를 밖으로 그릴 수 없습니다."),
    INVALID_POSITION("사다리의 가로선을 겹치게 그릴 수 없습니다.");

    private final String message;

    ExceptionMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
