package com.example.a99bugs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheCode extends AppCompatActivity implements View.OnClickListener
{
    private Button patchButton;
    String bugsMessage;
    int takeDownNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_main);

        patchButton = (Button) findViewById(R.id.patchButton);
        patchButton.setOnClickListener(this);
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        // Get the game state sent from the main activity
        Intent intent = getIntent();
        takeDownNumber = intent.getIntExtra("TAKE_DOWN_NUMBER", 0);
    }
    @Override
    public void onClick(View v)
    {
        bugsMessage = "";
        Intent returnIntent = new Intent(this, MainActivity.class);
        returnIntent.putExtra(MainActivity.BUGS_MESSAGE, bugsMessage);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
