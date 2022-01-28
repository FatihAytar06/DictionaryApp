package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;
import com.example.dictionaryapp.models.Definitions;

import java.util.List;

public class DefinitionsAdapter extends RecyclerView.Adapter<DefinitionsAdapter.ViewHolder> {
    private Context mContext;
    private List<Definitions> mDefinitionsList;

    public DefinitionsAdapter(Context mContext, List<Definitions> mDefinitionsList) {
        this.mContext = mContext;
        this.mDefinitionsList = mDefinitionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.definitions_list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView_definition.setText("Definition: " + mDefinitionsList.get(position).getDefinition());
        holder.textView_example.setText("Example: " + mDefinitionsList.get(position).getExample());

        StringBuilder synonmys = new StringBuilder();
        StringBuilder antonmys = new StringBuilder();

        synonmys.append(mDefinitionsList.get(position).getSynonyms());
        antonmys.append(mDefinitionsList.get(position).getAntonyms());

        holder.textView_synonmys.setText(synonmys);
        holder.textView_antonmys.setText(antonmys);

        holder.textView_synonmys.setSelected(true);
        holder.textView_antonmys.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return mDefinitionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_definition,textView_example,textView_synonmys,textView_antonmys;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_definition = itemView.findViewById(R.id.textView_definition);
            textView_example = itemView.findViewById(R.id.textView_example);
            textView_synonmys = itemView.findViewById(R.id.textView_synonmys);
            textView_antonmys = itemView.findViewById(R.id.textView_antonmys);

        }
    }
}
