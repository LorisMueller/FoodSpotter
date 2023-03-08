package zli.lm.foodspotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class ShackingActivity extends AppCompatActivity implements SensorEventListener {

    private Button nextPerson;
    private String f_restaurant;
    private String l_restaurant;
    private int participants;
    private Vote[] votes;
    private String voteString;

    //Variables for sensor and score
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float acceleration;
    private float currentAcceleration;
    private float previousAcceleration;
    private long shakeTimeStamp;
    private static final int SHAKE_THRESHOLD = 20;
    private static final int SHAKE_TIMEOUT = 5000;
    private double highestScore;
    private long startTime;
    private boolean shakeDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shacking);

        //Sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        shakeDetected = false;
        startTime = 0;
        highestScore = 0;

        //Input Data
        nextPerson = findViewById(R.id.next);
        nextPerson.setEnabled(false);
        Intent input2Intent = new Intent(this, InputActivity2.class);

        Intent lastIntent = getIntent();
        participants = lastIntent.getIntExtra("participants", 0);

        if (votes == null){
            votes = new Vote[participants];
        }
        f_restaurant = lastIntent.getStringExtra("f_restaurant");
        l_restaurant = lastIntent.getStringExtra("l_restaurant");
        nextPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vote vote = new Vote(f_restaurant, l_restaurant, highestScore);
                String voteStrings = vote.toString() + '$';

                    int updatedParticipants = participants -1;
                    input2Intent.putExtra("votes_string", voteStrings);
                    input2Intent.putExtra("participants", updatedParticipants);
                    startActivity(input2Intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        previousAcceleration = currentAcceleration;
        currentAcceleration = (float) Math.sqrt((double) (x*x + y*y + z*z));
        acceleration = currentAcceleration - previousAcceleration;

        long now = System.currentTimeMillis();
        if(acceleration > SHAKE_THRESHOLD) {
            if(!shakeDetected) {
                shakeDetected = true;
                startTime = now;
                highestScore = acceleration;
            } else {
                if(acceleration > highestScore){
                    highestScore = acceleration;
                }
            }
        }

        if (shakeDetected && now >= startTime + SHAKE_TIMEOUT){
            Log.d("test", "HighestScore: " + highestScore);
            nextPerson.setEnabled(true);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}
}