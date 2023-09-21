package ladder;

public class PrintLadder extends Ladder {
    public int currentRow;
    public int currentColumn;

    public PrintLadder(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    public static void currentLadder(int value){
        if (value == Direction.PLAYER_COLUMN.getValue()) {
            System.out.print("*"+value); // 현재 플레이어 위치 표시
        } else {
            System.out.print(value); // 빈 단계 표시
        }
    }

    public static void copyLadder(Integer clonedLadder[][]){
        for (int i = 0; i < ladder.length; i++) {
            clonedLadder[i] = ladder[i].clone();
        }
    }

    public static void printLadder(){
        for(Integer[] row : ladder){
            for(Integer value : row){
                System.out.print(value);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printCurrentLadder(Integer ladder[][]){
        for(Integer[] row : ladder){
            for(Integer value : row){
                currentLadder(value);
            }
            System.out.println("");
        }
        System.out.println();
    }


}
