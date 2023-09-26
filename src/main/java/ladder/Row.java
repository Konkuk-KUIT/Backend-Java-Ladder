package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()+1];
        for (int i = 0; i < numberOfPerson.getNumber()+1; i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public int size() {
        return nodes.length;
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

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getValue()].isRight()
                || nodes[position.next().getValue()].isRight()
                || nodes[position.getValue()].isLeft());
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(1);
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length-1) || position.isSmallerThan(1)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
