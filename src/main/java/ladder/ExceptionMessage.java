package ladder;

public enum ExceptionMessage {

    INVALID_NUMBER_OF_PERSON("참여 인원은 2명 이상이어야 합니다."),

    INVALID_POSITION("유효하지 않은 위치입니다."),

    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다.");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
