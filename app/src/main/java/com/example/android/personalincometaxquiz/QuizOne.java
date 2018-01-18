package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class QuizOne extends AppCompatActivity {

    public CheckBox quiz01Answer_A;
    public CheckBox quiz01Answer_B;
    public CheckBox quiz01Answer_C;
    public ImageView nextIconImage;
    int colorA;
    int colorB;
    int colorC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_one);

        quiz01Answer_A = findViewById(R.id.quiz_01_answer_a);
        quiz01Answer_B = findViewById(R.id.quiz_01_answer_b);
        quiz01Answer_C = findViewById(R.id.quiz_01_answer_c);
        nextIconImage = findViewById(R.id.next_image_01);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        Intent openMainPage = new Intent(this, MainActivity.class);
        startActivity(openMainPage);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("quiz_01_answer_a_clickable_key", quiz01Answer_A.isClickable());
        outState.putBoolean("quiz_01_answer_b_clickable_key", quiz01Answer_B.isClickable());
        outState.putBoolean("quiz_01_answer_c_clickable_key", quiz01Answer_C.isClickable());


        Drawable bgAnswerA = quiz01Answer_A.getBackground().mutate();
        if (bgAnswerA instanceof ColorDrawable) {
            colorA = ((ColorDrawable) quiz01Answer_A.getBackground()).getColor();
        }


        Drawable bgAnswerB = quiz01Answer_B.getBackground().mutate();
        if (bgAnswerB instanceof ColorDrawable) {
            colorB = ((ColorDrawable) quiz01Answer_B.getBackground()).getColor();
        }


        Drawable bgAnswerC = quiz01Answer_C.getBackground().mutate();
        if (bgAnswerC instanceof ColorDrawable) {
            colorC = ((ColorDrawable) quiz01Answer_C.getBackground()).getColor();
        }

        outState.putInt("quiz_aswer_a_bg_color_key", colorA);
        outState.putInt("quiz_aswer_b_bg_color_key", colorB);
        outState.putInt("quiz_aswer_c_bg_color_key", colorC);

        outState.putInt("next_icon_color_key", nextIconImage.getColorFilter().hashCode());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
            quiz01Answer_A.setClickable(savedInstanceState.getBoolean("quiz_01_answer_a_clickable_key"));
            quiz01Answer_B.setClickable(savedInstanceState.getBoolean("quiz_01_answer_b_clickable_key"));
            quiz01Answer_C.setClickable(savedInstanceState.getBoolean("quiz_01_answer_c_clickable_key"));

            quiz01Answer_A.setBackgroundColor(savedInstanceState.getInt("quiz_aswer_a_bg_color_key"));
            quiz01Answer_B.setBackgroundColor(savedInstanceState.getInt("quiz_aswer_b_bg_color_key"));
            quiz01Answer_C.setBackgroundColor(savedInstanceState.getInt("quiz_aswer_c_bg_color_key"));

            nextIconImage.setColorFilter(savedInstanceState.getInt("next_icon_color_key"));

    }

    public void quizOneSubmiteButtonClick(View v){
        nextIconImage.setColorFilter(Color.BLACK);
        nextIconImage.setOnClickListener(new View.OnClickListener(){
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
        if (quiz01Answer_A.isChecked() && quiz01Answer_B.isChecked() == false && quiz01Answer_C.isChecked() == false){
            return "a"; //Your answer is incorrect //0 point
        } else if (quiz01Answer_B.isChecked() && quiz01Answer_A.isChecked() == false && quiz01Answer_C.isChecked() == false){
            return "b"; //There is one more correct answer //2 point
        } else if (quiz01Answer_C.isChecked() && quiz01Answer_A.isChecked() == false && quiz01Answer_B.isChecked() == false){
            return "c"; //There is one more correct answer //2 point
        } else if (quiz01Answer_A.isChecked() && quiz01Answer_B.isChecked() && quiz01Answer_C.isChecked() == false){
            return "ab"; //Only one of your answers is correct //2 point
        } else if (quiz01Answer_A.isChecked() && quiz01Answer_C.isChecked() && quiz01Answer_B.isChecked() == false){
            return "ac"; //Only one of your answers is correct //2 point
        } else if (quiz01Answer_B.isChecked() && quiz01Answer_C.isChecked() && quiz01Answer_A.isChecked() == false){
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
}
