package ladder;

import ladder.creator.LadderCreator;

import java.util.HashSet;

public class LadderGame {

    private final LadderCreator ladderCreator;

    private HashSet<Integer> row_lines = new HashSet<>();
    private HashSet<Integer> col_lines = new HashSet<>(); //타입 position으로 묶기

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void autoLineConstruct(LadderSize laddersize){
        int i=0;
        while(i < laddersize.Size()){ // HashSet의 크기(행*열*0.3) 체크해서 벗어나면 종료
            int random_row = (int) Math.ceil(Math.random() * (laddersize.getRow())) - 1; // 뒤에 나오는 식 메소드로 묶기
            int random_col = (int) Math.ceil(Math.random() * (laddersize.getPerson())) - 1;

            if(row_lines.contains(random_row) && col_lines.contains(random_col)){
                continue;
            }
            else{ // else 굳이 안써도 됨...
                try{
                    ladderCreator.drawLine(Position.of(random_row), Position.of(random_col));
                }
                catch (Exception e){
                    continue;
                }
                System.out.println("clear");
                row_lines.add(random_row);
                col_lines.add(random_col);
                i++;
            }
        }
    }


    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }
}
