package ladder.creator;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;
import java.util.Random;

public class LadderCreator {
    private final Row[] rows;
    private final LadderSize ladderSize;

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    public void autoDrawLine() {
        int numberOfDrewLines = 0; // 0부터라 NaturalNumber를 못 썼음.
        while (numberOfDrewLines < ladderSize.getNumberOfLineToDraw().getNumber()) {
            numberOfDrewLines += autoDrawALine();
        }
    }

    private int autoDrawALine() {
        Random random = new Random();
        NaturalNumber selectedRow = NaturalNumber.of(random.nextInt(this.rows.length) + 1);
        Position selectedPosition = Position.of(random.nextInt(ladderSize.getNumberOfPerson().getNumber()) + 1);
        Direction direction = random.nextBoolean() ? Direction.RIGHT : Direction.LEFT;

        try {
            drawLine(selectedRow, selectedPosition, direction);
            return 1;
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
            
    private void drawLine(NaturalNumber row, Position position, Direction direction) {
        rows[row.getNumber() - 1].drawLine(position, direction);
    }

    public Row[] getRow() {
        return this.rows;
    }
}
