package com.example.student1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";


    private String mParam1;


    private OnFragmentInteractionListener mListener;
    private ListView LvList;

    public ListFragment() {

    }
    private View view;
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener!= null){
            mListener.onFragmentInteraction("列表");
        }
        if (view == null){
            view = inflater.inflate(R.layout.activity_list,container,false);
        }
        initData();
        LvList = view.findViewById(R.id.lv_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, datas
        );
        LvList.setAdapter(adapter);
        LvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String)parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(),data,Toast.LENGTH_LONG).show();
            }
        });
        LvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                datas.remove((String)parent.getItemAtPosition(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }

    private List<String> datas;
    private void initData() {
        datas = new ArrayList<>();
        datas.add("Android应用程序开发");
        datas.add("移动应用程序测试");
        datas.add("高等数学");
        datas.add("高职英语");
        datas.add("Java程序设计语言");
        datas.add("Android游戏开发");
        datas.add("心理健康");
        datas.add("体育");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);
    }
}