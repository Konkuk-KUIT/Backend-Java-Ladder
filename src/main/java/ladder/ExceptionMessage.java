package ladder;

// 사다리 게임 진행시 발생할 수 있는 오류상황들을 ExceptionMessage Class로 만들어 초기화
public enum ExceptionMessage {

    INVALID_LADDER_POSITION("사다리 위치는 1이상 자연수입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 1명 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다.");
    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
