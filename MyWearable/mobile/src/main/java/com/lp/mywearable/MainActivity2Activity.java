package com.lp.mywearable;

import android.content.Intent;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    TextView textView ;
    String mReply ="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        textView = (TextView) findViewById(R.id.reply_textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        getRemoteInputMessage();

        if(mReply != null&& !mReply.equals("")){
            textView.setText(mReply);
        }
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

    public String getRemoteInputMessage(){

        Intent intent = getIntent();
        Bundle remoteInputBundle = RemoteInput.getResultsFromIntent(intent);
        if (remoteInputBundle != null) {
            mReply = remoteInputBundle.getString(MainActivity.EXTRA_VOICE_REPLY);
        }

        return mReply;
    }


}
