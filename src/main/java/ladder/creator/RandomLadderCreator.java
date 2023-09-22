package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;
    private final int numberOfLines;

    public RandomLadderCreator(LadderSize ladderSize) {
        int numberOfRows = ladderSize.getNumberOfRows();
        int numberOfColums = ladderSize.getNumberOfColums();
        this.rows = new Row[numberOfRows];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(NaturalNumber.of(numberOfColums));
        }

        System.out.println("랜덤 사다리의 row개수는 : "+numberOfRows);
        System.out.println("사다리 게임에 참여할 사람의 수는  : "+ numberOfColums);

        this.numberOfLines = ladderSize.getGeneratedLines();

        System.out.println("만들어질 사다리의 개수는 : "+numberOfLines);
    }
    @Override
    public void drawLine() {
        Set<String> usedPositions = new HashSet<>();
        Random random = new Random();

        while (usedPositions.size() < numberOfLines) {
            int randomRow = random.nextInt(rows.length);
            int randomCol = random.nextInt(rows[0].length() - 1);

            Position position = Position.of(randomCol);
            String positionKey = randomRow + "-" + randomCol;

            if (!usedPositions.contains(positionKey)) {
                try{
                    rows[randomRow].drawLine(position);
                    usedPositions.add(positionKey);

                    System.out.println("사다리 만들기 성공 위치: " + randomRow + ", " + randomCol);
                } catch (IllegalArgumentException e) {
                    continue;
                }
            }
        }
    }


    @Override
    public void drawLine(Position row, Position col) {

    }

    @Override
    public Row[] getRows() {
        return rows;
    }


}
