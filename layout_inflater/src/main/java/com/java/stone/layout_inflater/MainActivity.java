package com.java.stone.layout_inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity {

    CustomProgressDialog dialog;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rOut = findViewById(R.id.rOut);
        imageView = findViewById(R.id.iv);
        LinearLayout lOut = new LinearLayout(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300,
                300);
        lOut.setLayoutParams(params);
        lOut.setBackgroundColor(Color.GREEN);
        LayoutInflater lf = getLayoutInflater();

        //View v = lf.inflate(R.layout.ctm_btn,null); // btn is root view..
        //View v = lf.inflate(R.layout.ctm_btn,lOut); // now lout is root view
        //View v = lf.inflate(R.layout.ctm_btn,lOut,true);
        View v = lf.inflate(R.layout.ctm_btn,lOut);
        rOut.addView(lOut, params);

        //rOut.addView(v);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                dialog.dismiss();
//            }
//        },10000);
        // Set up the OnBackPressedCallback
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Show the dialog when the back button is pressed
                showExitConfirmationDialog();
            }
        };

        // Add the callback to the OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int items = item.getItemId();
        if (items == R.id.loading) {
            //imageView.setVisibility(View.VISIBLE);
        } else if (items == R.id.contact) {
            Intent iContact = new Intent(MainActivity.this,Contact.class);
            startActivity(iContact);
        }
        return true;
    }

    private void showExitConfirmationDialog() {
        // Create and show a dialog fragment
        MainActivity.ExitConfirmationDialogFragment dialogFragment = new MainActivity.ExitConfirmationDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "exit_confirmation_dialog");
    }

        // Your dialog fragment class
        public static class ExitConfirmationDialogFragment extends DialogFragment {

            @NonNull
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Exit Confirmation")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle the user's choice (e.g., finish the activity)
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dismiss the dialog
                                dialog.dismiss();
                            }
                        });

                return builder.create();
            }
        }
}
