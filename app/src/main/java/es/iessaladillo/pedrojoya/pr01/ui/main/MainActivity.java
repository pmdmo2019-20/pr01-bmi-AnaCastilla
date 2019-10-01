package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;

public class MainActivity extends AppCompatActivity {

    private Button resetButton, calculateButton;
    private EditText weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupViews();
    }

    private void reset(){
        weight.setText("");
        height.setText("");
    }

    private void calculate(){

    }


    private void setupViews(){
        resetButton = ActivityCompat.requireViewById(this, R.id.btnReset);
        weight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        height = ActivityCompat.requireViewById(this, R.id.txtHeight);

        resetButton.setOnClickListener(r -> reset());
    }

}
