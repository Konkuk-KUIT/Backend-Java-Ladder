package ladder;

public class Ladder {

    private final int[][] rows;
    private Integer goal;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int x, int y) {
        rows[x][y] = 1;
        rows[x][y+1] = -1;
    }

    public int run(int n){
        int pos_X = 0;
        int pos_Y = n-1;

        decide(pos_X, pos_Y);
        return goal;
    }

    public void decide(int pos_X, int pos_Y){
        // pos_X,Y로 현재위치
        if(pos_X >= rows.length){
            goal = pos_Y+1;
            return;
        }

        if(rows[pos_X][pos_Y]==0){
            pos_X = go_down(pos_X);
            decide(pos_X, pos_Y);
            return;
        }
        if(rows[pos_X][pos_Y]==1){
            pos_Y = go_right(pos_Y);
            pos_X = go_down(pos_X);
            decide(pos_X, pos_Y);
            return;
        }
        if(rows[pos_X][pos_Y]==-1){
            pos_Y = go_left(pos_Y);
            pos_X = go_down(pos_X);
            decide(pos_X, pos_Y);
            return;
        }
    }

    public int go_down(int pos_X){
        pos_X+=1;
        return pos_X;
    }
    public int go_right(int pos_Y){
        pos_Y+=1;
        return pos_Y;
    }
    public int go_left(int pos_Y){
        pos_Y-=1;
        return pos_Y;
    }


}
