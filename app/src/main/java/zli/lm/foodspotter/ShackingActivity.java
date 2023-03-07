package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShackingActivity extends AppCompatActivity {

    private Button nextPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shacking);

        nextPerson = findViewById(R.id.next);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        Intent inputIntent = new Intent(this, InputActivity.class);

        Intent lastIntent = getIntent();
        int participants = lastIntent.getIntExtra("participants", 0);

        if(participants == 1) {
            nextPerson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(resultIntent);
                }
            });
        } else {
            int updatedParticipants = participants - 1;
            nextPerson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputIntent.putExtra("participants", updatedParticipants);
                    startActivity(inputIntent);
                }
            });
        }

    }
}