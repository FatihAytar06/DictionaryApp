package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;
import com.example.dictionaryapp.models.Meanings;

import java.util.List;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningsAdapter.ViewHolder> {
    private Context mContext;
    private List<Meanings> mMeaningsList;

    public MeaningsAdapter(Context mContext, List<Meanings> mMeaningsList) {
        this.mContext = mContext;
        this.mMeaningsList = mMeaningsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.meanings_list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView_partsOfSpeech.setText("Parts of speech: "+mMeaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(mContext,1));
        DefinitionsAdapter definitionsAdapter = new DefinitionsAdapter(mContext,mMeaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionsAdapter);
    }

    @Override
    public int getItemCount() {
        return mMeaningsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_partsOfSpeech;
        RecyclerView recycler_definitions;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_partsOfSpeech = itemView.findViewById(R.id.textView_partsOfSpeech);
            recycler_definitions = itemView.findViewById(R.id.recycler_definitions);

        }
    }
}
