package ladder;

public class LadderMove extends Ladder {
    public LadderMove(int numberOfRow, int numberOfPerson) {
        super(numberOfRow, numberOfPerson);
    }

    public int leftMove(int currentRow, int currentCol){ //왼쪽으로 이동하는 메서드
        rows[currentRow][currentCol - 1] = 2;
        currentCol--;
        //System.out.println("leftmove 결과 : "+rows[currentRow][currentCol]+" currenRow = "+currentRow+" currentCol = "+currentCol);
        return currentCol;
    }
    public int rightMove(int currentRow, int currentCol){ //오른쪽으로 이동하는 메서드
        rows[currentRow][currentCol] = 2;
        currentCol++;
        //System.out.println("rightmove 결과 : "+rows[currentRow][currentCol]+" currenRow = "+currentRow+" currentCol = "+currentCol);
        return currentCol;
    }
}
