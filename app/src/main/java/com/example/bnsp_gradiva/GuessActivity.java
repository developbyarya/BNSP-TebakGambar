package com.example.bnsp_gradiva;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class GuessActivity extends AppCompatActivity {
    EditText edt_guess;
    int selectedImageId, key;
    HashMap<Integer, String> answers = new HashMap<Integer, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        edt_guess = findViewById(R.id.edt_guess);

        key = getIntent().getIntExtra("key", R.id.whatsapp);
        selectedImageId = getIntent().getIntExtra("selectedImageId", R.drawable.whatsapp);
        ImageView img = findViewById(R.id.selectedImage);
        img.setImageResource(selectedImageId);

//        Setup Kunci jawaban
        answers.put(R.id.car, "mobil");
        answers.put(R.id.pesawat, "pesawat");
        answers.put(R.id.chair, "kursi");
        answers.put(R.id.jamtangan, "jam tangan");
        answers.put(R.id.sampah, "sampah");
        answers.put(R.id.whatsapp, "whatsapp");

        Button guessButton = findViewById(R.id.btn_guess);
        guessButton.setOnClickListener(reviewGuess);

    }

    private final View.OnClickListener reviewGuess = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user_guess = edt_guess.getText().toString().toLowerCase();

            if (!user_guess.equals(answers.get(key))){
//                Logic if Wrong
                Intent intent = new Intent(GuessActivity.this, SalahActivity.class);
                intent.putExtra("user_answer", user_guess);
                intent.putExtra("expected_answer", answers.get(key));
                startActivity(intent);
            } else {
                Intent intent = new Intent(GuessActivity.this, BenarActivity.class);
                intent.putExtra("user_answer",user_guess);
                startActivity(intent);

            }

        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}