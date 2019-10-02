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
    }

    private void calculateBmi(){
        String weight = txtWeight.getText().toString();
        String height = txtHeight.getText().toString();
        float bmiCalculated;

        if (isValidForm(weight, height)) {
           bmiCalculated = BmiCalculator.calculateBmi(Float.parseFloat(weight), Float.parseFloat(height));
           setImageAndText(bmiCalculated);
        }
    }

    private void setImageAndText(float bmiCalculated) {
        BmiCalculator.BmiClasification clasif = BmiCalculator.getBmiClasification(bmiCalculated);

        if (clasif.equals(BmiCalculator.BmiClasification.LOW_WEIGHT)) {
            photo.setImageResource(R.drawable.underweight);
            res.setText("BMI: " + bmiCalculated + " Underweight");
        } else if (clasif.equals(BmiCalculator.BmiClasification.NORMAL_WEIGHT)) {
            photo.setImageResource(R.drawable.normal_weight);
            res.setText("BMI: " + bmiCalculated + " Normal weight");
        } else if (clasif.equals(BmiCalculator.BmiClasification.OVERWWEIGHT)) {
            photo.setImageResource(R.drawable.overweight);
            res.setText("BMI: " + bmiCalculated + " Overweight");
        } else if (clasif.equals(BmiCalculator.BmiClasification.OBESITY_GRADE_1)) {
            photo.setImageResource(R.drawable.obesity1);
            res.setText("BMI: " + bmiCalculated + " Obesity class 1");
        } else if (clasif.equals(BmiCalculator.BmiClasification.OBESITY_GRADE_2)) {
            photo.setImageResource(R.drawable.obesity2);
            res.setText("BMI: " + bmiCalculated + " Obesity class 2");
        } else if (clasif.equals(BmiCalculator.BmiClasification.OBESITY_GRADE_3)) {
            photo.setImageResource(R.drawable.obesity3);
            res.setText("BMI: " + bmiCalculated + " Obesity class 3");
        }
    }

    private boolean isValidForm(String weight, String height) {
        return isValidWeight(weight) && isValidHeight(height);
    }

    private boolean isValidWeight(String weight) {
        boolean isValid = false;

        if (!TextUtils.isEmpty(weight)) {
            isValid = true;
        } else if (!weight.equals(0)) {
            isValid = true;
        } else {
            txtWeight.setError("Invalid weight.");
        }
        return isValid;
    }

    private boolean isValidHeight(String height) {
        boolean isValid = false;

        if (!TextUtils.isEmpty(height)) {
            isValid = true;
        } else if (!height.equals(0)) {
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

        calculateButton.setOnClickListener(c -> calculateBmi());
        resetButton.setOnClickListener(r -> reset());
    }

}
