package ladder;

public class Ladder {

    private Row[] rows;


    public Ladder(NaturalNumber numOfPerson, NaturalNumber height){
        rows = new Row[numOfPerson.getNumber()];
        for (int i =0; i< numOfPerson.getNumber(); i++){
            rows[i]= new Row(height);
        }
    }

    public void printLadder(int currentRow, int currentCol){
        for(int i =0;i<rows.length; i++)
        {
            for(int j= 0; j<rows[i].row.length;j++){
                if(i==(currentRow-1) && j ==(currentCol-1)){
                    System.out.print(rows[i].row[j]+"*");
                }
                else {
                    System.out.print(rows[i].row[j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

//    public void printLadder2(int currentRow, int currentCol){
//        for(int i =0;i<rows.length; i++)
//        {
//            for(int j= 0; j<rows[i].row.length;j++){
//                if(i==(currentRow-1) && j ==(currentCol-1)){
//                    System.out.print(rows[i].row[j]+"*");
//                }
//                else {
//                    System.out.print(rows[i].row[j]+" ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    public void drawLine(Position x, Position y){
        rows[x.getValue()].drawLine(y.getValue());
    }

    private void checkXRange(int x) {
        if( x <= 0 || x > rows.length) {
            throw new RuntimeException("잘못된 행을 입력하여, 사다리 범위를 벗어났습니다.");
        }
    }


    public int run(Position position) {
        for(int i=0; i< rows.length; i++){
            //position = rows[i].nextPosition(position);
        }
        return position.getValue();

    }


}

