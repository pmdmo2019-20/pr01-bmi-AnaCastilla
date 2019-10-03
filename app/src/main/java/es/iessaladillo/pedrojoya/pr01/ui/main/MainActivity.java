package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;

public class MainActivity extends AppCompatActivity {

    private Button resetButton, calculateButton;
    private EditText txtWeight, txtHeight;
    private TextView res;
    private ImageView photo;
    private BmiCalculator bc = new BmiCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupViews();
    }

    private void reset(){
        txtWeight.setText("");
        txtHeight.setText("");
        res.setText("");
        photo.setImageResource(R.drawable.bmi);
    }

    private void setImageAndText() {

        float bmi;
        if (isValidForm()) {
            bmi = bc.calculateBmi(Float.parseFloat(String.valueOf(txtWeight.getText())), Float.parseFloat(String.valueOf(txtHeight.getText())));

            switch (bc.getBmiClasification(bmi)) {
                case LOW_WEIGHT:
                    photo.setImageResource(R.drawable.underweight);
                    res.setText("BMI: " + bmi + " Underweight");
                case NORMAL_WEIGHT:
                    photo.setImageResource(R.drawable.normal_weight);
                    res.setText("BMI: " + bmi + " Normal weight");
                case OVERWWEIGHT:
                    photo.setImageResource(R.drawable.overweight);
                    res.setText("BMI: " + bmi + " Overweight");
                case OBESITY_GRADE_1:
                    photo.setImageResource(R.drawable.obesity1);
                    res.setText("BMI: " + bmi + " Obesity class 1");
                case OBESITY_GRADE_2:
                    photo.setImageResource(R.drawable.obesity2);
                    res.setText("BMI: " + bmi + " Obesity class 2");
                case OBESITY_GRADE_3:
                    photo.setImageResource(R.drawable.obesity3);
                    res.setText("BMI: " + bmi + " Obesity class 3");
            }
        }


    }

    private boolean isValidForm() {
        return isValidWeight() && isValidHeight();
    }

    private boolean isValidWeight() {
        boolean isValid = false;

        if (!TextUtils.isEmpty(txtWeight.getText().toString()) && !txtWeight.getText().toString().startsWith("0")) {
            isValid = true;
        } else {
            txtWeight.setError("Invalid weight.");
        }
        return isValid;
    }

    private boolean isValidHeight() {
        boolean isValid = false;

        if (!TextUtils.isEmpty(txtHeight.getText().toString()) && !txtHeight.getText().toString().startsWith("0")) {
            isValid = true;
        } else {
            txtHeight.setError("Invalid height.");
        }
        return isValid;
    }

    private void setupViews(){
        resetButton = ActivityCompat.requireViewById(this, R.id.btnReset);
        txtWeight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        txtHeight = ActivityCompat.requireViewById(this, R.id.txtHeight);
        res = ActivityCompat.requireViewById(this, R.id.lblResult);
        photo = ActivityCompat.requireViewById(this, R.id.imgBmi);
        calculateButton = ActivityCompat.requireViewById(this, R.id.btnCalculate);

        calculateButton.setOnClickListener(c -> setImageAndText());
        resetButton.setOnClickListener(r -> reset());
    }

}
