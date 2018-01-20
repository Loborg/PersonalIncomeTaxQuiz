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

public class QuizFour extends AppCompatActivity {

    public static final String QUIZ_04_ANSWER_A_CLICKABLE_KEY = "quiz_04_answer_a_clickable_key";
    public static final String QUIZ_04_ANSWER_B_CLICKABLE_KEY = "quiz_04_answer_b_clickable_key";
    public static final String QUIZ_04_ANSWER_C_CLICKABLE_KEY = "quiz_04_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public CheckBox quiz04Answer_A;
    public CheckBox quiz04Answer_B;
    public CheckBox quiz04Answer_C;
    public ImageView nextIconImage;
    public int nextIconImageColor = Color.LTGRAY;
    public Button quizThreeSubmiteButton;
    public boolean isSubmiteButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_four);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz04Answer_A = findViewById(R.id.quiz_04_answer_a);
        quiz04Answer_B = findViewById(R.id.quiz_04_answer_b);
        quiz04Answer_C = findViewById(R.id.quiz_04_answer_c);
        quizThreeSubmiteButton = findViewById(R.id.quiz_four_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_A_CLICKABLE_KEY))
                quiz04Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_B_CLICKABLE_KEY))
                quiz04Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_04_ANSWER_C_CLICKABLE_KEY))
                quiz04Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz04Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz04Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz04Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
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
                    Intent openQuizTwo = new Intent(QuizFour.this, QuizFive.class);
                    startActivity(openQuizTwo);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_04_ANSWER_A_CLICKABLE_KEY, quiz04Answer_A.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_B_CLICKABLE_KEY, quiz04Answer_B.isClickable());
        outState.putBoolean(QUIZ_04_ANSWER_C_CLICKABLE_KEY, quiz04Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz04Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        Intent openQuizOne = new Intent(this, QuizThree.class);
        startActivity(openQuizOne);
    }

    public void quizFourSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openQuizTwo = new Intent(QuizFour.this, QuizFive.class);
                startActivity(openQuizTwo);
            }
        });

        if (quizFourAnswerVariation().equals("a")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("b")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("c")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("ab")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("ac")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("bc")){
            Toast answer_a = Toast.makeText(QuizFour.this, "There is three correct answers", Toast.LENGTH_SHORT);
            answer_a.show();
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
            setAllCheckBoxNonClickable();
        } else if (quizFourAnswerVariation().equals("abc")){
            Toast answer_a = Toast.makeText(QuizFour.this, "All of your answers are correct", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
            quiz04Answer_A.setBackgroundColor(Color.GREEN);
            quiz04Answer_B.setBackgroundColor(Color.GREEN);
            quiz04Answer_C.setBackgroundColor(Color.GREEN);
        } else if (quizFourAnswerVariation().equals("")){
            Toast answer_a = Toast.makeText(QuizFour.this, "You haven’t choose any of the answers", Toast.LENGTH_SHORT);
            answer_a.show();
            setAllCheckBoxNonClickable();
        }
    }

    public String quizFourAnswerVariation(){
        if (quiz04Answer_A.isChecked() && !quiz04Answer_B.isChecked() && !quiz04Answer_C.isChecked()){
            return "a"; //There is three correct answers //1 point
        } else if (quiz04Answer_B.isChecked() && !quiz04Answer_A.isChecked() && !quiz04Answer_C.isChecked()){
            return "b"; //There is three correct answers //1 point
        } else if (quiz04Answer_C.isChecked() && !quiz04Answer_A.isChecked() && !quiz04Answer_B.isChecked()){
            return "c"; //There is three correct answers //1 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_B.isChecked() && !quiz04Answer_C.isChecked()){
            return "ab"; //There is three correct answers //2 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_C.isChecked() && !quiz04Answer_B.isChecked()){
            return "ac"; //There is three correct answers //2 point
        } else if (quiz04Answer_B.isChecked() && quiz04Answer_C.isChecked() && !quiz04Answer_A.isChecked()){
            return "bc"; //There is three correct answers //2 point
        } else if (quiz04Answer_A.isChecked() && quiz04Answer_B.isChecked() && quiz04Answer_C.isChecked()){
            return "abc"; //All of your answers are correct //3 point
        }
        return ""; //You haven’t choose any of the answers //0 point
    }

    public void setAllCheckBoxNonClickable(){
        quiz04Answer_A.setClickable(false);
        quiz04Answer_B.setClickable(false);
        quiz04Answer_C.setClickable(false);
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
