package ladder;

import static ladder.ExceptionMessage.*;

public class Ladder {
    public static int[][] rows;
    //natural number 구현 아직 x
    public Ladder(int numberOfRow, int numberOfPerson) {
        if (numberOfRow <= 0 || numberOfPerson <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int row, int col) {
        if (row < 1 || row > rows.length || col < 1 || col > rows[0].length) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
        rows[row - 1][col - 1] = 1;
    }

    public int leftMove(int currentRow, int currentCol){ //왼쪽으로 이동하는 메서드
        rows[currentRow][currentCol - 1] = 2;
        currentCol--;
        //System.out.println("leftmove 결과 : "+rows[currentRow][currentCol]+" currenRow = "+currentRow+" currentCol = "+currentCol);
        return currentCol;
    }

    public int rightMove(int currentRow, int currentCol){ //오른쪽으로 이동하는 메서드
        rows[currentRow][currentCol] = 2;
        currentCol++;
        //System.out.println("rightmove 결과 : "+rows[currentRow][currentCol]+" currenRow = "+currentRow+" currentCol = "+currentCol);
        return currentCol;
    }
    public boolean leftcheck(int currentRow,int currentCol,int num){
        //System.out.println("왼쪽확인");
        return currentCol > 0 && rows[currentRow][currentCol - 1] == num;
    }

    public boolean rightcheck(int currentRow,int currentCol,int num){
        //System.out.println("오른쪽확인");
        return currentCol < rows[0].length - 1 && rows[currentRow][currentCol] == num;
    }

    public int run(int selectedCol) {
        //예외
        if (selectedCol < 1 || selectedCol > rows[0].length) {
            throw new IllegalArgumentException(INVALID_RUN_POSITION.getMessage());
        }

        // 인자로 들어온 값 인덱스 맞춰서 초기화
        int currentRow = 0;
        int currentCol = selectedCol - 1;

        while (currentRow < rows.length) {
            // 사다리가 그려져 있으면 왼쪽으로 이동
            if (leftcheck(currentRow,currentCol,1)) {
                currentCol=leftMove(currentRow,currentCol);
                //System.out.println(rows[currentRow][currentCol]+" 왼쪽으로이동");
            }
            //오른쪽으로 이동
            if (rightcheck(currentRow,currentCol, 1)) {
                currentCol=rightMove(currentRow,currentCol);
                //System.out.println(rows[currentRow][currentCol]+" 오른쪽으로이동");
            }
            //왼쪽 오른쪽 둘다 이동할 수 없는 경우 내려가기
            if(!leftcheck(currentRow,currentCol,1) && !rightcheck(currentRow,currentCol, 1)){
                //오른쪽으로 이동한 경우 왼쪽 확인
                if (leftcheck(currentRow,currentCol,2)) {
                    //System.out.println("내려가는경우왼쪽확인");
                    //내려가면서 2로 바꾸었던 값 초기화
                    rows[currentRow][currentCol-1] = 1;
//                    System.out.println(rows[currentRow][currentCol-1] + " currentRow = "+ currentRow +" currentCol = "+currentCol);
                    //System.out.println("왼쪽 확인+아래로");
                }
                //왼쪽으로 이동한 경우 오른쪽 확인
                if(rightcheck(currentRow,currentCol, 2)){
                    //System.out.println("내려가는경우오른쪽확인");
                    //내려가면서 2로 바꾸었던 값 초기화
                    rows[currentRow][currentCol] = 1;
//                    System.out.println(rows[currentRow][currentCol] + " currentRow = "+ currentRow +" currentCol = "+currentCol);
                    //System.out.println("오른쪽 확인+아래로");
                }
                currentRow++;
                //System.out.println("아래로 내려간지 확인 : "+ "currentRow = "+ currentRow +" currentCol = "+currentCol);
            }
        }
        // 1을 더해 선택한 열 번호를 반환
        return currentCol + 1;
    }

//    public void printLadder(int[][] rows){ //ladder 전부 출력
//        for(int[] row : rows){
//            for(int value : row){
//                System.out.print(value+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//    }

}
