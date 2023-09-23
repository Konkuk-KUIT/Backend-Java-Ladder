package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;

    public RandomLadderCreator(LadderSize ladderSize) {
        int numberOfRows = ladderSize.getNumberOfRows();
        int numberOfColums = ladderSize.getNumberOfColums();
        this.rows = new Row[numberOfRows];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(NaturalNumber.of(numberOfColums));
        }
    }

    @Override
    public void drawLine() {
        Set<String> usedPositions = new HashSet<>(); //그려질 선을 문자열의 집합으로 저장할 HashSet
        Random random = new Random();
        int numberOfLines = calMaxNumOfLines();

        while (usedPositions.size() < numberOfLines) { //선이 모두 그려질 때까지 반복
            drawValidLines(random, usedPositions);
        }
    }

    private void drawValidLines(Random random, Set<String> usedPositions) {
        int randomRow = random.nextInt(rows.length);
        int randomCol = random.nextInt(rows[0].length() - 1);

        String positionKey = randomRow + "-" + randomCol;

        if (!usedPositions.contains(positionKey)) {
            try{
                rows[randomRow].drawLine(Position.of(randomCol)); //Exception 발생시 종료 하지 않고, Row 클래스의 validation 메소드를 그대로 사용하기 위해 try/ catch
                usedPositions.add(positionKey);
            } catch (IllegalArgumentException e) {
                return;
            }
        }
    }

    @Override
    public void drawLine(Position row, Position col) {}

    @Override
    public Row[] getRows() {
        return rows;
    }


    private int calMaxNumOfLines() {
        return (int) (rows.length * rows[0].length() * 0.3);
    }


}
