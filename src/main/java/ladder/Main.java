package ladder;

public class Main {


    public static void main(String[] args) {
        //main에서 테스트
        int numberOfRow = 4;
        int numberOfColumn = 4;

        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);
        System.out.println("========사다리 초기 생성=======");
        ladder.printLadder(numberOfRow,numberOfColumn);

        ladder.drawLine(1,1);
        ladder.drawLine(2,1);
        ladder.drawLine(3,2);
        ladder.drawLine(1,3);
        ladder.drawLine(4,3);
        System.out.println("========사다리 설정 완료=======");
        ladder.printLadder(numberOfRow,numberOfColumn);

        System.out.println("==========게임 진행=========");
        int player1=ladder.run(1);
        System.out.println("p1 : "+player1);
        ladder.printLadder(numberOfRow,numberOfColumn);

        int player2=ladder.run(2);
        System.out.println("p2 : "+player2);
        ladder.printLadder(numberOfRow,numberOfColumn);

        int player3=ladder.run(3);
        System.out.println("p3 : "+player3);
        ladder.printLadder(numberOfRow,numberOfColumn);

        int player4=ladder.run(4);
        System.out.println("p4 : "+player4);
        ladder.printLadder(numberOfRow,numberOfColumn);

        System.out.println("========게임 최종 결과=======");
        System.out.println("p1 : "+player1);
        System.out.println("p2 : "+player2);
        System.out.println("p3 : "+player3);
        System.out.println("p4 : "+player4);
    }
}