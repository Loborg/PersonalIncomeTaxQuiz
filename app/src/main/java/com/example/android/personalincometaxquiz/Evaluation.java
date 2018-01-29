package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class Evaluation extends AppCompatActivity {

    public static final String POINT_COUNTER_KEY = "point_counter_key";
    public static int pointCounter = 0;
    public static String userName;
    public static String emailAdress;
    public static String[] quizAnswers = new String[10];
    private static final String zeroPoint = "0";
    private static final String onePoint = "1";
    private static final String twoPoint = "2";
    private static final String threePoint = "3";
    public int red = Color.RED;
    public int green = Color.GREEN;
    public int gray = Color.LTGRAY;
    TextView[] pointsForQuiz = new TextView[10];
    TextView[] quizAnswer_a = new TextView[10];
    TextView[] quizAnswer_b = new TextView[10];
    TextView[] quizAnswer_c = new TextView[10];
    TextView quizTextAnswer;
    public String evaluationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        quizTextAnswer = findViewById(R.id.q3_text_answer);
        evaluationMessage = getResources().getString(R.string.evaluate_message_start_string) + "\n\n"
                + getResources().getString(R.string.quiz_question_01) + "\n"
                + quizAnswers[0] + "\n\n"
                + getResources().getString(R.string.quiz_question_02) + "\n"
                + quizAnswers[1] + "\n\n"
                + getResources().getString(R.string.quiz_question_03) + "\n"
                + quizAnswers[2] + "\n\n"
                + getResources().getString(R.string.quiz_question_04) + "\n"
                + quizAnswers[3] + "\n\n"
                + getResources().getString(R.string.quiz_question_05) + "\n"
                + quizAnswers[4] + "\n\n"
                + getResources().getString(R.string.quiz_question_06) + "\n"
                + quizAnswers[5] + "\n\n"
                + getResources().getString(R.string.quiz_question_07) + "\n"
                + quizAnswers[6] + "\n\n"
                + getResources().getString(R.string.quiz_question_08) + "\n"
                + quizAnswers[7] + "\n\n"
                + getResources().getString(R.string.quiz_question_09) + "\n"
                + quizAnswers[8] + "\n\n"
                + getResources().getString(R.string.quiz_question_10) + "\n"
                + quizAnswers[9] + "\n\n";

        pointsForQuiz[0] = findViewById(R.id.points_for_quiz01);
        pointsForQuiz[1] = findViewById(R.id.points_for_quiz02);
        pointsForQuiz[2] = findViewById(R.id.points_for_quiz03);
        pointsForQuiz[3] = findViewById(R.id.points_for_quiz04);
        pointsForQuiz[4] = findViewById(R.id.points_for_quiz05);
        pointsForQuiz[5] = findViewById(R.id.points_for_quiz06);
        pointsForQuiz[6] = findViewById(R.id.points_for_quiz07);
        pointsForQuiz[7] = findViewById(R.id.points_for_quiz08);
        pointsForQuiz[8] = findViewById(R.id.points_for_quiz09);
        pointsForQuiz[9] = findViewById(R.id.points_for_quiz10);

        quizAnswer_a[0] = findViewById(R.id.q1_a);
        quizAnswer_a[1] = findViewById(R.id.q2_a);
        quizAnswer_a[3] = findViewById(R.id.q4_a);
        quizAnswer_a[4] = findViewById(R.id.q5_a);
        quizAnswer_a[5] = findViewById(R.id.q6_a);
        quizAnswer_a[6] = findViewById(R.id.q7_a);
        quizAnswer_a[7] = findViewById(R.id.q8_a);
        quizAnswer_a[8] = findViewById(R.id.q9_a);
        quizAnswer_a[9] = findViewById(R.id.q10_a);

        quizAnswer_b[0] = findViewById(R.id.q1_b);
        quizAnswer_b[1] = findViewById(R.id.q2_b);
        quizAnswer_b[3] = findViewById(R.id.q4_b);
        quizAnswer_b[4] = findViewById(R.id.q5_b);
        quizAnswer_b[5] = findViewById(R.id.q6_b);
        quizAnswer_b[6] = findViewById(R.id.q7_b);
        quizAnswer_b[7] = findViewById(R.id.q8_b);
        quizAnswer_b[8] = findViewById(R.id.q9_b);
        quizAnswer_b[9] = findViewById(R.id.q10_b);

        quizAnswer_c[0] = findViewById(R.id.q1_c);
        quizAnswer_c[1] = findViewById(R.id.q2_c);
        quizAnswer_c[3] = findViewById(R.id.q4_c);
        quizAnswer_c[4] = findViewById(R.id.q5_c);
        quizAnswer_c[5] = findViewById(R.id.q6_c);
        quizAnswer_c[6] = findViewById(R.id.q7_c);
        quizAnswer_c[7] = findViewById(R.id.q8_c);
        quizAnswer_c[8] = findViewById(R.id.q9_c);
        quizAnswer_c[9] = findViewById(R.id.q10_c);

        QuizOne.evaluateQuizOne(
                quizAnswers,
                pointsForQuiz[0],
                quizAnswer_a[0],
                quizAnswer_b[0],
                quizAnswer_c[0],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                onePoint,
                twoPoint,
                threePoint
        );

        QuizTwo.evaluateQuizTwo(
                quizAnswers,
                pointsForQuiz[1],
                quizAnswer_a[1],
                quizAnswer_b[1],
                quizAnswer_c[1],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                onePoint,
                twoPoint,
                threePoint
        );

        QuizThree.evaluateQuizThree(
                quizAnswers,
                pointsForQuiz[2],
                quizTextAnswer,
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                threePoint
        );

        QuizFour.evaluateQuizFour(
                quizAnswers,
                pointsForQuiz[3],
                quizAnswer_a[3],
                quizAnswer_b[3],
                quizAnswer_c[3],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                onePoint,
                twoPoint,
                threePoint
        );

        QuizFive.evaluateQuizFive(
                quizAnswers,
                pointsForQuiz[4],
                quizAnswer_a[4],
                quizAnswer_b[4],
                quizAnswer_c[4],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                threePoint
        );

        QuizSix.evaluateQuizSix(
                quizAnswers,
                pointsForQuiz[5],
                quizAnswer_a[5],
                quizAnswer_b[5],
                quizAnswer_c[5],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                onePoint,
                twoPoint,
                threePoint
        );

        QuizSeven.evaluateQuizSeven(
                quizAnswers,
                pointsForQuiz[6],
                quizAnswer_a[6],
                quizAnswer_b[6],
                quizAnswer_c[6],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                threePoint
        );

        QuizEight.evaluateQuizEight(
                quizAnswers,
                pointsForQuiz[7],
                quizAnswer_a[7],
                quizAnswer_b[7],
                quizAnswer_c[7],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                threePoint
        );

        QuizNine.evaluateQuizNine(
                quizAnswers,
                pointsForQuiz[8],
                quizAnswer_a[8],
                quizAnswer_b[8],
                quizAnswer_c[8],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                threePoint
        );

        QuizTen.evaluateQuizTen(
                quizAnswers,
                pointsForQuiz[9],
                quizAnswer_a[9],
                quizAnswer_b[9],
                quizAnswer_c[9],
                pointCounter,
                red,
                gray,
                green,
                zeroPoint,
                onePoint,
                twoPoint,
                threePoint
        );

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(POINT_COUNTER_KEY))
                pointCounter = savedInstanceState.getInt(POINT_COUNTER_KEY);
        }

        TextView finealScore = findViewById(R.id.final_score);
        finealScore.setText(String.valueOf(pointCounter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POINT_COUNTER_KEY, pointCounter);
    }

    @Override
    public void onBackPressed() {
    }

    public void sendButtonClick(View v){
        String title = getText(R.string.mail_title).toString();
        String mailto = "mailto:" + emailAdress;
        Intent openEmailApp = new Intent(Intent.ACTION_SENDTO);
        openEmailApp.setType("plain/text");
        openEmailApp.setData(Uri.parse(mailto));
        openEmailApp.putExtra(Intent.EXTRA_SUBJECT, userName + title);
        openEmailApp.putExtra(Intent.EXTRA_TEXT, evaluationMessage);
        startActivity(openEmailApp);
    }

    public void restartButtonClick(View v){
        Intent restartApp = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        restartApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(restartApp);
        System.exit(0);
    }
}
