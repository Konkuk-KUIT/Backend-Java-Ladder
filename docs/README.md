# To Do List

## 1. 하드 코딩 상수 변경
1. 하드 코딩 상수나 enum으로 변경
 -> enum(캡슐화 가능)이나 static final(변수 레벨의 상수를 만들 때 사용)
1.1 enum class의 장점.
 -> enum class를 사용해서 캡슐화를 하게 되면 해당 static final로 선언했을 때에 비해
    메서드와 필드를 가질 수 있다. -> 특정한 로직이나 상태를 연결할 수 있고 재사용 성이나 확장성에서 더 좋다.
2. 예외 처리 IllegalArgumentException으로 변경해서 요류 메세지 표시하기 
3. 예외 error message

## 2. 원시값 포장
1. NumberOfRow, NumberOfPerson -> NaturalNumber
2. 배열 인덱스 -> Position 클래스 포장
3. Row 클래스 내 int[] -> Node 배열로 변경

## 3. 클래스 분리
1. LadderRunner 사다리 움직임 담당
2. LadderCreator 사다리 생성 담당
3. LadderGame 사다리 게임 전체 흐름을 담당