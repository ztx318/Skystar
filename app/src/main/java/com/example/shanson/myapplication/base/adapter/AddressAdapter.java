package com.example.shanson.myapplication.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shanson.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class AddressAdapter extends ArrayAdapter<MapAddress> {
    private int resourceId;
    public AddressAdapter(Context context, int resource, List<MapAddress> objects) {
        super(context, resource, objects);
        this.resourceId=resource;

    }
    public View getView(int position, View convertView, ViewGroup parent){
    final MapAddress mapAddress=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
             view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
         viewHolder=new ViewHolder();
            viewHolder.map=(ImageView) view.findViewById(R.id.image_map);
            viewHolder.mapname=(TextView) view.findViewById(R.id.text_mapname);
            viewHolder.mapaddress=(TextView) view.findViewById(R.id.text_mapaddress);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.map.setImageResource(mapAddress.getImage_map());
        viewHolder.mapname.setText(mapAddress.getName());
        viewHolder.mapaddress.setText(mapAddress.getAddress());
     return view;
    }

 class ViewHolder {

     TextView mapaddress;
     TextView mapname;
     ImageView map;

    }
}
