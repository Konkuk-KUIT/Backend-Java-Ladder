package ladder.creator;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static ladder.Direction.*;

public class RandomLadderCreator implements LadderCreator{
    /**
     * 랜덤 생성 시 라인 개수 -> 한 행에 사람 수의 3분의 1개 정도!
     * 생성할 때는 row 하나씩
     * 랜덤으로 생성했을 때 생성할 수 없는 위치면? -> 다시 생성
     */
    private final Row[] rows;

    public RandomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {

        rows = new Row[numberOfRow.getNumber()];

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }

        int ladderSize = (int) numberOfPerson.getNumber()/3;
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            HashSet<Integer> numberList = getRandomNumberList(ladderSize, numberOfPerson.getNumber()+1);
            drawLine(i, numberList);
        }

    }

    private void drawLine(int i, HashSet<Integer> numberList) {
        for (Integer number : numberList) {
            drawLine(Position.of(i),Position.of(number));
        }
    }

    private HashSet<Integer> getRandomNumberList(int ladderSize, int maxSize) {
        HashSet<Integer> numberList = new HashSet<>();
        int[] check = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            check[i] = 0;
        }

        int cnt = 0;
        while (cnt < ladderSize) {
            int number = getRandomNumber(1, maxSize-1);
            cnt = addNumber(numberList, check, cnt, number);
        }
        return numberList;
    }

    private int addNumber(HashSet<Integer> numberList, int[] check, int cnt, int number) {
        if(validateRandomNumber(number, check)){
            numberList.add(number);
            check[number] = 1;
            cnt +=1;
        }
        return cnt;
    }

    private boolean validateRandomNumber(int number, int[] check) {
        if (number == 1) {
            return (check[2] != 1);
        }
        if (number == check.length-1) {
            return false;
        }
        if (number == check.length-2) {
            return (check[number-1] != 1);
        }
        return (check[number - 1] != 1 && check[number + 1] != 1);
    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "RandomLadderCreator{" +
                "rows=" + Arrays.toString(rows) +
                '}';
    }
}
