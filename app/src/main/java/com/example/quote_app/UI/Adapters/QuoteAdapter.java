package com.example.quote_app.UI.Adapters;
import com.example.quote_app.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class QuoteAdapter extends ArrayAdapter<QuoteModel> {

    List<QuoteModel> quotes ;
    public QuoteAdapter(Context context, int resource, int textViewResourceID, List<QuoteModel> list){
        super(context, resource, textViewResourceID, list);
        quotes = QuoteRepo.getQuotes();
    }

    @Override
    public int getCount(){
        return super.getCount();
    }

    @NonNull
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View view;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.quote_item,null);
        TextView textView = view.findViewById(R.id.textItem);
        ImageView imageView = view.findViewById(R.id.imageItem);
        textView.setText(quotes.get(position).getQuote());
        imageView.setImageResource(quotes.get(position).getMoviePhoto());
        return view;
    }


}
