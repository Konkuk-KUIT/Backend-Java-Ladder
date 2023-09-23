package ladder;

public enum ConstantMessage {
    AFTER("AFTER"), BEFORE("BEFORE");

    private String messasge;

    ConstantMessage(String messasge) {
        this.messasge = messasge;
    }

    public String getMessasge(){
        return this.messasge;
    }
}
