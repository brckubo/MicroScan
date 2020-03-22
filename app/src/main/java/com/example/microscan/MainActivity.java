package com.example.microscan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.opencvdemo.SwitchLight;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    SwitchLight switchLight = new SwitchLight();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xlb);
                imageView.setImageBitmap(bitmap);
                Log.d(String.valueOf(this), "boot1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(switchLight.getGrayImg(((BitmapDrawable) ((ImageView) imageView).getDrawable()).getBitmap()));
                Log.d(String.valueOf(this), "boot3");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(switchLight.getBinaryzation(((BitmapDrawable) ((ImageView) imageView).getDrawable()).getBitmap(), 170, 200));
                Log.d(String.valueOf(this), "boot2");
            }
        });
    }
}
