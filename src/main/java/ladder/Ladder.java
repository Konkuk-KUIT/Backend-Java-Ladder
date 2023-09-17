package ladder;

public class Ladder {
    private final int[][] rows; // 라인이 없으면 0, 있으면 1
    private int cur_row;
    private int cur_col;
    private final int numberOfRow;
    private final int numberOfPerson;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
        this.numberOfRow=numberOfRow;
        this.numberOfPerson=numberOfPerson;
    }
    void drawLine(Position p){// 어떤 position에 라인을 넣을지 선택하여 라인 생성.
        if(!drawable(p)){return;} //그릴 수 없으면 return.
        rows[p.row][p.col]=1;
    }
    boolean drawable(Position p){
        if(rows[p.row][p.col]==1 || p.col+1==numberOfPerson) //현재 position에 라인이 이미 있거나, 오른쪽 끝 열에 생성할 경우 생성 불가.
            return false;
        if(p.col!=0 && (rows[p.row][p.col-1]==1 || rows[p.row][p.col+1]==1)){ // 왼쪽 끝이 아닐 떄, 연속되게 라인을 생성하려하면 생성 불가.
            return false;
        }
        if(p.col==0 && rows[p.row][p.col+1]==1){ //왼쪽 끝일 떄, 연속되게 라인을 생성하려하면 생성 불가.
            return false;
        }
        return true;
    }
    boolean isLineExist(){
        if(cur_col==0 && rows[cur_row][cur_col]==0) // 왼쪽 끝 열 이면서 라인이 없는 경우
            return false;
        if(rows[cur_row][cur_col]==0 && rows[cur_row][cur_col-1]==0) // 그 외 라인이 없는 경우
            return false;
        return true;
    }
    int checkLine(Position p){ //받은 위치에 라인이 있는지 없는지 체크 (drawLine()을 테스트 하기 위해)
        return rows[p.row][p.col];
    }
    Position getCurLoc(){ //현재 위치 가져오기
        return new Position(cur_row,cur_col);
    }
    void setStart(int n){ //시작 위치 지정(move()를 테스트하기 위해)
        cur_col=n-1;
    }

    void move(){ // 정책에 따라 다음 위치로 이동(내 현재 위치 업데이트)
        if(!isLineExist()){ //라인이 없으면 아래로 이동.
            cur_row+=1;
            return;
        }
        if(cur_col==0){ // 왼쪽 끝 열 이면서 내 위치에 라인이 있는 경우, 오른쪽 아래로 이동
            cur_row+=1;
            cur_col+=1;
            return;
        }
        if(cur_col==numberOfPerson-1){ //오른쪽 끝 열 이면서 왼쪽에 라인이 있는 경우, 왼족 아래로 이동
            cur_row+=1;
            cur_col-=1;
            return;
        }
        if(rows[cur_row][cur_col-1]==1){ // 양 끝이 아니면서, 왼쪽에 라인이 있는 경우 왼쪽 아래로 이동
            cur_row+=1;
            cur_col-=1;
            return;
        }
        // 내 위치에 라인이 있는 경우 오른쪽 아래로 이동
        cur_row+=1;
        cur_col+=1;
    }
    int run(int num){ // 사다리 번호를 받아서, 끝에 도달할 때까지 move()를 시행하여 최종 결과를 return
        cur_row=0;
        cur_col=num-1;
        while(cur_row!=numberOfRow){ // 끝에 도달하면 탈출
            move();
        }
        return cur_col+1;
    }
}

class Position{
    int row;
    int col;
    Position(int row, int col){
        this.row=row;
        this.col=col;
    }
}
