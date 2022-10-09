package dominik.postolowicz.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private TextView questionIndexTextView;

    private int currentIndex;
    private Question[] questions= new Question[]{
            new Question(R.string.q_1,true),
            new Question(R.string.q_2,false),
            new Question(R.string.q_3,true),
            new Question(R.string.q_4,false),
            new Question(R.string.q_5,false),
    };

    private void checkAnswer(boolean userAnswer){
        int resultMessageId;
        if(questions[currentIndex].getAnswer()==userAnswer){
            resultMessageId=R.string.toast_right;
        }else {
            resultMessageId=R.string.toast_wrong;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion(){
        currentIndex = (currentIndex+1)%questions.length;
        setQuestionTextViewWithCurrentQuestion();
    }

    private void setQuestionTextViewWithCurrentQuestion(){
        questionIndexTextView.setText((currentIndex+1)+"/"+questions.length);
        questionTextView.setText(questions[currentIndex].getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.text_question);
        questionIndexTextView = findViewById(R.id.text_question_index);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextQuestion();
            }
        });
        setQuestionTextViewWithCurrentQuestion();
    }
}