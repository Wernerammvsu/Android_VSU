package com.example.firstjavaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bumptech.glide.Glide;

public class ListAdapter extends BaseAdapter {
    private final Context context;
    private String[] image;
    private String[] name;

    public ListAdapter(Context context, String[] image, String[] name) {
        this.context = context;
        this.image = image;
        this.name = name;

    }


    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;

        if (view==null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null, true);

            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.image = view.findViewById(R.id.img);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(name[i]);
        loadImage(viewHolder, i);

        return view;
    }

    public void loadImage(ViewHolder viewHolder, int position) {
        Glide.with(context)
                .load(image[position])
                .into(viewHolder.image);
    }

}
