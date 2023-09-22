package ladder;

import java.util.Random;

public class LadderCreator {

    private final Integer[] ladders;

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        ladders = new Integer[numberOfRow.getNumber()];
        Random random = new Random();

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            int randomColumn = random.nextInt(numberOfPerson.getNumber());

            // Check if the generated column is consecutive to the previous one
            if (i > 0 && Math.abs(ladders[i - 1] - randomColumn) == 1) {
                // If consecutive, generate a new random column
                randomColumn = (randomColumn + 1) % numberOfPerson.getNumber();
            }

            ladders[i] = new Integer(randomColumn);
        }
    }

    public Integer[] getRows() {
        return ladders;
    }
}
