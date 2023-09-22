package ladder;

public class PrintLadder extends Ladder {

    public PrintLadder(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    public static void printPlayerLadder(int currentRow,int currentColumn){
        for(int i=0;i<ladder.length;i++) {
            for(int j=0;j<ladder[0].length;j++){
                if(i==currentRow&&j==currentColumn){
                    System.out.print("*"+ladder[i][j]);
                }else{
                    System.out.print(ladder[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printLadder(){
        for(Integer[] row : ladder){
            for(Integer value : row){
                System.out.print(value);
            }
            System.out.println();
        }
        System.out.println();
    }

}
