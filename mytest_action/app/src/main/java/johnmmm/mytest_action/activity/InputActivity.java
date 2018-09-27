package johnmmm.mytest_action.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import johnmmm.mytest_action.R;

/**
 * Created by mac on 2018/9/23.
 */

public class InputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layer);

        System.out.println("inputing");

        Intent intent = getIntent();
        String key = intent.getStringExtra("name");
        String value = intent.getStringExtra("value");

        TextView textView = (TextView) findViewById(R.id.textview1);
        final EditText edittext = (EditText) findViewById(R.id.edittext1);

        textView.setText(key);
        edittext.setText(value);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", edittext.getEditableText().toString());
                setResult(1, intent);
                finish();
            }
        });
    }
}
