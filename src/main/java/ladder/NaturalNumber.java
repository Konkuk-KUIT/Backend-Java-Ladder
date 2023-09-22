package ladder;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public NaturalNumber(double number) {
        validate(number);
        this.number = (int)number;
    }

    public int getNumber() {
        return this.number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    public static NaturalNumber of(double number) {
        return new NaturalNumber(number);
    }

    private boolean isNaturalNumeber(int number) {
        return number >= 1;
    }
    private void validate(int number) {
        if (!isNaturalNumeber(number)) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    private boolean isNaturalNumeber(double number) {
        return number >= 1.0;
    }
    private void validate(double number) {
        if (!isNaturalNumeber(number)) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }
}
