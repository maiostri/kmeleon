package com.exercise.Layout;

import java.util.ArrayList;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exercise.AndroidNotifyService.R;

public class ListAlarmAdapter extends BaseAdapter {
	// adapter para a lista de configurações carregar o layout
	ArrayList<Pair<Integer, String>> itemList;
	public LayoutInflater inflater;

	public ListAlarmAdapter(Context context,ArrayList<Pair<Integer, String>> itemList) {
		super();
		this.itemList = itemList;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return itemList.size();
	}

	public Object getItem(int position) {
		return itemList.get(position);
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.alarm_view, null);
		ImageView iv = (ImageView) convertView.findViewById(R.id.imStatus);
		TextView tv = (TextView) convertView.findViewById(R.id.tvAlarm);
		Pair<Integer, String> item = itemList.get(position);
		//if (position == SelectedAlarm) {
		//	convertView.setBackgroundColor(Color.LTGRAY);
		//}
		iv.setImageResource(item.first);
		tv.setText(item.second);
		return convertView;
	}
	
}
