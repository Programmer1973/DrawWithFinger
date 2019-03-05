package ru.dudin.drawwithfinger;

/**
 * With this simple program you can draw with your finger on the phone screen.
 *
 * @created 05.03.2019
 * @author Andrey Dudin <programmer1973@mail.ru>
 * @version 0.1.0.2019.03.05
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new MySurfaceView(this));
    }
}