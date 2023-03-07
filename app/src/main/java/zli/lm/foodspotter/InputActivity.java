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
    private String f_restaurant;
    private String l_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        submit_restaurants = findViewById(R.id.shaking);
        Intent intent = new Intent(this, ShackingActivity.class);

        Intent lastIntent = getIntent();
        int participants = lastIntent.getIntExtra("participants", 0);
        Vote[] votes = (Vote[]) intent.getSerializableExtra("votes_array");

        f_restaurant = findViewById(R.id.f_restaurant).toString();
        l_restaurant = findViewById(R.id.l_restaurant).toString();

        submit_restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    intent.putExtra("participants", participants);
                    intent.putExtra("votes_array", votes);
                    intent.putExtra("f_restaurant", f_restaurant);
                    intent.putExtra("l_restaurant", l_restaurant);
                    startActivity(intent);
            }
        });
    }
}