package ladder;

import java.util.ArrayList;
import java.util.List;

/*
사다리 게임 규칙:

1. 한 라인 의 한 높이에선 하나의 선만 그릴 수 있음.
2. 자신의 이웃한 라인에만 선을 그릴 수 있음.
3. 시작 높이와 종료 높이엔 선을 그릴 수 없음.

 */


//서로 다른 row에서 두 라인을 이을 수 있도록 List를 통해 사다리를 구현
public class Ladder {
    private final int numberOfPerson;
    private final int numberOfRow;
    private List<LadderLine> ladderLines;
    private Position currentPosition;

    public Ladder(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        this.ladderLines = new ArrayList<LadderLine>();
    }

    public void drawLine(LadderLine ladderLine) {
        ladderLines.add(ladderLine);
    }

    public int run(int startLineIndex) {

        currentPosition = new Position(startLineIndex);

        while(!isReachedEnd()) {
            slideDownLadder();
        }

        return currentPosition.getxPos();
    }

    public boolean isReachedEnd() {
        return currentPosition.isYPosEquals(numberOfRow);
    }

    public void slideDownLadder() {
        for(LadderLine line: ladderLines) {
            if(line.isLineConnected(currentPosition)) {
                crossLine(line);
                break;
            }
        }
        goDown();
    }

    public void crossLine(LadderLine ladderLine){
        int newXPos = (currentPosition.isXPosEquals(ladderLine.firstLine) ? ladderLine.secondLine : ladderLine.firstLine);
        int newYPos = (currentPosition.isYPosEquals(ladderLine.firstLineRow) ? ladderLine.secondLineRow : ladderLine.firstLineRow);

        currentPosition.changePosition(newXPos, newYPos);
    }

    public void goDown() {
        currentPosition.addOneToYPos();
    }
}

//2차원 배열을 통한 사다리 구현
//public class Ladder {
//
//    private final int[][] rows;
//
//    public Ladder(int numberOfRow, int numberOfPerson) {
//        rows = new int[numberOfRow][numberOfPerson];
//    }
//
//    public void drawLine(int line1, int line2, int row) {
//        rows[row][Math.min(line1, line2)] = 1; //
//    }
//
//    public int run(int startLineNumber) {
//        int curLineNumber = startLineNumber;
//
//
//        for (int rowCount = 0; rowCount < rows.length; rowCount++) {
//
//            if (curLineNumber > 0 && rows[rowCount][curLineNumber - 1] == 1) {
//                curLineNumber--;
//            }
//
//            else if (curLineNumber < rows[rowCount].length && rows[rowCount][curLineNumber] == 1) {
//                curLineNumber++;
//            }
//        }
//
//        return curLineNumber;
//    }
//}




