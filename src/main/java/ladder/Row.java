package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, Direction.RIGHT);
        setDirectionAtPosition(startPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        nodes[startPosition.getValue()] = Node.of(direction);
    }

    public void printRow(Boolean isCurPosInRow, LadderPosition curLadderPosition) {

        for(int elementIdx = 0; elementIdx < nodes.length; elementIdx++) {
            System.out.print(elementToString(isCurPosInRow, curLadderPosition, elementIdx));
        }
        System.out.println();
    }

    private String elementToString(Boolean isCurPosInRow, LadderPosition curLadderPosition, int i) {
        String nodeStr = String.format("%4s", nodes[i].toString());

        if(isCurPosition(isCurPosInRow, curLadderPosition, i)) {
            nodeStr += "*";
        }

        return nodeStr;
    }

    private static boolean isCurPosition(Boolean isCurPosInRow, LadderPosition curLadderPosition, int i) {
        return isCurPosInRow && curLadderPosition.isColPositionSame(Position.of(i));
    }

    public int length() {
        return nodes.length;
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || nodes[startPosition.getValue()].isRight()
                || nodes[startPosition.next().getValue()].isRight()
                || nodes[startPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }
}