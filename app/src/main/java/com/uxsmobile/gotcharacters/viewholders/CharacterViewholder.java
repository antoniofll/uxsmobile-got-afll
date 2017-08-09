package com.uxsmobile.gotcharacters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uxsmobile.gotcharacters.R;

/**
 * Created by Afll on 09/08/2017.
 */

public class CharacterViewholder extends RecyclerView.ViewHolder{
    public TextView nameTextView;
    public ImageView photoImageView;
    public RelativeLayout characterLayout;

    public CharacterViewholder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.name);
        photoImageView = (ImageView) itemView.findViewById(R.id.photo);
        characterLayout = (RelativeLayout) itemView.findViewById(R.id.characterLayout);
    }
}
