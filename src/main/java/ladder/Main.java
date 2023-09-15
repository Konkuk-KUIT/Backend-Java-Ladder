package ladder;

public class Main {



    public static void main(String[] args) {
        //main에서 테스트
        int numberOfRow = 7;
        int numberOfColumn = 7;

        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);

        ladder.drawLine(1,1);
        ladder.drawLine(4,1);
        ladder.drawLine(5,1);
        ladder.drawLine(6,1);
        int player1=ladder.run(1);
        System.out.println(player1 );

    }
}