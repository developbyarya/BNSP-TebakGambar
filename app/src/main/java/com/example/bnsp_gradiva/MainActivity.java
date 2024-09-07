package com.example.bnsp_gradiva;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int[] imageIds = {
          R.id.whatsapp, R.id.car, R.id.chair,
            R.id.jamtangan, R.id.pesawat, R.id.sampah
        };

        for (int img: imageIds){
            ImageView imgView = findViewById(img);
            imgView.setOnClickListener(imageClickListener);
        }

    }

    private final View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int imageId = view.getId();
            int resourceId = 0;
            if (imageId == R.id.pesawat) {
                resourceId = R.drawable.pesawat;
            } else if (imageId == R.id.car) {
                resourceId = R.drawable.car;
            } else if (imageId == R.id.chair) {
                resourceId = R.drawable.chair;
            } else if (imageId == R.id.jamtangan) {
                resourceId = R.drawable.jamtangan;
            } else if (imageId == R.id.sampah) {
                resourceId = R.drawable.sampah;
            } else if (imageId == R.id.whatsapp) {
                resourceId = R.drawable.whatsapp;
            }

            Intent intent = new Intent(MainActivity.this, GuessActivity.class);
            intent.putExtra("selectedImageId", resourceId);
            intent.putExtra("key", imageId);
            startActivity(intent);
        }
    };


}