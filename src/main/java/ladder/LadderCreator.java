package ladder;

public class LadderCreator {

    private final Integer[] ladders;

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        ladders = new Integer[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            ladders[i] = new Integer(numberOfPerson.getNumber());
        }
    }


    public Integer[] getRows() {
        return ladders;
    }
}
