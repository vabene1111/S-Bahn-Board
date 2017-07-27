package de.droidenschmiede.sbahnboard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import de.droidenschmiede.sbahnboard.R;
import de.droidenschmiede.sbahnboard.helper.ApiHelper;
import de.droidenschmiede.sbahnboard.interfaces.VolleyInterface;
import de.droidenschmiede.sbahnboard.objects.CustomError;
import de.droidenschmiede.sbahnboard.objects.Departure;
import de.droidenschmiede.sbahnboard.objects.Departures;

public class MainActivity extends AppCompatActivity implements VolleyInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.testRequest(this,this);
    }

    @Override
    public void onResponse(String result, Class clazz) {
        TextView tv = findViewById(R.id.tv_main_info);
        if(clazz.equals(Departures.class)){
            Gson gson = new Gson();
            Departures departures = gson.fromJson(result, Departures.class);

            String out = "";
            for(int i = 0; i < departures.Departure.size(); i++){
                out += departures.Departure.get(i).name + " " + departures.Departure.get(i).time + " " + departures.Departure.get(i).direction + "\n";
            }
            tv.setText(out);
        }else{
            tv.setText(result);
        }

    }
}
