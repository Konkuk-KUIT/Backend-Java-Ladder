package ladder;

public class Ladder {

    /*
    사다리에 다리를 놓기 위한 좌표정보
    fromRow, fromColumn : 시작점의 y, x 좌표
    toRow, toColumn : 도착점의 y, x좌표
     */
    public static class LegPoint{
        private final int fromRow;
        private final int fromColumn;
        private final int toRow;
        private final int toColumn;

        public LegPoint(int fromRow, int fromColumn, int toRow, int toColumn){
            this.fromRow = fromRow;
            this.fromColumn = fromColumn;
            this.toRow = toRow;
            this.toColumn = toColumn;
        }
    }

    private final int[][] rows;

    public int[][] getLadder(){
        return rows;
    }

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    /*
    LegPoint의 좌표정보를 활용해서 시작점과 끝점이 서로의 위치를 가리킬 수 있도록 한다.
    위치는 y*width + x 형태로 표현하여 2차원 배열의 특정 위치를 int형 정수로 나타낼 수 있도록 인코딩
     */
    public void drawLine(LegPoint legPoint){
        int from = legPoint.fromRow * rows[0].length + legPoint.fromColumn + 1;
        int to = legPoint.toRow * rows[0].length + legPoint.toColumn + 1;

        // 잘못된 위치좌표로 인해 다리를 그릴 수 없는 경우 RuntimeException
        if (!validate_legPoints(legPoint)){
            throw new RuntimeException("사다리를 그릴 수 없는 좌표를 설정하였습니다.");
        }

        rows[legPoint.fromRow][legPoint.fromColumn] = to;
        rows[legPoint.toRow][legPoint.toColumn] = from;
    }

    /*
    입력받은 legPoint의 각 좌표값이 유효한 좌표값인지 판단하는 코드
    x좌표의 경우 0 ~ width 안에 들어오면 통과
    y좌표의 경우 가장 아래쪽은 도착지점이므로 사다리를 연결할 수 없다. 따라서 0 ~ height-1 안에 들어와야 통과
     */
    private boolean validate_legPoints(LegPoint legPoint){
        return 0 <= legPoint.toRow && legPoint.toRow < rows.length - 1
                && 0 <= legPoint.fromRow && legPoint.fromRow < rows.length - 1
                && 0 <= legPoint.toColumn && legPoint.toColumn < rows[0].length
                && 0 <= legPoint.fromColumn && legPoint.fromColumn < rows[0].length;
    }

    /*
    시작점의 x좌표를 입력받고 y좌표는 0부터 시작
    y좌표가 사다리의 가장 아래에 도달하면 도착한 것으로 구현
     */
    public int run(int start_point){
        int y = 0;
        int x = start_point;
        while(y < rows.length-1){
            int destination = rows[y][x];
            if (destination == 0){
                y += 1;
                continue;
            }
            // y, x 에 목적지 좌표를 찍을 수 있도록 디코딩,
            // 서로서로를 가리켜서 무한루프에 빠지기 때문에 다음 위치를 바로 한칸 내려주어야 한다. 따라서 y좌표에서 1을 빼줌
            y = (destination-1) / rows[0].length + 1;
            x = (destination-1) % rows[0].length;
        }
        return x;
    }

    // TODO: 사다리가 교차하여 무한루프에 빠지는 경우 예외처리
}
