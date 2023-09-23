package ladder;

public class LadderSize {
    private NaturalNumber numberOfRow;
    private NaturalNumber numberOfPerson;

    private int ladderSize;

    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        ladderSize = (int) (this.numberOfRow.getNumber() * this.numberOfPerson.getNumber() * 0.3);
    }

    public static LadderSize of(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        return new LadderSize(numberOfRow, numberOfPerson);
    }

    public int getRow(){
        return numberOfRow.getNumber();
    }

    public int getPerson(){
        return numberOfPerson.getNumber();
    }

    public int Size(){
        return ladderSize;
    }
}
