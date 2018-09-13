public class Question {

    private String id;
    private String question;
    private Answer answer;


    public Question(String id, String question, Answer answer) {
        this.question = question;
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public Answer getAnswer() {
        return this.answer;
    }


    public boolean getEvaluatedAnswer(String input) {
        String[] userAnswerArray = input.split(",");
        if (userAnswerArray.length == 1) {
            return this.getAnswer().evaluateAnswerByInput(input.toLowerCase());
        }
        else {
            int falseCount = 0;
            int trueCount = 0;
            for (String item : userAnswerArray) {
                if (this.getAnswer().evaluateAnswerByInput(item.toLowerCase())) {
                    trueCount ++;
                }
                else {
                    falseCount ++;
                }
            }
        if (trueCount > falseCount ) {
            return true;
        }
        return false;
        }
    }
    
}