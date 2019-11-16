package com.example.a99bugs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button oneDownButton;
    private Button twoDownButton;
    private TextView bugLabelTextView;
    // public static final String TAKE_DOWN_NUMBER = "takeDownNumber";
    public static final int REQUEST_1 = 1;
    public static final String BUGS_MESSAGE = "BUGS_MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneDownButton = findViewById(R.id.oneDownButton);
        twoDownButton = findViewById(R.id.twoDownButton);
        bugLabelTextView = findViewById(R.id.bugLabelTextView);

        oneDownButton.setOnClickListener(this);
        twoDownButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this, TheCode.class);


        switch (v.getId())
        {
            case R.id.oneDownButton:
                intent.putExtra("TAKE_DOWN_NUMBER", 1);
                startActivityForResult(intent, REQUEST_1);
                break;
            case R.id.twoDownButton:
                intent.putExtra("TAKE_DOWN_NUMBER", 2);
                startActivityForResult(intent, REQUEST_1);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        super.onActivityResult(requestCode, resultCode, returnIntent);

            bugLabelTextView.setText((returnIntent.getStringExtra("BUGS_MESSAGE")));


    }
}
