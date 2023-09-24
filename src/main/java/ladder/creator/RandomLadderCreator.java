package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class RandomLadderCreator extends LadderCreator {

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        super(numberOfRow, numberOfPerson);
        System.out.println(calculateLine(numberOfRow.getNumber(), numberOfPerson.getNumber()));
        for (int i = 0; i < calculateLine(numberOfRow.getNumber(), numberOfPerson.getNumber()); i++) {
            while (true) {
                try {
                    drawLine(Position.of((int)((Math.random()*10000)%numberOfRow.getNumber())), Position.of((int)((Math.random()*10000)%(numberOfPerson.getNumber()-1))));
                } catch (IllegalArgumentException e1) {
                    continue;
                }
                break;
            }
        }
    }

    private int calculateLine(int row, int col) {
        return (int) (row * col * 0.3);
    }

}
