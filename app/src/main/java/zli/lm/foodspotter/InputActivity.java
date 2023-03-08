package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class InputActivity extends AppCompatActivity {

    private Button submit_restaurants;
    private TextView f_restaurant;
    private TextView l_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        submit_restaurants = findViewById(R.id.shaking);
        Intent intent = new Intent(this, ShackingActivity.class);

        Intent lastIntent = getIntent();
        int participants = lastIntent.getIntExtra("participants", 0);
        //Vote[] votes = (Vote[]) intent.getSerializableExtra("votes_array");
        String voteString = intent.getStringExtra("votes_string");

        f_restaurant = findViewById(R.id.f_restaurant);
        l_restaurant = findViewById(R.id.l_restaurant);

        submit_restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String favourite = f_restaurant.getText().toString();
                String least_favourite = l_restaurant.getText().toString();

                intent.putExtra("participants", participants);
                //intent.putExtra("votes_array", votes);
                intent.putExtra("votes_string", voteString);
                intent.putExtra("f_restaurant", favourite);
                intent.putExtra("l_restaurant", least_favourite);
                startActivity(intent);
            }
        });
    }
}