package sensorapp.sensorreading;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private String[] itemList = {"Ambient Light Sensor", "Accelerometer", "Magnetometer", "Gyroscope",
            "Orientation Sensor", "Pressure Sensor", "Proximity Sensor", "Ambient Temperature Sensor",
            "Humidity Sensor", "Optical Image Stabilizer"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, itemList);
        ListView listView = (ListView) findViewById(R.id.main_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = itemList[position];
                Intent intent;
                SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                switch (string){
                    case "Ambient Light Sensor":
                        //Call Light Sensor
                        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
                            intent = new Intent(MainActivity.this, LightActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, string + " does not exist.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Accelerometer":
                        //Call Accelerometer
                        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
                            intent = new Intent(MainActivity.this, AccelActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, string + " does not exist.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Pressure Sensor":
                        //Call Pressure Sensor
                        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
                            intent = new Intent(MainActivity.this, PressureActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, string + " does not exist.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "You pressed "+string+".",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
