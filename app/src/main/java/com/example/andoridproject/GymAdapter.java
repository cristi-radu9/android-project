package com.example.andoridproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GymAdapter  extends BaseAdapter {
    private Context context;
    private List<Gym> gyms;

    public GymAdapter(Context context, List<Gym> gyms) {
        this.context = context;
        this.gyms = gyms;
    }

    @Override
    public int getCount() {
        return gyms.size();
    }

    @Override
    public Object getItem(int position) {
        return gyms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GymHolder gymHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.row,
                            parent,
                            false);
            gymHolder = new GymHolder(convertView);

        } else {
            gymHolder = (GymHolder) convertView.getTag();
        }
        Gym gym = (Gym) getItem(position);
        gymHolder.gymText.setText(gym.toString());
        return convertView;
    }

    private class GymHolder {
        public TextView gymText;

        GymHolder(View view) {
            gymText = view.findViewById(R.id.gymText);
        }
    }
}
