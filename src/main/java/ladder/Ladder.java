package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    /** DrawLine 관련 */
    public void drawLine(Position position){
        validateDrawable(position);
        rows[position.x-1][position.y-1] = 1;
        rows[position.x-1][position.y] = -1;
    }

    private void validateDrawable(Position position){
        // 유효하지 않은 좌표값
        if(position.x > rows.length || position.x-1 < 0 || position.y > rows[0].length || position.y-1 < 0) {
            throw new IllegalArgumentException("Wrong Position Value");
        }

        // 이미 그려져있는 line
        if(rows[position.x-1][position.y-1] == 1) {
            throw new IllegalArgumentException("Already Drawn Line");
        }

        // 연속되는 line 금지 : 이어지는 Position 의 Rows Value 가 not 1
        if(!(position.y-1 <= rows[position.x-1].length - 2 && rows[position.x-1][position.y-1] != 1)){
            throw new IllegalArgumentException("Cannot Draw Consecutive Line");
        }
    }

    /** Run 관련 */
    public int run(int lineNumber){
        validateRunnable(lineNumber);
        Position currentPosition = new Position(0, lineNumber-1);

        while(checkMovable(currentPosition)){
            moveToNext(currentPosition);
        }
        return currentPosition.y + 1;
    }

    private void validateRunnable(int lineNumber){
        if(!(lineNumber >= 0 && lineNumber <= rows[0].length)){
            throw new IllegalArgumentException("Not Runnable Line");
        }
    }

    private boolean checkMovable(Position position){
        if(position.x == rows.length){
            return false;
        }
        return true;
    }

    private void moveToNext(Position currentPosition){
        int moveDirection = rows[currentPosition.x][currentPosition.y];

        if(moveDirection == 0){
            currentPosition.x += 1;
            return;
        }
        currentPosition.x += 1;
        currentPosition.y += moveDirection;
    }

    /** 그 외 */
    public void printResultLadder(){
        System.out.print("  ");
        for(int i=1; i<=rows[0].length; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i=0; i<rows.length; i++){
            System.out.print(i+1 + " ");

            for(int value : rows[i]){
                switch(value){
                    case 0:
                        System.out.print("| ");
                        break;
                    case 1:
                        System.out.print("|-");
                        break;
                    case -1:
                        System.out.print("| ");
                        break;
                    default:
                        System.out.println(value);
                        throw new RuntimeException();
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getValueOfLadder(int row, int col){
        return rows[row-1][col-1];
    }
}
