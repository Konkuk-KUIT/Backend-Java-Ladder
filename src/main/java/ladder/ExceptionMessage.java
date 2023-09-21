package ladder;

public enum ExceptionMessage {

    INVALID_LADDER_START_POSITION("사다리 위치는 0 이상 정수입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 2명 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다"),
    INVALID_DRAW_POSITION_OVERLAP("2개 이상의 다리는 연결할 수 없습니다"),
    INVALID_DRAW_POSITION_EXIST("이미 있는 다리는 만들 수 없습니다."),
    INVALID_DRAW_POSITION_OUT("사다리 밖으로는 다리를 만들 수 없습니다"),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
