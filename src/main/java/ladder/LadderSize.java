package ladder;

public class LadderSize {
    private NaturalNumber numberOfRow;
    private NaturalNumber numberOfPeople;

    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPeople) {
        this.numberOfRow = numberOfRow;
        this.numberOfPeople = numberOfPeople;
    }

    public NaturalNumber getNumberOfRow(){
        return numberOfRow;
    }

    public NaturalNumber getNumberOfPeople(){
        return numberOfPeople;
    }
}
