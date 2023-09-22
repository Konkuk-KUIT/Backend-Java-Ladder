package ladder;

public class LadderSize {
    NaturalNumber numberOfRow;
    NaturalNumber numberOfPerson;

    LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
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
