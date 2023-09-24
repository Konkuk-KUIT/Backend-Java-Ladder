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

    private void validatePosition(Position position) {
        if (isInvalidDrawPosition(position)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || isDuplicatedDrawPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 2) || position.isSmallerThan(0);
    }

    private boolean isDuplicatedDrawPosition(Position position) {
        return (nodes[position.getValue()].isRight()
                || nodes[position.next().getValue()].isRight()
                || nodes[position.getValue()].isLeft());
    }

    public boolean isDrawable(Position position) {
        return !isInvalidDrawPosition(position) && !isDuplicatedDrawPosition(position);
    }

    public void generateRow(StringBuilder sb, Position DrawingRow, LadderPosition currentPosition) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].appendSymbol(sb);
            if (currentPosition.equals(LadderPosition.of(DrawingRow, Position.of(i)))) {
                sb.append("*");
            }
            sb.append(" ");
        }
        sb.append("\n");
    }

    public boolean isLineDrawn(int j) {
        return nodes[j].isRight();
    }
}