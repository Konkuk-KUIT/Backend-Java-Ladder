package ladder;

public class LadderRunner {
    private final Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(int position) {
        int curY = 0;
        int curX = position;
        while (curY < ladder.getColumnL()) {
            curX = whereTo(curY, curX);
            curY++;
        }
        return curX;
    }

    private int whereTo(int curY, int curX) {
        //안 이어져 있을 경우 ->
        if (ladder.getRows()[curY][curX] == 0) {
            return curX;
        }
        //이어진 경우 ->
        //양 끝에 있을 경우
        if (curX == 0) {
            curX += 1;
            return curX;
        }
        if (curX == ladder.getRowL() - 1) {
            curX -= 1;
            return curX;
        }
        //양 끝이 아닐 경우
        //한 쪽만 이어져 있을 경우
        if (ladder.getRows()[curY][curX - 1] == 1) {
            curX -= 1;
            return curX;
        }
        if (ladder.getRows()[curY][curX + 1] == 1) {
            curX += 1;
            return curX;
        }
        return curX;
    }
}
