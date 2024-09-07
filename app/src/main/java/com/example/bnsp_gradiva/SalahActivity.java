package com.example.bnsp_gradiva;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.AppBarLayout;

public class SalahActivity extends AppCompatActivity {
    String passed_answer, expected_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_salah);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        passed_answer = getIntent().getStringExtra("user_answer");
        expected_answer = getIntent().getStringExtra("expected_answer");

        TextView user_answer = findViewById(R.id.txt_user_answer),
        expected_answer_view = findViewById(R.id.txt_expected_answer);
        user_answer.setText(String.format("Jawaban Anda: %s", passed_answer));
        expected_answer_view.setText(String.format("Jawaban Benar: %s", expected_answer));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SalahActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}