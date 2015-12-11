package crazecoder.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crazecoder.ui.switchbutton.ShSwitchView;

/**
 * Created by chendong on 15/12/11.
 */
public class SwitchButtonActivity extends AppCompatActivity{
    ShSwitchView switchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);
        switchView = (ShSwitchView) findViewById(R.id.switch_view);
        switchView.setOn(true);
    }

}
