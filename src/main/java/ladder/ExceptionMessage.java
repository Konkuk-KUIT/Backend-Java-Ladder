package ladder;

public enum ExceptionMessage {
    INVALID_NUMBER_OF_PERSON("1명이상이여야함"),
    INVALID_POSITION("position error: 위치가 사람 수보다 크면 안됨"),
    INVALID_DRAWLINE("사다리를 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
