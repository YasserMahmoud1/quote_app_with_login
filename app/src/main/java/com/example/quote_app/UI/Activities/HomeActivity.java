package com.example.quote_app.UI.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;
import com.example.quote_app.R;
import com.example.quote_app.UI.Adapters.QuoteAdapter;

import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    List<QuoteModel> quotesList;
    ListView listView;
    TextView text;
    Button btn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        quotesList = QuoteRepo.getQuotes();
        listView = findViewById(R.id.homeListView);

        btn = findViewById(R.id.loginBtn);
        text = findViewById(R.id.homeText);

        QuoteAdapter aa = new QuoteAdapter(this,R.layout.quote_item,R.id.textItem, quotesList);
        listView.setAdapter(aa);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            QuoteModel selectedQuote = quotesList.get(position);
            Intent intent = new Intent(HomeActivity.this, QuoteActivity.class);
            intent.putExtra("quote", selectedQuote); // Assuming QuoteModel implements Serializable or Parcelable
            startActivity(intent);
        });
        String name = Objects.requireNonNull(getIntent().getExtras()).getString("UserName");
        if(!Objects.equals(name, "NotSET")){
            text.setVisibility(View.VISIBLE);
            text.setText(String.format("Welcome %s", name));
            btn.setVisibility(View.INVISIBLE);
        }else{
            text.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.VISIBLE);
        }
    }
    public void goToLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}