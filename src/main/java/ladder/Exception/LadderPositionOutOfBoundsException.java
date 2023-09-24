package ladder.Exception;

public class LadderPositionOutOfBoundsException extends RuntimeException{

    private int error_code;
    public LadderPositionOutOfBoundsException(ErrorCode errCode, ErrorMessage errMessage) {
        super(errMessage.getErrorMessage());
        this.error_code = errCode.getCode();
    }

    public int getErrorCode(){
        return error_code;
    }
}
