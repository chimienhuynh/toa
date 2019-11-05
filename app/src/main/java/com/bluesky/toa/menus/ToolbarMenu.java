package com.bluesky.toa.menus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;

import com.bluesky.toa.R;
import com.bluesky.toa.activities.ProfileMainActivity;

/**
 * @author Xue Nian Jiang
 *
 * Toolbar Menu class to handle the toolbar issue for the whole project
 */

public class ToolbarMenu {
    private Context context;
    private String helpTitle, aboutTitle;
    private String helpMessage, aboutMessage;

    public ToolbarMenu(Context context) {
        this.context = context;
    }

    // set help title for each activity
    public void setHelpTitle(String title){
        helpTitle = title;
    }

    // set help message for each activity
    public void setHelpMessage(String message){
        helpMessage = message;
    }

    // set about title for each activity
    public void setAboutTitle(String title){
        aboutTitle = title;
    }

    // set about message for each activity
    public void setAboutMessage(String message){
        aboutMessage = message;
    }

    // handle selected toolbar menu item
    public Intent onToolbarItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
//            case R.id.home_main_item_jj:
//                intent = new Intent(context, HomePageActivity.class);
//                break;
//            case R.id.connect_main_item_jj:
//                intent = new Intent(context, ConnectMainActivity.class);
//                break;
//            case R.id.features_main_item_jj:
//                intent = new Intent(context, FeaturesMainActivity.class);
//                break;
            case R.id.profile_main_item_jj:
                intent = new Intent(context, ProfileMainActivity.class);
                break;
            case R.id.help_menu_item:
                showMessageDialog( helpTitle, helpMessage);
                break;
            case R.id.about_menu_item:
                showMessageDialog( context.getString(R.string.app_name), getAboutMessage());
                break;
            case R.id.log_out_menu_item:
                showMessageDialog( context.getString(R.string.app_name), getLog_outMessage());
                break;
            default:
//                intent = new Intent(context, HomePageActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }
        return intent;
    }

    // show help or about dialog
    public void showMessageDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.positive_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    public String getAboutMessage() {
        String msg = context.getString(R.string.version_info) + "\n";
        msg += "\n" + context.getString(R.string.organiztion_name) + "\n";
        msg += "\n" + context.getString(R.string.group_message) + "\n";
        msg += "\n" + context.getString(R.string.course_message);
        return msg;
    }

    public String getLog_outMessage() {
        String msg = context.getString(R.string.log_out_msg);
        msg += " " + context.getString(R.string.app_name) + "?";
        return msg;
    }

}
