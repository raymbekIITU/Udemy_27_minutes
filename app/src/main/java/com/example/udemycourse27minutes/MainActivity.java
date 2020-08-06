package com.example.udemycourse27minutes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (EditText) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String oldItem = sharedPref.getString("oldItem", "Nothing created yet...");

        textView.setText(oldItem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("oldItem", textView.getText().toString());
                editor.apply();

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(1000);
                button.startAnimation(animation);

                Log.d("DEBUG", "Button clicked!");
            }
        });
    }
}