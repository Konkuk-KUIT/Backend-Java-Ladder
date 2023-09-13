package ladder;

public class Main {



    public static void main(String[] args) {

        int numberOfRow = 5;
        int numberOfColumn = 7;

        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);

        ladder.drawLine(2,1);
        ladder.drawLine(3,4);
        ladder.drawLine(3,7);
        int player1=ladder.run(1);
        System.out.println(player1 );

    }
}