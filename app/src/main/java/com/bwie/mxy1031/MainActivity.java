package com.bwie.mxy1031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XListView xlvShow;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xlvShow = findViewById(R.id.xlv_show);

        list = new ArrayList();
        for (int i = 0; i < 20; i++){
           list.add("第" + (i+1) + "条数据");
        }
        MyAdapter adapter = new MyAdapter();
        xlvShow.setAdapter(adapter);
    }
    class  MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(MainActivity.this, R.layout.item_data, null);
                holder.txtTitle = convertView.findViewById(R.id.txt_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.txtTitle.setText(list.get(position));
            return convertView;
        }

        class ViewHolder {
            TextView txtTitle;
        }
    }
}
