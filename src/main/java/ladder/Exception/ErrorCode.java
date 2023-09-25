package ladder.Exception;

public enum ErrorCode {
    LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION(1001),
    LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION(1002),
    LADDER_ZERO_OUT_OF_BOUND_EXCEPTION(1003),
    LADDER_OVERLAPPING_EXCEPTION(1004);


    private final int error_code;
    ErrorCode(int errCode){
        this.error_code = errCode;
    }

    public int getCode(){
        return this.error_code;
    }
}
