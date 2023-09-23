package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import static ladder.ExceptionMessage.INVALID_POSITION;

public class RandomLadderCreator implements LadderCreator {
    private final Row[] rows;

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        makeRandom(numberOfRow, numberOfPerson);
    }

    private int getLineNumber(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        return (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3);
    }

    private void makeRandom(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        Position row, col;
        for (int i = 0; i < getLineNumber(numberOfRow, numberOfPerson);) {
            row = Position.of(getRandomNumber(numberOfRow.getNumber()));
            col = Position.of(getRandomNumber(numberOfPerson.getNumber()));
            try{
                drawLine(row, col);
            }catch (IllegalArgumentException e) {
                continue;
            }
            i++;
        }
    }

    private int getRandomNumber(int number) {
        return (int) ((Math.random() * 10000) % number);
    }

    @Override
    public Row[] getRows() {
        return new Row[0];
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }
}
