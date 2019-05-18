package org.bryanrafsanzani.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity  implements View.OnClickListener {
    RadioButton radioButton;
    Button btnPilih;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        btnPilih = findViewById(R.id.btn_pilih);
        btnPilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        switch (view.getId()){
            case R.id.btn_pilih:
                Intent resultIntent = new Intent(ResultActivity.this, MainActivity.class);
                resultIntent.putExtra("strRadio", radioButton.getText()); // pass "str" to the next Activity
                startActivity(resultIntent);
                break;
        }
    }
}
