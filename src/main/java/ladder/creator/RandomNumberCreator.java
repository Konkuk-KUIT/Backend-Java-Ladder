package ladder.creator;

import java.util.Random;

public class RandomNumberCreator {
    private final Random random;

    public int getRandom(int num) {
        return random.nextInt(num);
    }

    public RandomNumberCreator() {
        this.random = new Random();
    }
}
