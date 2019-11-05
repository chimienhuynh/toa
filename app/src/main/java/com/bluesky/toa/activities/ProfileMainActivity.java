package com.bluesky.toa.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bluesky.toa.R;
import com.bluesky.toa.menus.ToolbarMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * @author Xue Nian Jiang
 * Profile Main for profile functions and navigate to Homepage, Connect, Features
 */

public class ProfileMainActivity extends AppCompatActivity {

    private ToolbarMenu toolitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_profile_main_jj);
        setSupportActionBar(toolbar);

        toolitem = new ToolbarMenu(ProfileMainActivity.this);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.getItem(3).setVisible(false);
        toolitem.setHelpTitle(getString(R.string.profile_help_title));
        toolitem.setHelpMessage(getString(R.string.profile_help_message));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        Intent intent = toolitem.onToolbarItemSelected(item);
        if( intent != null) //{
            startActivity(intent);
        ProfileMainActivity.this.finish();
//        }
        return super.onOptionsItemSelected(item);
    }
}
