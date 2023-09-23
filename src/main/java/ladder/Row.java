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

    public String PrintRow(LadderPosition current_ladderPosition, int nth_call){ // 노드로 빼기 Row에 대한 의존성 낮추기
        String row = "";
        for(int i=0; i<nodes.length; i++){
            LadderPosition drawladderPosition = new LadderPosition(Position.of(i), Position.of(nth_call));
            row += nodes[i].GetDirection().getValue();
            row += nodes[i].is_current(LadderPosition.PositionisEquall(current_ladderPosition, drawladderPosition));
//            if(x.getValue() == i && yb.getValue() == y.getValue()){ // 외부에서 따로 뺄 수 있도록 하기
//                row += "*";
//            }
            row += " ";

        }
        return row;
    }
//    public String PrintRow_current(){
//        String row = "";
//        return row;
//    }

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
        //System.out.println(direction.getValue());
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