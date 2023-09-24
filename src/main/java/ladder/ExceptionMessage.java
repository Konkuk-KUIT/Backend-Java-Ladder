package ladder;

public enum ExceptionMessage {
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다.");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
