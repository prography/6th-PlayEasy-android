package com.prography.playeasy.match.module.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.models.Place;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> implements Filterable {
    TextView tvAddressName;
    TextView tvRoadAddressName;
    ArrayList<Place> listViewItemList=new ArrayList<>();
    ArrayList<Place> filteredItemLists=listViewItemList;

    Filter listFilter;


    public PlaceAdapter(Context context,ArrayList placeList){
        super(context,R.layout.row_map_item,placeList);
//        super(context,0,placeList);
    }
//어댑터 뷰의 자식 뷰를 리턴하는 함

    public View getView(int position,View convertView,ViewGroup parent){

        final int pos=position;
        final Context context=parent.getContext();
//        if(convertView==null){
//
//            convertView=LayoutInflater.from(getContext()).inflate(R.layout.row_map_item,parent,false);
//
//
//        }
        if(convertView==null){

            LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.row_map_item,parent,false);

        }


        tvAddressName=convertView.findViewById(R.id.lefttext);
        tvRoadAddressName=convertView.findViewById(R.id.right_text);
        //data set에서 position에 위치한 데이터 참조 획득
        Place place= (Place) filteredItemLists.get(position);

//아이템 내 각 위젯에 데이터 반영
        tvRoadAddressName.setText(place.getAddress_name());
        tvRoadAddressName.setText(place.getRoad_address_name());
        return convertView;
    }
    public void onItemClick(AdapterView<?>parentView,View view,int position,long id){

         String strText= (String) parentView.getItemAtPosition(position);

    }
//vital 지정된 위치에 있는 데이터와 관계된 아이템의 id를 리턴
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public Place getItem(int position){

        return filteredItemLists.get(position);
    }
    public Filter getFilter(){


        return this.listFilter;
    }

}


