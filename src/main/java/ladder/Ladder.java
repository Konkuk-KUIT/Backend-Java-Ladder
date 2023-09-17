package ladder;

public class Ladder {

    private final int[][] rows;
    private int numberOfRow, numberOfPerson;
    private int current_row, current_col;   // [current_row][current_col] : 현재 사다리위의 사람 좌표
    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public void drawLine(int ladder_row, int ladder_col){
        // rows의 요소의 값이 1 : 해당 요소와 붙어있는 오른쪽 노드사이에 사다리 라인을 생성
        rows[ladder_row-1][ladder_col-1] = 1;
        rows[ladder_row-1][ladder_col] = -1;
    }

    public void drawLine_InputErr(int ladder_row, int ladder_col){
        // 사다리 범위 넘어가는 입력들어올시 예외처리
        if(ladder_row > numberOfRow || ladder_col > numberOfPerson){
            throw new RuntimeException();
        }
    }

    public void drawLine_RightedgeErr(int ladder_row, int ladder_col){
        // 사다리 제일 오른쪽 열에서는 오른쪽으로 형성되는 사다리 라인을 가질 수 없음
        if(ladder_col == numberOfPerson){
            throw new RuntimeException();
        }
    }

    public void drawLine_ManylineErr(int ladder_row, int ladder_col){
        // 사다리의 같은 층에서 서로 인접하는 라인을 가질 수 없음
        if(rows[ladder_row-1][ladder_col-2] == 1){
            throw new RuntimeException();
        }
    }
    public int run(int Person_Position) {
        // 시작위치 : rows[0][Person_Position-1]
        // 사다리를 타고 내려가다가 사다리 제일 아래층에 도착하면 그때의 위치를 return
        // 사다리를 타는 움직임은 move()로 구현
        current_row = 1; current_col = Person_Position;
        while(current_row != numberOfRow+1){
            PersonMove(current_row, current_col);
        }
        return current_col;
    }

    public void PersonMove(int current_row, int current_col){
        // 우로 이동
        if(rows[current_row-1][current_col-1] == 1){
            this.current_col += 1;
            this.current_row += 1;
        }
        // 좌로 이동
        if(rows[current_row-1][current_col-1] == -1){
            this.current_col -= 1;
            this.current_row += 1;
        }
        // 아래로 이동
        if(rows[current_row-1][current_col-1] == 0){
            this.current_row += 1;
        }
    }
}


