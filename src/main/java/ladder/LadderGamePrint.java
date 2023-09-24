package ladder;

import ladder.creator.LadderCreator;

public class LadderGamePrint {
    private final Row[] rows;
    private final LadderPosition ladderPosition;

    public LadderGamePrint(Row[] rows, LadderPosition ladderPosition){
        this.rows = rows;
        this.ladderPosition = ladderPosition;
    }       // 사다리와 게임스타트위치를 입력받음


    public void FullLadderPrint() {
        for(int i = 0; i < rows.length; i++){
            if(i == ladderPosition.getY()){
                System.out.println(rows[i].OneRow(ladderPosition.getX()));
            }
            else{
                System.out.println(rows[i].OneRow_1());
            }
        }
    }       // 사다리 게임 출력 (플레이어 현위치 : * 로 출력)

    public void before_print(){
        System.out.println("Before");
    }

    public void after_print(){
        System.out.println("After");
    }


}