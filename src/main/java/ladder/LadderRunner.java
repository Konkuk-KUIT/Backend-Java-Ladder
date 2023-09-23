package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            LadderPosition ladderPosition = new LadderPosition(i, position.getValue()); //현재 위치
            //움직이기 전 사다리판 출력
            System.out.println(ConstantMessage.BEFORE);
            printLadder(ladderPosition);

            //사다리 좌 우 이동
            position = rows[i].nextPosition(position);

            ladderPosition.updataPosititon(i, position.getValue());
            //사다리 좌 우 이동 후 출력
            System.out.println(ConstantMessage.AFTER);
            printLadder(ladderPosition);

            System.out.println();
        }
        return position.getValue();
    }

    public void printLadder(LadderPosition ladderPosition){
        for(int i = 0; i < rows.length; i++){
            String string = getLineString(i,ladderPosition);
            System.out.println(string);
        }
    }

    public String getLineString(int i,LadderPosition ladderPosition) {
        if(i==ladderPosition.getX()){
            return rows[i].getStarLine(ladderPosition.getY());
        }
        else
            return rows[i].getLine();
    }
}