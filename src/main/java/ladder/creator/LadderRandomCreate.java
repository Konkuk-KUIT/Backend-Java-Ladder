package ladder.creator;

import ladder.*;
import java.util.Random;
public class LadderRandomCreate implements LadderCreator {

    private final Row[] rows;
    private int startPosition;
    private LadderSize ladderSize;
    private Random random = new Random();

    public LadderRandomCreate(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }

        randomDrawLine();
    }

    public void randomDrawLine() {
        int randomCol;
        int randomRow;
        Position position;

        for(int i = 0; i<(int)(ladderSize.getNumberOfRow() * ladderSize.getNumberOfPerson() * 0.3); i++) {
            randomRow = random.nextInt(ladderSize.getNumberOfRow());
            randomCol = random.nextInt(ladderSize.getNumberOfPerson());
            position = new Position(randomCol);

            try{
                rows[randomRow].drawLine(position);
            }catch (Exception e){
                i--;        // 예외발생시 해당 반복문 무효처리
            }
        }
    }

    @Override
    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

}
