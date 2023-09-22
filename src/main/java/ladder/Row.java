package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private final Node[] nodes;

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

    public String printRow() {
        StringBuilder result = new StringBuilder(nodes[0].printNode());
        for (int i = 1; i < nodes.length; i++) {
            result.append(" ");
            result.append(nodes[i].printNode());
        }
        return result.toString();
    }
    public String printRow(Position position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            result.append(nodes[i].printNode());
            if (i == position.getPosition()) {
                result.append("*");
            }
            result.append(" ");
        }
        return result.toString();
    }
    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getPosition()].move(currentPosition);
    }

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        nodes[startPosition.getPosition()] = Node.of(direction);
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION_OUT.getMessage());
        }
        if(nodes[startPosition.getPosition()].isRight()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION_EXIST.getMessage());
        }
        if(nodes[startPosition.getPosition()].isLeft()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION_OVERLAP.getMessage());
        }
        if (nodes[startPosition.next().getPosition()].isRight()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION_OVERLAP.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }
}
