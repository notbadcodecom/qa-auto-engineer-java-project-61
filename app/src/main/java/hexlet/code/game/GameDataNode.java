package hexlet.code.game;

public final class GameDataNode {
    private final String question;
    private final String answer;
    private GameDataNode next;

    public GameDataNode(String questionValue, String answerValue) {
        this.question = questionValue;
        this.answer = answerValue;
        this.next = null;
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
