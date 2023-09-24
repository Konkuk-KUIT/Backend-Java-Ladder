package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            //before 현재 위치에 일치했을때만 메서드에 좌표 넘겨주기
            printRowsBefore(i,position.getValue());
            position = rows[i].nextPosition(position);
            printRowsAfter(i,position.getValue());
            //after
        }
        return position.getValue();
    }
    private void printRowsBefore(int row, int col){
        String rowsString = "Before\n";
        for(int i = 0; i < rows.length; i++){
            if(isThisLine(i,row)){
                rowsString+=rows[i].getRowInfo(row,col,true);
                continue;
            }
            rowsString += rows[i].getRowInfo(row,col,false);
        }
        System.out.println(rowsString);
    }
    private void printRowsAfter(int row, int col){
        String rowsString = "After\n";
        for(int i = 0; i < rows.length; i++){
            if(isThisLine(i,row)){
                rowsString+=rows[i].getRowInfo(row,col,true);
                continue;
            }
            rowsString += rows[i].getRowInfo(row,col,false);
        }
        System.out.println(rowsString);
    }

    private boolean isThisLine(int curPrintRow, int row){
        return curPrintRow==row;
    }
}
