package ladder;

public class Row {
    private Node[] nodes;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        nodes = new Node[numberOfPerson];
        for (int i = 0; i < numberOfPerson; i++) {
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

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("인원 수는 1명 이하일 수 없습니다.");
        }
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || nodes[startPosition.getValue()].isRight()
                || nodes[startPosition.next().getValue()].isRight()
                || nodes[startPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException("사다리를 그릴 수 없는 위치입니다.");
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }
}