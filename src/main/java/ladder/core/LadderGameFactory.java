package ladder.core;

public class LadderGameFactory {
    public static LadderGame randomLadderGame(int numberOfRow, int numberOfPerson) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator();
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(customLadderCreator);
        return new LadderGame(randomLadderCreator, numberOfRow, numberOfPerson);
    }

    public static LadderGame customLadderGame(int numberOfRow, int numberOfPerson) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator();
        return new LadderGame(customLadderCreator, numberOfRow, numberOfPerson);
    }
}
