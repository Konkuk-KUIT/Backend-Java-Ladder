package ladder;

import ladder.Exception.ErrorCode;
import ladder.Exception.ErrorMessage;
import ladder.Exception.LadderPositionOutOfBoundsException;

public class Ladder {
    private Node[][] ladder;

    private Ladder(int numberOfRow, int numberOfPerson){
        this.ladder = new Node[numberOfRow][numberOfPerson];
        for (int y=0; y<numberOfRow; y++){
            for (int x=0; x<numberOfPerson; x++){
                ladder[y][x] = Node.of(Direction.NONE);
            }
        }
    }

    public int getHeight(){
        return this.ladder.length;
    }

    public int getWidth(){
        return this.ladder[0].length;
    }

    public static Ladder of(int numberOfRow, int numberOfPerson){
        return new Ladder(numberOfRow, numberOfPerson);
    }

    public void setNode(LadderPosition position, Direction direction){
        positionValidation(position);
        this.ladder[position.getY()][position.getX()] = Node.of(direction);
    }

    public Node getNodeByPosition(LadderPosition position){
        return ladder[position.getY()][position.getX()];
    }

    private void positionValidation(LadderPosition position){
        try {
            checkPositionInBoundary(position);
            checkOverlapping(position);
        } catch (LadderPositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void checkPositionInBoundary(LadderPosition position) throws LadderPositionOutOfBoundsException {
        if (!heightCheck(position)) {
            throw new LadderPositionOutOfBoundsException(ErrorCode.LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION, ErrorMessage.LADDER_HEIGHT_OUT_OF_BOUND_EXCEPTION);
        }
        if (!widthCheck(position)){
            throw new LadderPositionOutOfBoundsException(ErrorCode.LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION, ErrorMessage.LADDER_WIDTH_OUT_OF_BOUND_EXCEPTION);
        }
        if (!zeroCheck(position)){
            throw new LadderPositionOutOfBoundsException(ErrorCode.LADDER_ZERO_OUT_OF_BOUND_EXCEPTION, ErrorMessage.LADDER_ZERO_OUT_OF_BOUND_EXCEPTION);
        }
    }

    private void checkOverlapping(LadderPosition position) throws LadderPositionOutOfBoundsException {
        if (!this.ladder[position.getY()][position.getX()].is_NONE()){
            throw new LadderPositionOutOfBoundsException(ErrorCode.LADDER_OVERLAPPING_EXCEPTION, ErrorMessage.LADDER_OVERLAPPING_EXCEPTION);
        }
    }

    private boolean heightCheck(LadderPosition position){
        return position.getY() < this.ladder.length;
    }

    private boolean widthCheck(LadderPosition position){
        return position.getX() < this.ladder[0].length;
    }

    private boolean zeroCheck(LadderPosition position){
        return position.getX() >= 0 && position.getY() >= 0;
    }
}
