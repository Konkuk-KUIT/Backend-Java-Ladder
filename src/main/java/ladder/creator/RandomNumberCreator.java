package ladder.creator;

import java.util.Random;

public class RandomNumberCreator {
    private Random random;
    RandomNumberCreator(){
        random=new Random();
    }
    public int getRandomNumber(int num){return random.nextInt(num);}

}
