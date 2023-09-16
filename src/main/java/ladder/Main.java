package ladder;

public class Main {



    public static void main(String[] args) {
        //main에서 테스트
        int numberOfRow = 7;
        int numberOfColumn = 7;

        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);

        ladder.drawLine(1,1);
        ladder.drawLine(2,1);
        ladder.drawLine(3,2);
        ladder.drawLine(1,3);
        ladder.drawLine(4,3);
        int player1=ladder.run(2);
        int player2=ladder.run(3);
        int player3=ladder.run(1);
        System.out.println("p1 : "+player1);
        System.out.println("p2 : "+player2);
        System.out.println("p3 : "+player3);
    }
}