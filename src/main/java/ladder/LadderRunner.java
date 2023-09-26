package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before\n");
            // ladder string 선언
            // 0번 row ~ n -1 row까지 string 받아서
            // 더해줌

            // 이 부분 함수로 만들어서 위 아래로 하나씩 실행
            // 현재위치 -> 지금 i행, position

            position = rows[i].nextPosition(position);



            // 현재위치 -> 지금 i행, position
            System.out.println("After\n");
        }
        return position.getPosition();
    }


    /*
    Row 값들을 다 더해서 한 사다리를 만들고
    그 사다리를 출력

    Row는 한 행에대해서만 알고 있으므로

    Row는 한테는 한 행을 String으로 만들어서 받기

    여기서 모든 행 더하기


    */
}
