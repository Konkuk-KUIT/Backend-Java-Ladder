package ladder;

public class Ladder {

    private Row[] rows;


    public Ladder(int numOfPerson, int height){

        checkNumOfPerson(numOfPerson);

        rows = new Row[numOfPerson];
        for (int i =0; i< numOfPerson; i++){
            rows[i]= new Row(height);
        }
    }

    private void checkNumOfPerson(int numOfPerson) {
        if(numOfPerson < 0)
            throw new RuntimeException();
    }
//rows의 length는 가로길이를 의미 (열의 개수)
//row의 length는 세로길이를 의미 (행의 개수)

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

    public void drawLine(int x, int y){
        checkXRange(x);
        checkYRange(y);
        rows[x].drawLine(y);
    }

    private void checkXRange(int x) {
        if( x <= 0 || x > rows.length) {
            throw new RuntimeException("잘못된 행을 입력하여, 사다리 범위를 벗어났습니다.");
        }
    }
    private void checkYRange(int y) {
        if(y <= 0 || y > rows[0].row.length) {
            throw new RuntimeException("잘못된 열을 입력하여, 사다리 범위를 벗어났습니다.");
        }
    }


    public int run(int position) {
        for(int i=0; i< rows.length; i++){
            position = rows[i].nextPosition(position);
        }
        return position;

    }


}

