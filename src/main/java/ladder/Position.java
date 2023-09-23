package ladder;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    //팩토리 메소드
    public static Position of(int position){
        validatePosition(position); //position에 대한 validation을 position 내부에서 할 수 있다.
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if(!isPosition(position)){
            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
        }
    }

    private static boolean isPosition(int position) {
        return position >=0;
    }

    public Position prev(){
        return new Position(position-1);
    }

    public Position next(){
        return new Position(position+1);
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
