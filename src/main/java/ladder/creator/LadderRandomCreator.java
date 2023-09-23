package ladder.creator;

import ladder.*;

import java.util.HashMap;
import java.util.HashSet;

public class LadderRandomCreator implements LadderCreator{
    private final Row[] rows;
    private int max;
    private LadderSize ladderSize;
    private HashSet<PositionSize> hashSet;
    RandomNumberCreator random = new RandomNumberCreator();

    public LadderRandomCreator(LadderSize ladderSize) {
        LadderHumanCreator ladderHumanCreator = new LadderHumanCreator(ladderSize);
        this.rows = ladderHumanCreator.getRows();
        this.max = (int)(ladderSize.getNumberOfRow().getNumber() * ladderSize.getNumberOfPeople().getNumber() * 0.3);
        this.ladderSize = ladderSize;
        drawLineRandom();
    }

    public void printHash(){
        System.out.println("hashset");
        for(PositionSize p : hashSet){
            System.out.println("row: "+p.getRow().getValue()+", col: "+p.getCol().getValue());
        }
    }
    public void drawLineRandom(){
        hashSet = new HashSet<>();
        while(hashSet.size()<=max){
            PositionSize positionSize = getPositionSize();
            if(rows[positionSize.getRow().getValue()].isInvalid(positionSize.getCol())){
                drawLine(positionSize.getRow(), positionSize.getCol());
                hashSet.add(positionSize);
            }
        }
    }
    public PositionSize getPositionSize(){
        Position row = Position.of(random.getRandom(ladderSize.getNumberOfRow().getNumber()));
        Position col = Position.of(random.getRandom(ladderSize.getNumberOfPeople().getNumber()-1));
        PositionSize positionsize = new PositionSize(row,col);
        return positionsize;
    }

    public boolean vaildDuplication(HashSet<PositionSize> hashSet, PositionSize positionsize) {
        if(hashSet.contains(positionsize))
            return false;
        else
            return true;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
