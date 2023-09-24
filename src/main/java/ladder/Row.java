package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i=0; i<numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position col) {
        validateDrawLinePosition(col);
        nodes[col.getPosition()] = Node.of(Direction.RIGHT);
        nodes[col.next().getPosition()] = Node.of(Direction.LEFT);
    }

    public Position nextPosition(Position position) {
        validatePosition(position);

        if (nodes[position.getPosition()].isRight()) {
            return position.next();
        }
        if (nodes[position.getPosition()].isLeft()) {
            return position.prev();
        }
        return position;
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || nodes[startPosition.getPosition()].isRight()
                || nodes[startPosition.next().getPosition()].isRight()
                || nodes[startPosition.getPosition()].isLeft()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }
    private void validatePosition(Position position) {
        if (position.isSmallerThan(0) || position.isBiggerThan(nodes.length-1)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
