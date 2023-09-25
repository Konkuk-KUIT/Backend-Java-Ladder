package ladder.core;

public interface LadderGameFactory {
    public static LadderGame randomLadderGame(int numberOfRow, int numberOfPerson) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(customLadderCreator);
        return new LadderGame(randomLadderCreator);
    }

    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(customLadderCreator);
    }
}
