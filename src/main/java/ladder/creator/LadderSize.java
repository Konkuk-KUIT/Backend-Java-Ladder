package ladder.creator;

import ladder.NaturalNumber;

public class LadderSize {
    private final NaturalNumber numberOfRow;
    private final NaturalNumber numberOfPerson;
    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.numberOfRow = numberOfRow;
    }

    public NaturalNumber getNumberOfLineToDraw() {
        return NaturalNumber.of(numberOfPerson.getNumber() * numberOfRow.getNumber() * 0.3);
    }

    public NaturalNumber getNumberOfPerson() {
        return this.numberOfPerson;
    }
}
