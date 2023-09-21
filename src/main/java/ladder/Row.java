package ladder;

public class Row {

    int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public boolean isLeft(int position) {
        return row[position - 1] == Direction.LEFT.getValue();
    }

    public boolean isRight(int position) {
        return row[position - 1] == Direction.RIGHT.getValue();
    }

    public int nextPosition(int position) {
        if (isLeft(position)) {
            return position + Direction.LEFT.getValue();
        }
        if (isRight(position)) {
            return position + Direction.RIGHT.getValue();
        }
        return position;
    }

    public void drawLine(int selectPosition, Direction direction) {
        //밖으로 그리기 금지
        if (selectPosition == 1 && direction == Direction .LEFT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DIRECTION.getMessage());
        }
        if (selectPosition == row.length && direction == Direction.RIGHT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        //겹치게 그리기 금지
        if (row[selectPosition - 1] != 0  || row[selectPosition + direction.getValue() - 1] != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        //그리기
        row[selectPosition - 1] = direction.getValue();
        row[nextPosition(selectPosition) - 1] = direction.getOppositeValue();
    }
}
