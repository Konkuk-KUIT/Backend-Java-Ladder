package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private Node[] nodes;
    private NaturalNumber numberofPerson;

    public Row(NaturalNumber numberOfPerson) {

        this.numberofPerson = numberOfPerson;
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    // 사다리의 한 행 출력 (현재 플레이어가 위치한 행)
    public String OneRow(Position position){
        StringBuilder oneRowString = new StringBuilder();
        for(int i=0; i<numberofPerson.getNumber(); i++){
            oneRowString.append(nodes[i].NodeValue());
            if(i == position.getValue()){
                oneRowString.append("*");
            }
            oneRowString.append("  ");
        }
        return oneRowString.toString();
    }

    // 사다리의 한 행 출력 (현재 플레이어가 위치하지 않는 행)
    public String OneRow_1(){
        StringBuilder oneRowString = new StringBuilder();
        for(int i=0; i<numberofPerson.getNumber(); i++){
            oneRowString.append(nodes[i].NodeValue());
            oneRowString.append("  ");
        }
        return oneRowString.toString();
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