package ladder;

import static ladder.Direction.*;
import static ladder.ExceptionMessage.INVALID_POSITION;
import static ladder.ExceptionMessage.LINE_DUPLICATION;

public class Row {

    private final Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        this.nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.of(NONE);
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void drawLine(Position position) {
        validateLineRange(position);
        validateLineDuplication(position);
        setDirectionAtPosition(position, RIGHT);
        setDirectionAtPosition(position.next(), LEFT);
    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        nodes[position.getPosition()] = Node.of(direction);
    }

    public Position moveLine(Position currentPosition) {
        validateIndex(currentPosition);
        return nodes[currentPosition.getPosition()].move(currentPosition);
    }

    private void validateIndex(Position position) {
        if (position.getPosition() >= nodes.length) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateLineRange(Position position) {
        if (position.getPosition() >= nodes.length - 1) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateLineDuplication(Position position) {
        if(!nodes[position.getPosition()].isNone() || !nodes[position.getPosition() + 1].isNone()) {
            throw new IllegalArgumentException(LINE_DUPLICATION.getMessage());
        }
    }
}
