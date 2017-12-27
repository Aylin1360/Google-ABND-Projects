package liselimanyak.quizapp;

public class QuestionLibrary {

    private String mQuestions [] = {

            "Which one means fast ?",
            "Which one is a major mod ?",
            "Which one is a minor mod ?",
            "What does C stands for ?",
            "What is Fender's first name ?",
            "What does PRS stands for ?",
            "Who composed Fur Elise ?"

    };

    private String mChoices [][] = {

            {"Largo", "Moderato" , "Presto"},
            {"Dorian", "Phygrian", "Ionaian"},
            {"Aeloian", "Ionian", "Locrian"},
            {"Rerum", "Solis", "Dominus"},
            {"Les", "Leo", "Paul"},
            {"Paul Reed Smith", "Pearl Real Stan", "Paul Ramsay Samuray"},
            {"Mozart", "Beethoven","Bach"}
    };

    private String mCorrectAnswers [] = {"Presto", "Ionaian", "Aeloian", "Dominus", "Leo", "Paul Reed Smith", "Beethoven"};



    public String getQuestions(int a){
        String Questions = mQuestions[a];
        return Questions;
    }

    public String getChoice1(int a){
        String choice0 = mChoices [a] [0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices [a] [1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices [a] [2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers [a];
        return answer;
    }

    public int getLength(){
        return mQuestions.length;
    }
}
