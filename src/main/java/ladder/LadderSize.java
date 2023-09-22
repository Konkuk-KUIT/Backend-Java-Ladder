package ladder;

public class LadderSize {
    private final NaturalNumber numberOfRows;
    private final NaturalNumber numberOfColums;

    public LadderSize(NaturalNumber numberOfRows, NaturalNumber numberOfColums) {
        this.numberOfRows = numberOfRows;
        this.numberOfColums = numberOfColums;
    }

    public int getTotalLines() {
        return numberOfColums.getNumber() * numberOfRows.getNumber();
    }

    public int getNumberOfRows() {
        return numberOfRows.getNumber();
    }

    public int getNumberOfColums() {
        return numberOfColums.getNumber();
    }

    public int getGeneratedLines() {
        return (int) (getTotalLines() * 0.3);
    }
}
