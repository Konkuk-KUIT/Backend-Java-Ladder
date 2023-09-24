package ladder.core;

import ladder.NaturalNumber;

public class LadderSize {
    NaturalNumber numberOfRow;
    NaturalNumber numberOfPerson;

    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRow() {
        return numberOfRow.getNumber();
    }

    public int getNumberOfPerson() {
        return numberOfPerson.getNumber();
    }
}
