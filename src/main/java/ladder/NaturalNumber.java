package ladder;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    //외부에서 Wrapper class를 이용하여 만들기 위해선 팩토리 메소드 방식으로 NaturalNumber of를 구현함
    //이 메소드를 이용해 외부에서 number를 감싸서 NaturalNumber로 사용 가능하다.
    public static NaturalNumber of(int number){
        return new NaturalNumber(number);
    }

    public void validate(int number){
        if(!isNaturalNumber(number)){
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    private static boolean isNaturalNumber(int number){
        return number >= 1;
    }
}