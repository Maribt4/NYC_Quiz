package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean hasQuestion1Correct;
    private boolean hasQuestion2answer1Correct;
    private boolean hasQuestion2answer2Correct;
    private boolean hasQuestion2answer3Correct;
    private boolean hasQuestion2answer4Correct;
    private boolean hasQuestion3Correct;
    private boolean hasQuestion4Correct;
    private String Question5Input;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the result button is clicked.
     */
    public void calculateResult (View view) {
    // figure out if the user has questions 1 correct.
    RadioButton question1CorrectAnswer = findViewById(R.id.q_1_answer2);
    hasQuestion1Correct = question1CorrectAnswer.isChecked();
    // figure out if the user has questions 2 answer 1 correct.
    CheckBox question2CorrectAnswer1 = findViewById(R.id.q_2_answer1);
    hasQuestion2answer1Correct = question2CorrectAnswer1.isChecked();
    // figure out if the user has questions 2 answer 2 correct.
    CheckBox question2CorrectAnswer2 = findViewById(R.id.q_2_answer2);
    hasQuestion2answer2Correct = question2CorrectAnswer2.isChecked();
    // figure out if the user has questions 2 answer 3 correct.
    CheckBox question2CorrectAnswer3 = findViewById(R.id.q_2_answer3);
    hasQuestion2answer3Correct = question2CorrectAnswer3.isChecked();
    // figure out if the user has questions 2 answer 4 correct.
    CheckBox question2CorrectAnswer4 = findViewById(R.id.q_2_answer4);
    hasQuestion2answer4Correct = question2CorrectAnswer4.isChecked();
    // figure out if the user has questions 3 correct.
    RadioButton question3CorrectAnswer = findViewById(R.id.q_3_answer2);
    hasQuestion3Correct = question3CorrectAnswer.isChecked();
    // figure out if the user has questions 4 correct.
    RadioButton question4CorrectAnswer = findViewById(R.id.q_4_answer4);
    hasQuestion4Correct = question4CorrectAnswer.isChecked();
    // pull the answer the user gave on question 5.
    EditText Question5EditText = findViewById(R.id.q_5_answer);
    Question5Input = Question5EditText.getText().toString();
    countCorrectAnswers(hasQuestion1Correct,  hasQuestion2answer1Correct,  hasQuestion2answer2Correct,
         hasQuestion2answer3Correct,  hasQuestion2answer4Correct,  hasQuestion3Correct,
         hasQuestion4Correct,  Question5Input);
    if (correctAnswers < 5){
        Toast.makeText(this, getString(R.string.toast_part_1) + correctAnswers*100/5 + getString(R.string.toast_part_2_try_again), Toast.LENGTH_LONG).show();
        correctAnswers = 0;}
    else {Toast.makeText(this, getString(R.string.toast_part_1) + correctAnswers*100/5 + getString(R.string.toast_part_2_congratulations), Toast.LENGTH_LONG).show();
        correctAnswers = 0;}
    }

    /**
     * Counts and adds the user's correct answers.
     */
    private int countCorrectAnswers (boolean hasQuestion1Correct, boolean hasQuestion2answer1Correct, boolean hasQuestion2answer2Correct,
                                     boolean hasQuestion2answer3Correct, boolean hasQuestion2answer4Correct, boolean hasQuestion3Correct,
                                     boolean hasQuestion4Correct, String Question5Input){
        if (hasQuestion1Correct){correctAnswers = correctAnswers +1;}
        if ((hasQuestion2answer1Correct) && (!hasQuestion2answer2Correct) && (hasQuestion2answer3Correct) && (hasQuestion2answer4Correct)){correctAnswers = correctAnswers +1;}
        if (hasQuestion3Correct){correctAnswers = correctAnswers +1;}
        if (hasQuestion4Correct){correctAnswers = correctAnswers +1;}
        if (Question5Input.equals("France")){correctAnswers = correctAnswers +1;}
       return correctAnswers;}
}
