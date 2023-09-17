package ladder;

public class Position {
    protected int xPos;
    protected int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Position(int xPos) {
        this.xPos = xPos;
        this.yPos = 0;
    }

    public void changePosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean isXPosEquals(int xPos) {
        return this.xPos == xPos;
    }

    public boolean isYPosEquals(int yPos) {
        return this.yPos == yPos;
    }

    public void addOneToYPos() {
        this.yPos++;
    }

    public int getxPos() {
        return xPos;
    }
}
