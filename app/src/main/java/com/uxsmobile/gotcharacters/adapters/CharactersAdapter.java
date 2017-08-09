package com.uxsmobile.gotcharacters.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.uxsmobile.gotcharacters.R;
import com.uxsmobile.gotcharacters.activities.CharacterDetailsActivity;
import com.uxsmobile.gotcharacters.model.Character;
import com.uxsmobile.gotcharacters.util.Constants;
import com.uxsmobile.gotcharacters.viewholders.CharacterViewholder;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by Afll on 09/08/2017.
 */

public class CharactersAdapter extends RecyclerView.Adapter {
    Context context;
    List<Character> items = new ArrayList<>();

    public CharactersAdapter(Context context, List<Character> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View characterView = inflater.inflate(R.layout.recyclerview_item_character, parent, false);
        viewHolder = new CharacterViewholder(characterView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharacterViewholder vh = (CharacterViewholder) holder;
        configureCharacterViewholder(vh,position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void configureCharacterViewholder(final CharacterViewholder vh, int position){
        final Character character = items.get(position);

        vh.nameTextView.setText(character.getName());
        Picasso.with(context).load(Constants.API_URL+character.getImageLink()).placeholder(R.color.greyError).fit().centerCrop().transform(new VignetteFilterTransformation(context,
                new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f)).into(vh.photoImageView);

        //OnClick Listener - Handle intent to CharacterDetailsActivity
        vh.characterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CharacterDetailsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("character",character);
                context.startActivity(i);
            }
        });
    }
}
