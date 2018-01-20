package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class QuizOne extends AppCompatActivity {

    public static final String QUIZ_01_ANSWER_A_CLICKABLE_KEY = "quiz_01_answer_a_clickable_key";
    public static final String QUIZ_01_ANSWER_B_CLICKABLE_KEY = "quiz_01_answer_b_clickable_key";
    public static final String QUIZ_01_ANSWER_C_CLICKABLE_KEY = "quiz_01_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz01Answer_A;
    public CheckBox quiz01Answer_B;
    public CheckBox quiz01Answer_C;
    public ImageView nextIconImage;
    public int nextIconImageColor = Color.LTGRAY;
    public Button quizOneSubmiteButton;
    public boolean isSubmiteButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_one);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz01Answer_A = findViewById(R.id.quiz_02_answer_a);
        quiz01Answer_B = findViewById(R.id.quiz_01_answer_b);
        quiz01Answer_C = findViewById(R.id.quiz_01_answer_c);
        quizOneSubmiteButton = findViewById(R.id.quiz_one_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_01_ANSWER_A_CLICKABLE_KEY))
                quiz01Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_01_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_01_ANSWER_B_CLICKABLE_KEY))
                quiz01Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_01_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_01_ANSWER_C_CLICKABLE_KEY))
                quiz01Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_01_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz01Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz01Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz01Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_STATUS_KEY))
                isSubmiteButtonClicked = savedInstanceState.getBoolean(SUBMITE_BUTTON_STATUS_KEY);
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImageColor = savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY);
        }

        nextIconImage.setColorFilter(nextIconImageColor);
        if (isSubmiteButtonClicked){
            nextIconImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent openQuizTwo = new Intent(QuizOne.this, QuizTwo.class);
                    startActivity(openQuizTwo);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_01_ANSWER_A_CLICKABLE_KEY, quiz01Answer_A.isClickable());
        outState.putBoolean(QUIZ_01_ANSWER_B_CLICKABLE_KEY, quiz01Answer_B.isClickable());
        outState.putBoolean(QUIZ_01_ANSWER_C_CLICKABLE_KEY, quiz01Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz01Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz01Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz01Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        Intent openMainPage = new Intent(this, MainActivity.class);
        startActivity(openMainPage);
    }

    public void quizOneSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openQuizTwo = new Intent(QuizOne.this, QuizTwo.class);
                startActivity(openQuizTwo);
            }
        });

        if (quizOneAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizOne.this, "Your answer is incorrect", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_A.setBackgroundColor(Color.RED);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizOne.this, "There is one more correct answer", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizOne.this, "There is one more correct answer", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizOne.this, "Only one of your answers is correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_A.setBackgroundColor(Color.RED);
            quiz01Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizOne.this, "Only one of your answers is correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_A.setBackgroundColor(Color.RED);
            quiz01Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizOne.this, "All of your answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz01Answer_B.setBackgroundColor(Color.GREEN);
            quiz01Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizOne.this, "Only two of the answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
        } else if (quizOneAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizOne.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
        }
    }

    public String quizOneAnswerVariation(){
        if (quiz01Answer_A.isChecked() && !quiz01Answer_B.isChecked() && !quiz01Answer_C.isChecked()){
            return "a"; //Your answer is incorrect //0 point
        } else if (quiz01Answer_B.isChecked() && !quiz01Answer_A.isChecked() && !quiz01Answer_C.isChecked()){
            return "b"; //There is one more correct answer //2 point
        } else if (quiz01Answer_C.isChecked() && !quiz01Answer_A.isChecked() && !quiz01Answer_B.isChecked()){
            return "c"; //There is one more correct answer //2 point
        } else if (quiz01Answer_A.isChecked() && quiz01Answer_B.isChecked() && !quiz01Answer_C.isChecked()){
            return "ab"; //Only one of your answers is correct //2 point
        } else if (quiz01Answer_A.isChecked() && quiz01Answer_C.isChecked() && !quiz01Answer_B.isChecked()){
            return "ac"; //Only one of your answers is correct //2 point
        } else if (quiz01Answer_B.isChecked() && quiz01Answer_C.isChecked() && !quiz01Answer_A.isChecked()){
            return "bc"; //All of your answers are correct //3 point
        } else if (quiz01Answer_A.isChecked() && quiz01Answer_B.isChecked() && quiz01Answer_C.isChecked()){
            return "abc"; //Only two of the answers are correct //1 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public void setAllCheckBoxNonClickable(){
        quiz01Answer_A.setClickable(false);
        quiz01Answer_B.setClickable(false);
        quiz01Answer_C.setClickable(false);
    }

    public int getQuizAnswrBGColor(View quizAnswerView){
        int QuizAnswrColor = 0;
        Drawable answerBeckground = quizAnswerView.getBackground().mutate();
        if (answerBeckground instanceof ColorDrawable) {
            QuizAnswrColor = ((ColorDrawable) quizAnswerView.getBackground()).getColor();
            return QuizAnswrColor;
        }
        return QuizAnswrColor;
    }
}
