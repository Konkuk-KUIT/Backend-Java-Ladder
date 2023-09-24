# To do list

## 1. 하드 코딩 상수 변경
1.1 Directions

1.2 ErrorMessage

## 2. 원시값 포장
1. NumberOfRow, numberOfPerson, -> NaturalNumber
2. 배열 인덱스 -> Position 클래스 포장
3. Row 클래스 내 int [] -> Node 배열로 변경

각각의 원시값에 대한 예외처리 로직 필요
그게 모여있는게 아니라 외부에 빠져있음


## 3. 클래스 분리
3-1. ladderRunner 사다리 움직임 담당
3-2. ladderCreator 사다리 생성 담당
3-3. ladderGame 사다리 게임 전체 흐름을 담당