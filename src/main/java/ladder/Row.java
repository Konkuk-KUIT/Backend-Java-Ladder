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

    public String getLine() {
        String strings = "";
        for (Node n : nodes) {
            strings += String.format("%2d", n.getValue()) + "\t";
        }
        return strings;
    }



    public String getStarLine(int position) {
        StringBuilder strings = new StringBuilder();

        for (int i = 0; i < nodes.length; i++) {
            String st = String.format("%2d%s\t", nodes[i].getValue(), (i == position) ? "*" : "");
            strings.append(st);
        }

        return strings.toString();
    }

    public void drawLine(Position startPosition) {
        checkDraw(startPosition);
        setLineVal(startPosition, Direction.RIGHT);
        setLineVal(startPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);
        return nodes[currentPosition.getValue()].move(currentPosition);
    }

    public void setLineVal(Position startPosition, Direction direction) {
        nodes[startPosition.getValue()] = Node.of(direction);
    }

    public void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    public void checkDraw(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || nodes[startPosition.getValue()].isRight()
                || nodes[startPosition.next().getValue()].isRight()
                || nodes[startPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    public boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }
    public boolean isInvalid(Position position){
        if(isInvalidDrawPosition(position))
            return false;
        if(nodes[position.getValue()].isLeft() || nodes[position.next().getValue()].isRight() || nodes[position.getValue()].isRight())
            return false;
        return true;
    }
}