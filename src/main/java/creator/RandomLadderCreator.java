package creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.ExceptionMessage.INVALID_POSITION;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i=0; i< numberOfRow.getNumber(); i++){
            rows[i] = new Row(numberOfPerson);
        }

        // 사다리 랜덤 생성
        Random random = new Random();
        int lineNumber = (int)(numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3);
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();

        //System.out.println("lineNumber = " + lineNumber);
        for (int i=0; i<lineNumber; i++){
            //System.out.println("i = " + i);
            Position rowPosition = Position.of(random.nextInt(numberOfRow.getNumber()) + 1);
            Position columnPosition = Position.of(random.nextInt(numberOfPerson.getNumber()-1) + 1);
            //System.out.println("rowPosition = " + rowPosition + " /columPosition = " + columnPosition);

            //그릴수 있는지 체크
            if(!checkDrawable(rowPosition, columnPosition)){
                //System.out.println("그릴수 없음");
                i--;
            }else{ //else를 쓰는게 안좋다곤 했지만.. 모르겠어서
               drawLine(rowPosition, columnPosition);

            }
        }
    }

    private boolean checkDrawable(Position rowPosition, Position columnPosition) {
        try{
            rows[rowPosition.getValue()-1].checkDrawable(columnPosition);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void drawLine(Position row, Position startColumn) {
        rows[row.getValue()-1].drawLine(startColumn);
    }

    private void checkRowRange(int row) {
        if (row-1 >= rows.length || row-1 < 0) { //범위 체크
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    public Row[] getRows() {
        return rows;
    }
}
