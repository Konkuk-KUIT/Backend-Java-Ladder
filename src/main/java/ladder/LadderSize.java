package ladder;

public class LadderSize {
    private final NaturalNumber numberOfRow;
    private final NaturalNumber numberOfPerson;

    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRow(){
        return numberOfRow.getNumber();
    }

    public int getNumberOfPerson(){
        return numberOfPerson.getNumber();
    }
}
