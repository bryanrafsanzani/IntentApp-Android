package org.bryanrafsanzani.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity, btnDataActivity, btnObjectActivity, btnDialNumberActivity, btnResultActivity;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = findViewById(R.id.btn_MoveActivity);
        btnDataActivity = findViewById(R.id.btn_DataActivity);
        btnObjectActivity = findViewById(R.id.btn_ObjectActivity);
        btnDialNumberActivity = findViewById(R.id.btn_DialNumberActivity);
        btnResultActivity = findViewById(R.id.btn_ResultActivity);
        tvResult = findViewById(R.id.txt_result);

        btnMoveActivity.setOnClickListener(this);
        btnDataActivity.setOnClickListener(this);
        btnObjectActivity.setOnClickListener(this);
        btnDialNumberActivity.setOnClickListener(this);
        btnResultActivity.setOnClickListener(this);

        Bundle resultIntent = getIntent().getExtras();
        if(resultIntent != null){
            String nameValue = resultIntent.getString("strRadio");
            tvResult.setText(nameValue);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_MoveActivity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_DataActivity:
                Intent dataIntent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(dataIntent);
                break;
            case R.id.btn_ObjectActivity:
                Intent objectIntent = new Intent(MainActivity.this, ObjectActivity.class);
                startActivity(objectIntent);
                break;
            case R.id.btn_DialNumberActivity:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "087775211019", null));
                startActivity(dialIntent);
                break;
            case R.id.btn_ResultActivity:
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(resultIntent);
                break;
        }
    }
}
