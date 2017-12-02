package com.example.shnzz.thitruongfull;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {
    LineDataSet lineDataSet1;
    LineDataSet lineDataSet;
    LineData lineData;
    DatabaseReference mData;
    LineChart lineChart;
    ArrayList<Entry> vang24k = new ArrayList<>();
    ArrayList<Entry> USD = new ArrayList<>();
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    Button btnBack;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        mData = FirebaseDatabase.getInstance().getReference();
        lineChart = (LineChart) findViewById(R.id.Chart);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);


        USD.add(new Entry(0, 21500));
        USD.add(new Entry(1, 21750));
        USD.add(new Entry(2, 20000));
        USD.add(new Entry(3, 19500));
        USD.add(new Entry(4, 21000));
        USD.add(new Entry(5, 22000));
        USD.add(new Entry(6, 22100));

        lineDataSet1 = new LineDataSet(USD, "USD");
        lineDataSet1.setFillAlpha(110);
        lineDataSet1.setDrawCircles(true);
        lineDataSet1.setColor(Color.GREEN);
        lineDataSet1.setLineWidth(3f);
        lineDataSet1.setValueTextSize(10f);
        lineDataSet1.setValueTextColor(Color.BLUE);

        iLineDataSets.add(lineDataSet1);

        Test();


        String[] value = new String[]{"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new XvalueFormat(value));
       /* intent = getIntent();
        if (intent == null) {
            return;
        } else {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.setClass(ChartActivity.this, thitruongfull.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
            });
        }*/
    }

    public class XvalueFormat implements IAxisValueFormatter {
        private String[] mvalue;

        public XvalueFormat(String[] values) {
            this.mvalue = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mvalue[(int) value];
        }
    }

    public void Test() {
        vang24k.add(new Entry(0, 3500000));
        vang24k.add(new Entry(1, 3400000));
        vang24k.add(new Entry(2, 3450000));
        vang24k.add(new Entry(3, 3350000));
        vang24k.add(new Entry(4, 1000000));
        vang24k.add(new Entry(5, 3300000));
        vang24k.add(new Entry(6, 3430000));

        lineDataSet = new LineDataSet(vang24k, "Vàng 24k");
        lineDataSet.setFillAlpha(110);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setValueTextColor(Color.BLUE);

        iLineDataSets.add(lineDataSet);

        lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);

        mData.child("24k_thu2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(0, new Entry(0, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("24k_thu3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(1, new Entry(1, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_thu4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(2, new Entry(2, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_thu5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(3, new Entry(3, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_thu6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(4, new Entry(4, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_thu7").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(5, new Entry(5, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_chunhat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.set(6, new Entry(6, Integer.parseInt(dataSnapshot.getValue().toString())));
                lineDataSet.notifyDataSetChanged();
                iLineDataSets.clear();
                iLineDataSets.add(lineDataSet);
                iLineDataSets.add(lineDataSet1);
                lineChart.clear();
                lineData = new LineData(iLineDataSets);
                lineChart.setData(lineData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
