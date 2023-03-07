package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class StartActivity extends AppCompatActivity {

    private Button submit;
    private TextView number_participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Intent intent = new Intent(this, InputActivity.class);
        submit = findViewById(R.id.submit);
        number_participants = findViewById(R.id.participants);

        Vote[] votes = new Vote[10];

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer participants = Integer.parseInt(number_participants.getText().toString());
                intent.putExtra("participants", participants);
                intent.putExtra("votes_array", votes);
                startActivity(intent);
            }
        });
    }
}