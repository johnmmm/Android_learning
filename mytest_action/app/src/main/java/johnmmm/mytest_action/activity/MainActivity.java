package johnmmm.mytest_action.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;

import johnmmm.mytest_action.R;
import johnmmm.mytest_action.data.JohnSQLCreateNew;
import johnmmm.mytest_action.data.JohnSQLOpenHelper;
import johnmmm.mytest_action.fragment.InfoListFragment;

public class MainActivity extends AppCompatActivity {

    public static final int INPUT_NAME_ACTIVITY = 1;
    public static final int INPUT_AGE_ACTIVITY = 2;
    public static final int INFO_LIST_ACTIVITY = 3;

    private String name = "Johnmmm";
    private int age = 21;
    private TextView tv_name;
    private TextView tv_age;
    String msg = "John APP : ";

    public void initTextview(){
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_name.setText(name);
        tv_age.setText(String.valueOf(age));
    }

    public void initActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("信息录入");
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = null;
                Log.d(msg, "click");
                switch (item.getItemId()) {
                    case R.id.main_menu_initial:
                        JohnSQLCreateNew.getInstance(JohnSQLOpenHelper.
                                getInstance(getApplicationContext())).createNewSqlite();
                        break;
                    case R.id.main_menu_delete_db:
                        JohnSQLCreateNew.getInstance(JohnSQLOpenHelper.
                                getInstance(getApplicationContext())).removeAll();
                        break;
                    case R.id.main_menu_look_up_info:
                        //TODO: new intent to another activity
                        Log.d(msg, "ready to in");
                        intent = new Intent(MainActivity.this, InfoListActivity.class);
                        startActivityForResult(intent, INFO_LIST_ACTIVITY);
                        break;
                    case R.id.action_settings:
                        break;
                }
                return true;
            }
        });
    }

    public void initButtons(){
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                intent.putExtra("key", "name");
                intent.putExtra("value", name);
                startActivityForResult(intent, INPUT_NAME_ACTIVITY);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                intent.putExtra("key", "age");
                intent.putExtra("value", String.valueOf(age));
                startActivityForResult(intent, INPUT_AGE_ACTIVITY);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Log.d(msg, "The onCreate() event");

        initTextview();
        initActionBar();
        initButtons();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == 1) {
            String result = data.getStringExtra("result");

            if (requestCode == INPUT_NAME_ACTIVITY) {
                name = result;
                tv_name.setText(result);
            }

            else if (requestCode == INPUT_AGE_ACTIVITY) {

                try {
                    age = Integer.parseInt(result);
                    tv_age.setText(result);
                }

                catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,1,1,R.string.quit);
        menu.add(0,2,2,R.string.about);
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
        if (item.getItemId() == 1) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
