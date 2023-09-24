package ladder;

public class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /*
     * Factory Method of
     * 외부에서 int 값 하나를 NaturalNumber로 감싸서 사용 가능.
     */

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public boolean isNaturalNumber(int number) {
        return number >= 1;
    }
}
