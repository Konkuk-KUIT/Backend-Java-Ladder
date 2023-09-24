package ladder.creator;

import ladder.LadderSize;
import ladder.NaturalNumber;
import ladder.PositionPair;
import ladder.Position;
import ladder.Row;
import java.util.HashSet;

public class LadderRandomCreator implements LadderCreator{
    private final Row[] rows;
    private HashSet<PositionPair> hashSet;
    private final int maxNumberOfLines;
    private RandomNumberCreator randomNumberCreator;
    private final LadderSize ladderSize;
    public LadderRandomCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        maxNumberOfLines = (int)(0.3*ladderSize.getNumberOfRow().getNumber()*ladderSize.getNumberOfPerson().getNumber());
        randomNumberCreator = new RandomNumberCreator();
        this.ladderSize = ladderSize;
        hashSet = new HashSet<>();
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
        drawRandomLine(ladderSize);
    }
    private void drawRandomLine(LadderSize ladderSize){
        while(hashSet.size()<maxNumberOfLines){
            PositionPair positionPair = getPositionPair();
            drawLine(positionPair.getPositionRow(), positionPair.getPositionCol());
            hashSet.add(positionPair);
        }
    }
    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }
    public Row[] getRows(){return rows;}

    private PositionPair getPositionPair(){
        Position row = Position.of(randomNumberCreator.getRandomNumber(ladderSize.getNumberOfRow().getNumber()));
        Position col = Position.of(randomNumberCreator.getRandomNumber(ladderSize.getNumberOfPerson().getNumber()-1));
        PositionPair positionPair = new PositionPair(row,col);
        if(hashSet.contains(positionPair))
            getPositionPair();
        return positionPair;
    }
}
