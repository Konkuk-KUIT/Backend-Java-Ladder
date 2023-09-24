package ladder;

public enum Direction {
        /*매직 넘버 enum으로 대체*/
        PASSED_SPACE(2),CREATED_LINE_SPACE(1);
        private final int value;
        Direction(int value) {
            this.value=value;
        }
        public  int getValue(){
            return value;
        }
    }

