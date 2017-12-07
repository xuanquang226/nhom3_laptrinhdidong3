package com.example.trile.storeverfinal.HoangNhatSon.Java;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.trile.storeverfinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private View rootView;
    ArrayList<String> arraylistHang;
    ArrayList<String> arrayListItemRam = null;
    Spinner spinnerhang;
    ArrayAdapter arrayAdapterRam;

    // Giá
    ArrayList<String> arrayListKhoangGia;
    Spinner spinnerKhoangGia;

    //Dung lượng
    ArrayList<String> arrayListDungLuong;
    Spinner spinnerDungLuong;

    // Bus
    ArrayList<String> arrayListBus;
    Spinner spinnerBus;

    ListView listViewRam;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list,menu);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.list_layout, container, false);
        initView();
        createSpinnerHang();
        createSpinnerGia();
        createSpinnerDungLuong();
        createSpinnerBus();
        createListViewRam();
        return rootView;
    }

    private void createListViewRam() {
        arrayListItemRam = new ArrayList<String>();
        arrayListItemRam.add("Tên : Ram Apacer Rage \n Dung Lượng : 4GB \n Bus : 2133Mhz");
        arrayListItemRam.add("Tên : Ram KingSton Hyper X \n Dung Lượng : 8GB \n Bus : 2400Mhz");
        arrayListItemRam.add("Tên : Ram Gskill Tridenz \n Dung Lượng : 16GB \n Bus : 3200Mhz");
        arrayAdapterRam = new ArrayAdapter(getActivity().getBaseContext(), R.layout.listviewram_layout, arrayListItemRam);
        listViewRam.setAdapter(arrayAdapterRam);
    }

    private void initView() {
        spinnerhang = rootView.findViewById(R.id.spnHang);
        spinnerKhoangGia = rootView.findViewById(R.id.spnGia);
        spinnerDungLuong = rootView.findViewById(R.id.spnDungLuong);
        spinnerBus = rootView.findViewById(R.id.spnBus);
        listViewRam = rootView.findViewById(R.id.lvRam);
    }

    private void createSpinnerHang() {
        arraylistHang = new ArrayList<String>();
        arraylistHang.add(" Hãng");
        arraylistHang.add(" Apacer");
        arraylistHang.add(" Gskill");
        arraylistHang.add(" Kingston");
        ArrayAdapter<String> arrayAdapterHang = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.spiner_hang_layout, arraylistHang);
        arrayAdapterHang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerhang.setAdapter(arrayAdapterHang);
    }

    private void createSpinnerGia() {
        arrayListKhoangGia = new ArrayList<>();
        arrayListKhoangGia.add(" Giá");
        arrayListKhoangGia.add(" Dưới 1 triệu");
        arrayListKhoangGia.add(" 1 đến 3 triệu");
        arrayListKhoangGia.add(" 3 đến 5 triệu");
        arrayListKhoangGia.add(" Trên 5 triệu");
        ArrayAdapter<String> arrayAdapterKhoangGia = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.spiner_hang_layout, arrayListKhoangGia);
        arrayAdapterKhoangGia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKhoangGia.setAdapter(arrayAdapterKhoangGia);
    }

    private void createSpinnerDungLuong() {
        arrayListDungLuong = new ArrayList<>();
        arrayListDungLuong.add(" Dung lượng ");
        arrayListDungLuong.add(" 4GB");
        arrayListDungLuong.add(" 8GB");
        arrayListDungLuong.add(" 16GB");
        ArrayAdapter<String> arrayAdapterDungLuong = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.spiner_hang_layout, arrayListDungLuong);
        arrayAdapterDungLuong.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDungLuong.setAdapter(arrayAdapterDungLuong);
    }

    private void createSpinnerBus() {
        arrayListBus = new ArrayList<>();
        arrayListBus.add(" Bus");
        arrayListBus.add(" 1600Mhz");
        arrayListBus.add(" 2133Mhz");
        arrayListBus.add(" 2400Mhz");
        ArrayAdapter<String> arrayAdapterBus = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.spiner_hang_layout, arrayListBus);
        arrayAdapterBus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBus.setAdapter(arrayAdapterBus);
    }

}
