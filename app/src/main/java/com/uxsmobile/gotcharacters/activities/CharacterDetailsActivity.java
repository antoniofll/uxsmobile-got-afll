package com.uxsmobile.gotcharacters.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uxsmobile.gotcharacters.R;
import com.uxsmobile.gotcharacters.model.Character;
import com.uxsmobile.gotcharacters.util.Constants;


/**
 * Created by Afll on 09/08/2017.
 */

public class CharacterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        //Retrieve intent
        Character character = (Character) getIntent().getSerializableExtra("character");

        //Toolbar settings
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(character.getName());

        //View resources
        TextView name = (TextView) findViewById(R.id.name);
        TextView house = (TextView) findViewById(R.id.house);
        TextView actor = (TextView) findViewById(R.id.actor);
        TextView genre = (TextView) findViewById(R.id.genre);
        ImageView photo = (ImageView) findViewById(R.id.photo);

        //Set values
        name.setText(character.getName());
        house.setText("House: " + character.getHouse());
        actor.setText("Actor: " + character.getActor());
        if(character.isMale()){
            genre.setText("Genre: Male");
        }else{
            genre.setText("Genre: Female");
        }
        Picasso.with(this).load(Constants.API_URL+ character.getImageLink()).into(photo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
