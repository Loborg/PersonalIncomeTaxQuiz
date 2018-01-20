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

public class QuizThree extends AppCompatActivity {

    public static final String QUIZ_03_ANSWER_A_CLICKABLE_KEY = "quiz_03_answer_a_clickable_key";
    public static final String QUIZ_03_ANSWER_B_CLICKABLE_KEY = "quiz_03_answer_b_clickable_key";
    public static final String QUIZ_03_ANSWER_C_CLICKABLE_KEY = "quiz_03_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz03Answer_A;
    public CheckBox quiz03Answer_B;
    public CheckBox quiz03Answer_C;
    public ImageView nextIconImage;
    public int nextIconImageColor = Color.LTGRAY;
    public Button quizThreeSubmiteButton;
    public boolean isSubmiteButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz03Answer_A = findViewById(R.id.quiz_03_answer_a);
        quiz03Answer_B = findViewById(R.id.quiz_03_answer_b);
        quiz03Answer_C = findViewById(R.id.quiz_03_answer_c);
        quizThreeSubmiteButton = findViewById(R.id.quiz_three_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_03_ANSWER_A_CLICKABLE_KEY))
                quiz03Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_03_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_03_ANSWER_B_CLICKABLE_KEY))
                quiz03Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_03_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_03_ANSWER_C_CLICKABLE_KEY))
                quiz03Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_03_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz03Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz03Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz03Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
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
                    Intent openQuizTwo = new Intent(QuizThree.this, QuizFour.class);
                    startActivity(openQuizTwo);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_03_ANSWER_A_CLICKABLE_KEY, quiz03Answer_A.isClickable());
        outState.putBoolean(QUIZ_03_ANSWER_B_CLICKABLE_KEY, quiz03Answer_B.isClickable());
        outState.putBoolean(QUIZ_03_ANSWER_C_CLICKABLE_KEY, quiz03Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz03Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz03Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz03Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        Intent openQuizOne = new Intent(this, QuizTwo.class);
        startActivity(openQuizOne);
    }

    public void quizThreeSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openQuizTwo = new Intent(QuizThree.this, QuizFour.class);
                startActivity(openQuizTwo);
            }
        });

        if (quizThreeAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_A.setBackgroundColor(Color.GREEN);
            quiz03Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_A.setBackgroundColor(Color.GREEN);
            quiz03Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizThree.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz03Answer_B.setBackgroundColor(Color.GREEN);
            quiz03Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizThreeAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizThree.this, "All of your answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            quiz03Answer_A.setBackgroundColor(Color.GREEN);
            quiz03Answer_B.setBackgroundColor(Color.GREEN);
            quiz03Answer_C.setBackgroundColor(Color.GREEN);
        } else if (quizThreeAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizThree.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
        }
    }

    public String quizThreeAnswerVariation(){
        if (quiz03Answer_A.isChecked() && !quiz03Answer_B.isChecked() && !quiz03Answer_C.isChecked()){
            return "a"; //There is three correct answers //1 point
        } else if (quiz03Answer_B.isChecked() && !quiz03Answer_A.isChecked() && !quiz03Answer_C.isChecked()){
            return "b"; //There is three correct answers //1 point
        } else if (quiz03Answer_C.isChecked() && !quiz03Answer_A.isChecked() && !quiz03Answer_B.isChecked()){
            return "c"; //There is three correct answers //1 point
        } else if (quiz03Answer_A.isChecked() && quiz03Answer_B.isChecked() && !quiz03Answer_C.isChecked()){
            return "ab"; //There is three correct answers //2 point
        } else if (quiz03Answer_A.isChecked() && quiz03Answer_C.isChecked() && !quiz03Answer_B.isChecked()){
            return "ac"; //There is three correct answers //2 point
        } else if (quiz03Answer_B.isChecked() && quiz03Answer_C.isChecked() && !quiz03Answer_A.isChecked()){
            return "bc"; //There is three correct answers //2 point
        } else if (quiz03Answer_A.isChecked() && quiz03Answer_B.isChecked() && quiz03Answer_C.isChecked()){
            return "abc"; //All of your answers are correct //3 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public void setAllCheckBoxNonClickable(){
        quiz03Answer_A.setClickable(false);
        quiz03Answer_B.setClickable(false);
        quiz03Answer_C.setClickable(false);
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
