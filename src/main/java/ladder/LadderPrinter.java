package ladder;

import ladder.creator.LadderCreator;

public class LadderPrinter {

    private final Row[] rows;
    private NaturalNumber numberOfRow;
    private NaturalNumber numberOfPerson;
    private Position currentRow;
    private Position currentCol;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
        this.numberOfRow = NaturalNumber.of(rows.length);
        this.numberOfPerson = NaturalNumber.of(rows[0].getNodes().length);
    }

    public void printLadder(Position currentRow, Position currentCol) {
        this.currentRow = currentRow;
        this.currentCol = currentCol;
        for(int i=0; i<numberOfRow.getNumber(); i++) {
            for(int j=0; j<numberOfPerson.getNumber(); j++) {
                rows[i].getNodes()[j].printNode(isCurrentPosition(Position.of(i), Position.of(j)));
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isCurrentPosition(Position row, Position col) {
        return ((currentCol.getPosition() == col.getPosition()) && (currentRow.getPosition() == row.getPosition()));
    }

    public void printBefore() {
        System.out.println("Before");
    }

    public void printAfter() {
        System.out.println("After");
    }
}
