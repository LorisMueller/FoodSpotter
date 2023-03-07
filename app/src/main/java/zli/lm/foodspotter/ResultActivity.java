package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button home;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.backHome);
        Intent intent = new Intent(this, MainActivity.class);

        test = findViewById(R.id.arraytest);
        Intent lastIntent = getIntent();
        Vote[] votes = (Vote[]) lastIntent.getSerializableExtra("votes_array");
        double score = votes[0].getScore();
        String fav = votes[0].getFavourite();
        test.setText(fav);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("object", "aaaaaaaaaaaaaaaaaa: " + votes.toString());
                startActivity(intent);
            }
        });
    }
}