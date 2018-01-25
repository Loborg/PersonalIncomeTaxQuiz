package com.example.android.personalincometaxquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Evaluation extends AppCompatActivity {

    public int pointCounter = 0;
    public static String userName;
    public static String emailAdress;
    public static String[] quizAnswers = new String[10];
    private static final String zeroPoint = "0";
    private static final String onePoint = "1";
    private static final String twoPoint = "2";
    private static final String threePoint = "3";
    public int red = Color.RED;
    public int green = Color.GREEN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        evaluateQuizOne();
    }

    public void evaluateQuizOne(){
        TextView pointsForQuiz01 = findViewById(R.id.points_for_quiz01);
        TextView q1_a = findViewById(R.id.q1_a);
        TextView q1_b = findViewById(R.id.q1_b);
        TextView q1_c = findViewById(R.id.q1_c);
        switch (quizAnswers[0]) {
            case "a":
                q1_a.setBackgroundColor(red);
                pointsForQuiz01.setText(zeroPoint);
                break;
            case "b":
                q1_b.setBackgroundColor(green);
                pointsForQuiz01.setText(twoPoint);
                pointCounter = pointCounter + 2;
                break;
            case "c":
                q1_c.setBackgroundColor(green);
                pointsForQuiz01.setText(twoPoint);
                pointCounter = pointCounter + 2;
                break;
            case "ab":
                q1_a.setBackgroundColor(red);
                q1_b.setBackgroundColor(green);
                pointsForQuiz01.setText(twoPoint);
                pointCounter = pointCounter + 2;
                break;
            case "ac":
                q1_a.setBackgroundColor(red);
                q1_c.setBackgroundColor(green);
                pointsForQuiz01.setText(twoPoint);
                pointCounter = pointCounter + 2;
                break;
            case "bc":
                q1_b.setBackgroundColor(green);
                q1_c.setBackgroundColor(green);
                pointsForQuiz01.setText(threePoint);
                pointCounter = pointCounter + 3;
                break;
            case "abc":
                q1_a.setBackgroundColor(red);
                q1_b.setBackgroundColor(green);
                q1_c.setBackgroundColor(green);
                pointsForQuiz01.setText(onePoint);
                pointCounter = pointCounter + 1;
                break;
            case "":
        }
    }
}
