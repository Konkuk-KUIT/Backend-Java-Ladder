package ladder;

public class Item {
    private final int state;

    private Item(int state) {
        this.state = state;
    }

    public void move(Position position) {
        if (isLeft()) {
            position.moveLeft();
            return;
        }

        if (isRight()) {
            position.moveRight();
        }
    }

    public boolean isLeft() {
        return this.state == -1;
    }

    public boolean isRight() {
        return this.state == 1;
    }

    public static Item generateItem(int state) {
        return new Item(state);
    }

}
