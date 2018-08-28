package com.eunicefrimponmaa.droidcafepart1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void onRadioButtonClicked(View view) {
        //is the button now checked
        boolean checked = ((RadioButton)view).isChecked();
        //check which radio button was clicked
        switch (view.getId()){
            case R.id.sameday:
                if(checked)
                    //same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    //next day delivery
                    displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.pickup:
                if(checked)
                    //pick up
                    displayToast(getString(R.string.chosen)+getString(R.string.pick_up));
                break;

               default:
                   Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
                   break;
        }

    }

    public void  displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
