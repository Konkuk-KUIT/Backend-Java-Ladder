#To-Do List

##1. Row 클래스 생성
1. Row에 관련된 로직을 Row 클래스 내부에서 정의
   1. drawLine 메소드
   2. run 메소드 
   3. nextPosiotion 메소드
2. Row에 관련된 예외처리를 Row 클래스 내부에서 처리

##2. 하드 코딩 상수 변경
1. Direction
2. 예외 메시지 생성 및 상수화

##3. 원시값 포장
1. numberOfRow, numberOfPerson -> NaturalNumber
2. 배열 인덱스 -> Position 클래스 포장
3. Row 클래스 내 int [] -> Node 클래스로 변경

##4. 클래스 분리
1. LadderRunner 사다리 움직임 담당
2. LadderCreator 사다리 생성 담당
3. LadderGame 사다리 게임 전체 흐름 담당
