package ladder;

public class Row {
    Item[] items;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        items = new Item[numberOfPerson];

        for (int i = 0; i < numberOfPerson; i++) {
            items[i] = Item.generateItem(0);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        items[startPosition.getPosition()] = Item.generateItem(1);
        items[startPosition.getPosition() + 1] = Item.generateItem(-1);
    }

    public void nextPosition(Position position) {
        validatePosition(position);
        items[position.getPosition()].move(position);
    }


    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(Position position) {
        if (!position.isSmaller(items.length)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);

        if (items[startPosition.getPosition()].isLeft() || items[startPosition.getPosition() + 1].isRight()) {
            throw new IllegalArgumentException();
        }

    }
}