package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {

    private Button home;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator.hasVibrator()) {
            vibrator.vibrate(500);
        }

        home = findViewById(R.id.backHome);
        Intent intent = new Intent(this, MainActivity.class);

        test = findViewById(R.id.arraytest);
        Intent lastIntent = getIntent();
        String voteString = lastIntent.getStringExtra("votes_string");
        //test.setText(Arrays.toString(votes));
        test.setText(voteString);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}