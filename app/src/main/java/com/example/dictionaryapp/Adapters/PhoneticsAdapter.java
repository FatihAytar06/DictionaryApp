package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;
import com.example.dictionaryapp.models.Phonetics;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticsAdapter.ViewHolder> {
    private Context mContext;
    private List<Phonetics> mPhoneticsList;

    public PhoneticsAdapter(Context mContext, List<Phonetics> mPhoneticsList) {
        this.mContext = mContext;
        this.mPhoneticsList = mPhoneticsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.phonetic_list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView_phonetic.setText(mPhoneticsList.get(position).getText());
        holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player = new MediaPlayer();
                try {
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource("https:"+mPhoneticsList.get(position).getAudio());
                    player.prepare();
                    player.start();
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(mContext, "Couldn't play the audio!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPhoneticsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_phonetic;
        ImageButton imageButton_audio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_phonetic = itemView.findViewById(R.id.textView_phonetic);
            imageButton_audio = itemView.findViewById(R.id.imageButton_audio);

        }
    }
}
