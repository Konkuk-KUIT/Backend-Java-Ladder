package ladder.creator;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderRandomCreator implements LadderCreator{
    private final Row[] rows;



    public LadderRandomCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        productRandomNum(numberOfRow, numberOfPerson);
    }

    public void productRandomNum(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        Random random = new Random();
        int numberOfLadders = (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3);

        int i=0;
        while(i < numberOfLadders){
            int row = random.nextInt(numberOfRow.getNumber()-1);
            int col = random.nextInt(numberOfPerson.getNumber()-1);

            try{
                rows[row].drawLine(Position.of(col));
                //drawLine(Position.of(row), Position.of(col));
                i++;
            }catch(IllegalArgumentException e) {

            }
        }
    }

    @Override
    public void drawLine(Position row, Position col) {

        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

//    public void showAll(){
//        for (int i = 0; i < 4; i++) {
//                rows[i].showNode();
//        }
//    }


//    public static void main(String[] args) {
//        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(NaturalNumber.of(4), NaturalNumber.of(4));
//
//        ladderRandomCreator.productRandomNum(NaturalNumber.of(4), NaturalNumber.of(4));
//
//        ladderRandomCreator.showAll();
//
//    }


}
