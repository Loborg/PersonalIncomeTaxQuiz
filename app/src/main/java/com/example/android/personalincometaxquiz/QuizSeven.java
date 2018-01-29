package com.example.android.personalincometaxquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizSeven extends AppCompatActivity {

    public static final String QUIZ_07_ANSWER_A_CLICKABLE_KEY = "quiz_04_answer_a_clickable_key";
    public static final String QUIZ_07_ANSWER_B_CLICKABLE_KEY = "quiz_04_answer_b_clickable_key";
    public static final String QUIZ_07_ANSWER_C_CLICKABLE_KEY = "quiz_04_answer_c_clickable_key";
    public static final String QUIZ_ASWER_A_BG_COLOR_KEY = "quiz_aswer_a_bg_color_key";
    public static final String QUIZ_ASWER_B_BG_COLOR_KEY = "quiz_aswer_b_bg_color_key";
    public static final String QUIZ_ASWER_C_BG_COLOR_KEY = "quiz_aswer_c_bg_color_key";
    public static final String SUBMITE_BUTTON_STATUS_KEY = "submite_button_status_key";
    public static final String NEXT_ICON_IMAGE_COLOR_KEY = "next_icon_image_color_key";
    public RadioButton quiz07Answer_A;
    public RadioButton quiz07Answer_B;
    public RadioButton quiz07Answer_C;
    public ImageView nextIconImage;
    public static int nextIconImageColor = Color.LTGRAY;
    public Button quizSevenSubmiteButton;
    public static boolean isSubmiteButtonClicked;

    private static boolean quiz07Answer_a_isClickable = true;
    private static boolean quiz07Answer_b_isClickable = true;
    private static boolean quiz07Answer_c_isClickable = true;
    private static boolean quiz07Answer_a_isChecked;
    private static boolean quiz07Answer_b_isChecked;
    private static boolean quiz07Answer_c_isChecked;
    private static int quiz07Answer_a_bg_color;
    private static int quiz07Answer_b_bg_color;
    private static int quiz07Answer_c_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_seven);

        nextIconImage = findViewById(R.id.next_image_01);
        quiz07Answer_A = findViewById(R.id.quiz_07_answer_a);
        quiz07Answer_B = findViewById(R.id.quiz_07_answer_b);
        quiz07Answer_C = findViewById(R.id.quiz_07_answer_c);
        quizSevenSubmiteButton = findViewById(R.id.quiz_seven_submite_button);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(QUIZ_07_ANSWER_A_CLICKABLE_KEY))
                quiz07Answer_A.setClickable(savedInstanceState.getBoolean(QUIZ_07_ANSWER_A_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_07_ANSWER_B_CLICKABLE_KEY))
                quiz07Answer_B.setClickable(savedInstanceState.getBoolean(QUIZ_07_ANSWER_B_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_07_ANSWER_C_CLICKABLE_KEY))
                quiz07Answer_C.setClickable(savedInstanceState.getBoolean(QUIZ_07_ANSWER_C_CLICKABLE_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_A_BG_COLOR_KEY))
                quiz07Answer_A.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_A_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_B_BG_COLOR_KEY))
                quiz07Answer_B.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_B_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(QUIZ_ASWER_C_BG_COLOR_KEY))
                quiz07Answer_C.setBackgroundColor(savedInstanceState.getInt(QUIZ_ASWER_C_BG_COLOR_KEY));
            if (savedInstanceState.containsKey(SUBMITE_BUTTON_STATUS_KEY))
                isSubmiteButtonClicked = savedInstanceState.getBoolean(SUBMITE_BUTTON_STATUS_KEY);
            if (savedInstanceState.containsKey(NEXT_ICON_IMAGE_COLOR_KEY))
                nextIconImageColor = savedInstanceState.getInt(NEXT_ICON_IMAGE_COLOR_KEY);
        }

        nextIconImage.setColorFilter(nextIconImageColor);
        nextIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubmiteButtonClicked) {
                    openQ8Activity();
                } else {
                    Toast submiteButtonNotClicked = Toast.makeText(QuizSeven.this, R.string.next_no_submite, Toast.LENGTH_SHORT);
                    submiteButtonNotClicked.show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(QUIZ_07_ANSWER_A_CLICKABLE_KEY, quiz07Answer_A.isClickable());
        outState.putBoolean(QUIZ_07_ANSWER_B_CLICKABLE_KEY, quiz07Answer_B.isClickable());
        outState.putBoolean(QUIZ_07_ANSWER_C_CLICKABLE_KEY, quiz07Answer_C.isClickable());
        outState.putInt(QUIZ_ASWER_A_BG_COLOR_KEY, getQuizAnswrBGColor(quiz07Answer_A));
        outState.putInt(QUIZ_ASWER_B_BG_COLOR_KEY, getQuizAnswrBGColor(quiz07Answer_B));
        outState.putInt(QUIZ_ASWER_C_BG_COLOR_KEY, getQuizAnswrBGColor(quiz07Answer_C));
        outState.putBoolean(SUBMITE_BUTTON_STATUS_KEY, isSubmiteButtonClicked);
        outState.putInt(NEXT_ICON_IMAGE_COLOR_KEY, nextIconImageColor);

        saveViewStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        quiz07Answer_A.setClickable(quiz07Answer_a_isClickable);
        quiz07Answer_B.setClickable(quiz07Answer_b_isClickable);
        quiz07Answer_C.setClickable(quiz07Answer_c_isClickable);

        quiz07Answer_A.setChecked(quiz07Answer_a_isChecked);
        quiz07Answer_B.setChecked(quiz07Answer_b_isChecked);
        quiz07Answer_C.setChecked(quiz07Answer_c_isChecked);

        quiz07Answer_A.setBackgroundColor(quiz07Answer_a_bg_color);
        quiz07Answer_B.setBackgroundColor(quiz07Answer_b_bg_color);
        quiz07Answer_C.setBackgroundColor(quiz07Answer_c_bg_color);

        nextIconImage.setColorFilter(nextIconImageColor);
    }

    @Override
    public void onBackPressed() {
    }

    public void beckIconClick(View v){
        openQ6Activity();
    }

    public void quizSevenSubmiteButtonClick(View v){
        isSubmiteButtonClicked = true;
        nextIconImageColor = Color.BLACK;
        nextIconImage.setColorFilter(nextIconImageColor);

        if (quizSevenCorrectAnswer().equals("a")){
            Toast answer_a = Toast.makeText(QuizSeven.this, R.string.submite_incorrect, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz07Answer_A.setBackgroundColor(Color.RED);
            setAllRadioButtonNonClickable();
            Evaluation.quizAnswers[6] = quizSevenCorrectAnswer();
        } else if (quizSevenCorrectAnswer().equals("b")){
            Toast answer_a = Toast.makeText(QuizSeven.this, R.string.submite_incorrect, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz07Answer_B.setBackgroundColor(Color.RED);
            setAllRadioButtonNonClickable();
            Evaluation.quizAnswers[6] = quizSevenCorrectAnswer();
        } else if (quizSevenCorrectAnswer().equals("c")){
            Toast answer_a = Toast.makeText(QuizSeven.this, R.string.submite_correct, Toast.LENGTH_SHORT);
            answer_a.show();
            quiz07Answer_C.setBackgroundColor(Color.GREEN);
            setAllRadioButtonNonClickable();
            Evaluation.quizAnswers[6] = quizSevenCorrectAnswer();
        } else if (quizSevenCorrectAnswer().equals("")){
            Toast answer_a = Toast.makeText(QuizSeven.this, R.string.submite_no_answer, Toast.LENGTH_SHORT);
            answer_a.show();
            setAllRadioButtonNonClickable();
            Evaluation.quizAnswers[6] = quizSevenCorrectAnswer();
        }
    }

    public String quizSevenCorrectAnswer(){
        if (quiz07Answer_A.isChecked()){
            return "a"; //Your answer is incorrect //0 point
        }

        if (quiz07Answer_B.isChecked()){
            return "b"; //Your answer is incorrect //0 point
        }

        if (quiz07Answer_C.isChecked()){
            return "c";  //Your answer is correct //3 point
        }
        return "";
    }

    public static void evaluateQuizSeven(String[] quizAnswers,
                                        TextView pointsForQuizTextView,
                                        TextView quizAnswer_a,
                                        TextView quizAnswer_b,
                                        TextView quizAnswer_c,
                                        int pointCounter,
                                        int red,
                                        int gray,
                                        int green,
                                        String zeroPoint,
                                        String threePoint)
    {
        switch (quizAnswers[6]) {
            case "a":
                setBeckgroundColor(quizAnswer_a, red);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(zeroPoint);
                break;
            case "b":
                setBeckgroundColor(quizAnswer_b, red);
                setBeckgroundColor(quizAnswer_c, gray);
                pointsForQuizTextView.setText(zeroPoint);

                break;
            case "c":
                setBeckgroundColor(quizAnswer_c, green);
                pointsForQuizTextView.setText(threePoint);
                Evaluation.pointCounter = pointCounter + 3;
                break;
            default:
                pointsForQuizTextView.setText(zeroPoint);
                break;
        }
    }

    public static void setBeckgroundColor(View quizTextView, int textViewBgColor){
        quizTextView.setBackgroundColor(textViewBgColor);
    }

    public void setAllRadioButtonNonClickable(){
        quiz07Answer_A.setClickable(false);
        quiz07Answer_B.setClickable(false);
        quiz07Answer_C.setClickable(false);
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

    public void openQ8Activity(){
        saveViewStatus();
        Intent openQuizEight = new Intent(QuizSeven.this, QuizEight.class);
        startActivity(openQuizEight);
    }

    public void openQ6Activity(){
        Intent openQ6 = new Intent(this, QuizSix.class);
        startActivity(openQ6);
    }

    public void saveViewStatus(){
        quiz07Answer_a_isClickable = quiz07Answer_A.isClickable();
        quiz07Answer_b_isClickable = quiz07Answer_B.isClickable();
        quiz07Answer_c_isClickable = quiz07Answer_C.isClickable();

        quiz07Answer_a_isChecked = quiz07Answer_A.isChecked();
        quiz07Answer_b_isChecked = quiz07Answer_B.isChecked();
        quiz07Answer_c_isChecked = quiz07Answer_C.isChecked();

        quiz07Answer_a_bg_color = getQuizAnswrBGColor(quiz07Answer_A);
        quiz07Answer_b_bg_color = getQuizAnswrBGColor(quiz07Answer_B);
        quiz07Answer_c_bg_color = getQuizAnswrBGColor(quiz07Answer_C);
    }
}
