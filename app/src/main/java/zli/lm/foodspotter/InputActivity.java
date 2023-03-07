package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    private Button submit_restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        submit_restaurants = findViewById(R.id.shaking);
        Intent intent = new Intent(this, ShackingActivity.class);

        Intent lastIntent = getIntent();
        int participants = lastIntent.getIntExtra("participants", 0);

        submit_restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("participants", participants);
                startActivity(intent);
            }
        });
    }
}