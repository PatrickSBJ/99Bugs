package com.example.a99bugs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button oneDownButton;
    private Button twoDownButton;
    // public static final String TAKE_DOWN_NUMBER = "takeDownNumber";
    public static final int REQUEST_1 = 1;
    public static final String BUGS_MESSAGE = "BUGS_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneDownButton = (Button) findViewById(R.id.oneDownButton);
        twoDownButton = (Button) findViewById(R.id.twoDownButton);
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
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
