package com.example.shanson.myapplication.base.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shanson.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class AddressFragment extends Fragment {
    private ListView list_item;

    private List<MapAddress> mapList=new ArrayList<>();
    MapAddress map = new MapAddress();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);

        AddressAdapter adapter = new AddressAdapter(getActivity(), R.layout.listview_item, classinit());
        list_item = (ListView) view.findViewById(R.id.list_item);
        list_item.setAdapter(adapter);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MapAddress mapAddress = mapList.get(i);

                Toast.makeText(getContext(), mapAddress.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    public List<MapAddress> classinit() {

        for (int i = 0; i <12; i++) {
            map.setImage_map(R.mipmap.map1 );
            map.setName("旭日上城");
            map.setAddress("南京市浦口区37号");
            mapList.add(map);
        }
                 return mapList;
    }


}
