package ladder;

// 현재 사다리 위에서 플레이어의 위치
public class LadderRunner {

    private final Row[] rows;
    private LadderPosition ladderPosition_before;
    private LadderPosition ladderPosition_after;
    private LadderGamePrint ladderGamePrint;


    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {

            ladderPosition_before = new LadderPosition(position, i);

            ladderGamePrint = new LadderGamePrint(rows, ladderPosition_before);
            ladderGamePrint.before_print();
            ladderGamePrint.FullLadderPrint();
            // before ladder 출력

            position = rows[i].nextPosition(position);


            ladderPosition_after = new LadderPosition(position, i);

            ladderGamePrint = new LadderGamePrint(rows, ladderPosition_after);
            ladderGamePrint.after_print();
            ladderGamePrint.FullLadderPrint();
            // after ladder 출력
        }
        return position.getValue();         // 플레이어의 최종 위치 return
    }

}
