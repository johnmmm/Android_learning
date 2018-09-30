package johnmmm.mytest_action.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import johnmmm.mytest_action.R;

public class InfoListActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static String msg = "John App:";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        Log.d(msg, "into the info list activity");
        Toolbar toolbar = (Toolbar)findViewById(R.id.info_list_toolbar);
        toolbar.setTitle("信息汇总");
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View view){
        Log.d(msg, "click the info");
    }
}
