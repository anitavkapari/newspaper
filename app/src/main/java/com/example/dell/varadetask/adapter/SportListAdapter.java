package com.example.dell.varadetask.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.varadetask.NationalActivity;
import com.example.dell.varadetask.R;
import com.example.dell.varadetask.SportsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class SportListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public SportListAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SportListViewHolder holder = null;
        if (convertView == null) {
            holder = new SportListViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_items, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.sdetails = (TextView) convertView.findViewById(R.id.sdetails);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (SportListViewHolder) convertView.getTag();
}
        holder.galleryImage.setId(position);
        holder.author.setId(position);
        holder.title.setId(position);
        holder.sdetails.setId(position);
        holder.time.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try{
            holder.author.setText(song.get(SportsActivity.KEY_AUTHOR));
            holder.title.setText(song.get(SportsActivity.KEY_TITLE));
            holder.time.setText(song.get(SportsActivity.KEY_PUBLISHEDAT));
            holder.sdetails.setText(song.get(SportsActivity.KEY_DESCRIPTION));

            if(song.get(SportsActivity.KEY_URLTOIMAGE).toString().length() < 5)
            {
                holder.galleryImage.setVisibility(View.GONE);
            }else{
                Picasso.with(activity)
                        .load(song.get(SportsActivity.KEY_URLTOIMAGE).toString())
                        .resize(300, 200)
                        .into(holder.galleryImage);
            }
        }catch(Exception e) {}
        return convertView;
    }
}
class SportListViewHolder {
    ImageView galleryImage;
    TextView author, title, sdetails, time;
}
