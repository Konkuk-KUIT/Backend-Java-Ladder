package ladder;

import static ladder.ExceptionMessage.*;

public class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    private boolean isNaturalNumber(int number) {
        return number >= 1;
    }
}
