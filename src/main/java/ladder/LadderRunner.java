package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("before");
            printLadder(i, position);
            position = rows[i].nextPosition(position);
            System.out.println("after");
            printLadder(i, position);
        }
        return position.getValue();
    }

    //사다리 출력
    public void printLadder(int rowNumber, Position position) {
        for (int i = 0; i < rows.length; i++) {
            if(i == rowNumber){
                rows[i].showCurrentNode(position);
            }else{
                rows[i].showNode();
            }
        }
    }

//    public static void main(String[] args) {
//        NaturalNumber numberOfRow = NaturalNumber.of(4);
//        NaturalNumber numberOfPerson = NaturalNumber.of(4);
//        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
//
//        LadderGame ladderGame = new LadderGame(ladderCreator);
//
//        ladderCreator.drawLine(Position.of(0),Position.of(0));
//        ladderCreator.drawLine(Position.of(1),Position.of(1));
//        ladderCreator.drawLine(Position.of(2),Position.of(2));
//
//        int nthOfPerson = 0;
//        Position position = Position.of(nthOfPerson);
//
//        ladderGame.run(position);
//    }
}
