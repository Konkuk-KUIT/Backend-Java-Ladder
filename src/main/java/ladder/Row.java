package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i=0; i< numberOfPerson.getNumber(); i++){
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public Position nextLevel(Position currentPosition) { // 사다리타고 내려가기
        checkColRange(currentPosition);
        return nodes[currentPosition.getValue()-1].move(currentPosition);
    }

    private void checkColRange(Position position) { //범위 체크
        if (position.isBiggerThan(nodes.length-1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    public void drawLine(Position startColumn) {
        checkDrawable(startColumn);
        nodes[startColumn.getValue()-1] = Node.of(Direction.RIGHT);
        nodes[startColumn.getValue()] = Node.of(Direction.LEFT);
    }

    public void checkDrawable(Position startColumn) { //선을 그릴 수 있는 상황인지 체크
        if(startColumn.getValue() >= nodes.length){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
        if (!(nodes[startColumn.getValue()-1].isNone() && nodes[startColumn.getValue()].isNone())){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    public void printRow(boolean printStar, Position position) {
        for (int i=0; i<nodes.length; i++){
            boolean printStar2 =false;
            if (printStar && i==position.getValue()-1){
                printStar2 = true;
            }
            nodes[i].printNode(printStar2);
        }
        System.out.println();
    }
}
