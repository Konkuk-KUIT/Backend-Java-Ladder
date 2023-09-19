package ladder;

public enum ExceptionMessage {

    INVALID_NUMBER_OF_PERSON("참여 인원은 두명 이상이어야 합니다."),
    INVALID_RUN_POSITION("유효하지않은 위치입니다."),
    INVALID_DRAW_POSITION("유효하지않은 위치입니다.");

    public final String message;

    ExceptionMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }
}
