package ladder;

public class LadderPosition {
    private int y;
    private int x;

    // 초기화될 때에는 가장 위부터 초기화되므로 y좌표 0 고정
    private LadderPosition(int y, int x){
        initialize_validation(y, x);
        this.y = y;
        this.x = x;
    }

    public static LadderPosition of(int y, int x){
        return new LadderPosition(y, x);
    }

    public void move_down(){
        this.y += 1;
    }

    public void move_right(){
        this.x += 1;
    }

    public void move_left(){
        this.x -= 1;
    }

    public boolean initialize_validation(int y, int x){
        if (x >= 0 && y >= 0) return true;
        throw new RuntimeException("사다리의 노드좌표는 0이상의 값을 가져야 합니다.");
    }

    public boolean is_smaller_than_height(int height){
        if (this.y < height) return true;
        throw new ArrayIndexOutOfBoundsException("사다리의 크기를 벗어나는 좌표를 지정하였습니다.");
    }

    public boolean is_smaller_than_width(int width){
        if (this.x < width) return true;
        throw new ArrayIndexOutOfBoundsException("사다리의 크기를 벗어나는 좌표를 지정하였습니다.");
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }
}
