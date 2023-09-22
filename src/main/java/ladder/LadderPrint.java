package ladder;

public class LadderPrint {
    private final Row[] rows;

    public LadderPrint(Row[] rows) {
        this.rows = rows;
    }

    public void printLadder(NaturalNumber row, Position position) {
        for (int i = 0; i < this.rows.length; i++) {
            printRow(NaturalNumber.of(i+1), row, position);
        }
    }
    private void printRow(NaturalNumber printingRow, NaturalNumber currentRow, Position position) {
        if (printingRow.getNumber() == currentRow.getNumber()) {
            printRowForCurrentRow(this.rows[printingRow.getNumber() - 1], position);
        }
        if (printingRow.getNumber() != currentRow.getNumber()) {
            printRowForOtherRow(this.rows[printingRow.getNumber() - 1]);
        }
    }
    private void printRowForCurrentRow(Row row, Position position) {
        for (int col = 0; col < row.row.length; col++) {
            System.out.print(row.row[col].getDirection().getValue());
            printIfCurrentPosition(NaturalNumber.of(col + 1), NaturalNumber.of(position.getValue()));
            System.out.print("\t");
        }
        System.out.println();
    }
    private void printIfCurrentPosition(NaturalNumber printingCol, NaturalNumber currentPosition) {
        if (printingCol.getNumber() == currentPosition.getNumber()) {
            System.out.print("*");
        }
    }
    private void printRowForOtherRow(Row row) {
        for (int col = 0; col < row.row.length; col++) {
            System.out.print(row.row[col].getDirection().getValue()+"\t");
        }
        System.out.println();
    }
}
