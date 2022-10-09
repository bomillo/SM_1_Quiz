package dominik.postolowicz.quiz;

public class Question {
    private int id;
    private boolean answer;

    public Question(int id, boolean answer){
        this.id=id;
        this.answer=answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }
}
