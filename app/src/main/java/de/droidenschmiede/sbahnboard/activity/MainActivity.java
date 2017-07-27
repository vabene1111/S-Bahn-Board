package de.droidenschmiede.sbahnboard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.droidenschmiede.sbahnboard.R;
import de.droidenschmiede.sbahnboard.helper.ApiHelper;
import de.droidenschmiede.sbahnboard.interfaces.VolleyInterface;

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

    }
}
