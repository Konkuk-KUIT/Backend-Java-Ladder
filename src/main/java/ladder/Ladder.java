package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    /*규칙
    * 1. Line은 하나만 떨어질 수 있게 만들었다.
    * 2. Line을 만나면 무조건 따라 간다.
    * 3. 여러개의 Line이 겹칠 수 없다.*/
    public void drawLine(int row, int col){
//        잘못된 값을 받는 경우
        if(row > rows.length){
            throw new RuntimeException();
        }
        if(col > rows[0].length-1){
            throw new RuntimeException();
        }
//        사다리를 못 그리는 경우
        if(rows[row-1][col-1] != 0 || rows[row-1][col] != 0){
            throw new RuntimeException();
        }

        rows[row-1][col-1] = 1;
        rows[row-1][col] = 1;
    }

    public int run(int position){
//        잘못된 값을 받는 경우
        if(position > rows[0].length){
            throw new RuntimeException();
        }

        for(int i=0; i<rows.length; i++){
            if(rows[i][position-1] == 0){
                System.out.print("위치1 : ");
                System.out.println(position);
                continue;
            }
            if(rows[i][position-1] == 1){
//                만약에 position +- 1의 index가 존재하지 않는 경우
                if(position == 1){
                    if(rows[i][position] == 1){
                        position += 1;
                    }
                    System.out.print("위치2 : ");
                    System.out.println(position);
                    continue;
                }
                if(position == rows[0].length){
                    if(rows[i][position-2] == 1){
                        position -= 1;
                    }
                    System.out.print("위치3 : ");
                    System.out.println(position);
                    continue;
                }

                if(rows[i][position-2] == 1){
                    position -= 1;
                }
                if(rows[i][position] == 1){
                    position += 1;
                }
                System.out.print("위치4 : ");
                System.out.println(position);
            }
        }

        return position;
    }

    public int rowsCheck(int row, int col){
        return rows[row-1][col-1];
    }
}
