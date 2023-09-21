package ladder;

public class Main {


    public static void main(String[] args) {
        //main에서 테스트
        int numberOfRow = 4;
        int numberOfColumn = 4;

        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);
        System.out.println("========사다리 초기 생성=======");
        ladder.printLadder();

        ladder.drawLine(1,1);
        ladder.drawLine(2,1);
        ladder.drawLine(3,2);
        ladder.drawLine(1,3);
        ladder.drawLine(4,3);
        System.out.println("========사다리 설정 완료=======");
        ladder.printLadder();

        System.out.println("==========게임 진행=========");
        int player1=ladder.run(2);
        System.out.println("p1 : "+player1);
        ladder.printPlayer(2);

        System.out.println("========게임 최종 결과=======");
        System.out.println("p1 : "+player1);
    }
}