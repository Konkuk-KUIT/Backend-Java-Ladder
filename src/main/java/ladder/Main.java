package ladder;

public class Main {


    public static void main(String[] args) {
        //main에서 테스트
        int numberOfRow = 4;
        int numberOfColumn=4;
        NaturalNumber numberOfPerson =NaturalNumber.of(4);


        Ladder ladder = new Ladder(numberOfRow, numberOfColumn);
        System.out.println("========사다리 초기 생성=======");
        PrintLadder.printLadder();
        System.out.println("========사다리 설정 완료=======");
        ladder.ladderCreator(numberOfPerson);
        //PrintLadder.printLadder();
        System.out.println("==========게임 진행=========");
        System.out.println("==========시 작!=========");
        PrintLadder.printLadder();
        int player1=ladder.run(2);
        System.out.println("p1 : 2\n");
        ladder.printPlayer(2);


        System.out.println("========게임 최종 결과=======");
        System.out.println("p1 : "+player1);
    }
}