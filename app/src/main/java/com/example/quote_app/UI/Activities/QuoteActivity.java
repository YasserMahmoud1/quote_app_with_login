package com.example.quote_app.UI.Activities;
import com.example.quote_app.Data.Models.QuoteModel;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quote_app.R;

public class QuoteActivity extends AppCompatActivity {
    TextView quote;
    TextView movie;
    TextView year;
    TextView character;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.quote_detailed);

        Intent intent = getIntent();

        QuoteModel quoteModel = (QuoteModel) intent.getSerializableExtra("quote");


        quote = findViewById(R.id.detailsQuote);
        movie = findViewById(R.id.detailsMovie);
        year = findViewById(R.id.detailsYear);
        character = findViewById(R.id.detailsCharacter);
        imageView = findViewById(R.id.detailsImage);

        assert quoteModel != null;
        quote.setText(quoteModel.getQuote());
        movie.setText(quoteModel.getMovieName());
        year.setText(quoteModel.getMovieYear());
        character.setText(quoteModel.getCharacterName());
        imageView.setImageResource(quoteModel.getMoviePhoto());

    }

}