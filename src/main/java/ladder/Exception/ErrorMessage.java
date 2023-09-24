package ladder.Exception;

public enum ErrorMessage {
    LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION("사다리의 높이보다 높은곳에 다리를 만들 수 없습니다."),
    LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION("사다리의 너비보다 큰 곳에 다리를 만들 수 없습니다."),
    LADDER_ZERO_OUT_OF_BOUND_EXCEPTION("사다리의 노드좌표는 0이상의 값을 가져야 합니다."),
    LADDER_OVERLAPPING_EXCEPTION("해당 지점에 이미 다리가 존재합니다.");

    private final String message;

    ErrorMessage(String msg){
        this.message = msg;
    }

    public String getErrorMessage(){
        return this.message;
    }
}
