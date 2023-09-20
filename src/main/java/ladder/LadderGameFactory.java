package ladder;

import ladder.creator.LadderRandomCreator;

public class LadderGameFactory {

    static NaturalNumber numberOfRow;
    static NaturalNumber numberOfPerson;

    public LadderGameFactory(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }


    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        return new LadderGame(new LadderRandomCreator(numberOfRow, numberOfPerson));
    }

    public static LadderGame createNormalLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        return new LadderGame(new LadderRandomCreator(numberOfRow, numberOfPerson));
    }



}
