package ladder;

import ladder.core.LadderSize;
import ladder.position.LadderPosition;
import ladder.position.Position;

public class Random {
    LadderSize ladderSize;
    public Random(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
    }

    public int lineCount(LadderSize ladderSize) {
//        return NaturalNumber.of((int) (ladderSize.getNumberOfPerson() * ladderSize.getNumberOfRow() * 0.3));
        return (int) (ladderSize.getNumberOfPerson() * ladderSize.getNumberOfRow() * 0.3);
    }

    public LadderPosition randomPosition(LadderSize ladderSize) {
        return new LadderPosition(startRow(ladderSize), startPosition(ladderSize));
    }
    public int startRow(LadderSize ladderSize) {
        return (int) (Math.random() * ladderSize.getNumberOfRow());
    }
    public Position startPosition(LadderSize ladderSize) {
        return Position.of((int)(Math.random() * (ladderSize.getNumberOfPerson()-1)));
    }
}

// 래더사이즈에서 인원수를 이용해서 랜덤수로 시작 포지션 뽑기
// 인원*행수*0.3만큼 랜덤으로 다리 생성