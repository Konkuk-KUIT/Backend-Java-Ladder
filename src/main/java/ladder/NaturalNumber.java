package ladder;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private boolean isNaturalNumebr(int number) {
        return number >= 1;
    }

    private void validate(int number) {
        if (!isNaturalNumebr(number)) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }
}
