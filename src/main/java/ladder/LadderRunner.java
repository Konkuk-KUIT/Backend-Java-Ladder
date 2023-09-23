package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            PrintLadder(position, Position.of(i));
            position = rows[i].nextPosition(position);
            System.out.println("After");
            PrintLadder(position, Position.of(i));
        }
        return position.getValue();
    }

    public void PrintLadder(Position x, Position y){
        LadderPosition current_ladderPosition = new LadderPosition(x, y);
        for(int i=0; i<rows.length; i++){
            // 여기에 조건을 달아서 현재 위치인 경우와 아닌 경우를 나누는건 어떨까?
            //current_position(x, y, Position.of(i));
            System.out.println(rows[i].PrintRow(current_ladderPosition, i));
        }
        System.out.println();
    }

//    public void current_position(Position x, Position y, Position yp){
//        if(Position.isEquall(y, yp)){
//            rows[yp.getValue()].PrintStarRow(x);
//        }
//        if(!Position.isEquall(y, yp)){
//            rows[yp.getValue()].PrintRow(x);
//        }
//
//    }
}
