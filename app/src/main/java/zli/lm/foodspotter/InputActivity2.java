package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InputActivity2 extends AppCompatActivity {

    private Button submit_restaurants;
    private TextView f_restaurant;
    private TextView l_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input2);

        submit_restaurants = findViewById(R.id.shaking);
        Intent intent = new Intent(this, ShackingActivity2.class);

        Intent lastIntent = getIntent();
        int participants = lastIntent.getIntExtra("participants", 0);
        String voteString = lastIntent.getStringExtra("votes_string");

        f_restaurant = findViewById(R.id.f_restaurant);
        l_restaurant = findViewById(R.id.l_restaurant);

        submit_restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String favourite = f_restaurant.getText().toString();
                String least_favourite = l_restaurant.getText().toString();

                intent.putExtra("participants", participants);
                intent.putExtra("fa_restaurant", favourite);
                intent.putExtra("le_restaurant", least_favourite);
                intent.putExtra("votes_string", voteString);
                startActivity(intent);
            }
        });
    }
}