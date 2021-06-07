package com.example.every;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecommendActivity extends AppCompatActivity{

    ImageButton home;
    ListView list;
    MyItem mi;
    ArrayList<MyItem> mydata;
    MyAdapter adap;
    View.OnClickListener cl;

    class MyItem {
        int road;
        String street;
        String time;
        String info;
        MyItem(int a, String b, String c, String d) {
            road = a;
            street = b;
            time = c;
            info = d;
        }
    }

    class MyAdapter extends BaseAdapter {
        Context con;
        MyAdapter(Context c) {
            con = c;
        }

        @Override
        public int getCount() {
            return mydata.size();
        }

        @Override
        public Object getItem(int position) {
            return mydata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if ( convertView == null) {
                convertView = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(
                        R.layout.road, parent, false);
            }
            ((ImageView)convertView.findViewById(R.id.iv_road)).setImageResource(mydata.get(position).road);
            ((TextView) convertView.findViewById(R.id.tv_street)).setText(mydata.get(position).street);
            ((TextView) convertView.findViewById(R.id.tv_time)).setText(mydata.get(position).time);
            ((TextView) convertView.findViewById(R.id.tv_info)).setText(mydata.get(position).info);
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend);

        home = (ImageButton) findViewById(R.id.home_button);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };
        home.setOnClickListener(cl);

        mydata = new ArrayList<MyItem>();

        mi = new MyItem(R.drawable.logo, "약 7.5km 입니다.", "약 4시간 소요됩니다.", "복정역 부근에 있습니다.");
        mydata.add(mi);
        mi = new MyItem(R.drawable.logo, "약 7.4km 입니다.", "약 3시간 30분소요됩니다.", "황송공원, 남한산성 도립공원 부근에 있습니다.");
        mydata.add(mi);
        mi = new MyItem(R.drawable.logo, "약 9.7km 입니다.", "약 4시간 30분 소요됩니다.", "오르막코스가 많습니다.");
        mydata.add(mi);
        mi = new MyItem(R.drawable.logo, "약 9.5km 입니다.", "약 4시간 소요됩니다.", "신구대학교 식물원 부근에 있습니다.");
        mydata.add(mi);
        mi = new MyItem(R.drawable.logo, "약 1.2km 입니다.", "약 15분 소요됩니다.", "공원 한 바퀴를 도는 순환산책로입니다.");
        mydata.add(mi);

        list = (ListView) findViewById(R.id.list);
        adap = new MyAdapter(this);
        list.setAdapter(adap);
    }
}