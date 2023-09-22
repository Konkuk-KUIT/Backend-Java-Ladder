package ladder.creator;

import ladder.NaturalNumber;

public class LadderSize {
    private NaturalNumber numberOfRow;
    private NaturalNumber numberOfPerson;
    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.numberOfRow = numberOfRow;
    }

    public NaturalNumber getNumberOfLine() {
        return NaturalNumber.of(numberOfPerson.getNumber() * numberOfRow.getNumber() * 0.3);
    }
}
