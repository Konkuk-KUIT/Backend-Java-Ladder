package ladder;

public class LadderSize {
    private final NaturalNumber numberOfRow;
    private final NaturalNumber numberOfPerson;
    LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        this.numberOfRow=numberOfRow;
        this.numberOfPerson=numberOfPerson;
    }
    public NaturalNumber getNumberOfRow(){return numberOfRow;}
    public NaturalNumber getNumberOfPerson(){return numberOfPerson;}
}
