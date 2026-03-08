package hexlet.code.game;

public class GameDataNode {
    private final String question;
    private final String answer;
    private GameDataNode next;

    public GameDataNode(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setNext(GameDataNode nextPair) {
        this.next = nextPair;
    }

    public GameDataNode getNext() {
        return next;
    }
}
