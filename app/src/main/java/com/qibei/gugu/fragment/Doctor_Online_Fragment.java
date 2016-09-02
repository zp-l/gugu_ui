package com.qibei.gugu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.MyBaseExpandableListAdapter;
import com.qibei.gugu.model.ChildItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor_Online_Fragment extends Fragment {

    private View view = null;
    private ExpandableListView expandList;
    private List<String> groupData;//group的数据源
    private Map<Integer, List<ChildItem>> childData;//child的数据源
    private MyBaseExpandableListAdapter myAdapter;

    final int CONTEXT_MENU_GROUP_DELETE = 0;//添加上下文菜单时每一个菜单项的item ID
    final int CONTEXT_MENU_GROUP_RENAME = 1;
    final int CONTEXT_MENU_CHILD_EDIT = 2;
    final int CONTEXT_MENU_CHILD_DELETE = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctor_online, container, false);
        initDatas();
        initView();
        initEvents();
        return view ;
    }

        /**
         * group和child子项的数据源
         */
        private void initDatas() {

            groupData = new ArrayList<String>();
            groupData.add("国内医生");
            groupData.add("国外医生");

            List<ChildItem> childItems = new ArrayList<ChildItem>();
            ChildItem childData1 = new ChildItem("王大仙", R.drawable.my_logo);
            childItems.add(childData1);
            ChildItem childData2 = new ChildItem("王大仙", R.drawable.my_logo);
            childItems.add(childData2);
            ChildItem childData3 = new ChildItem("王大仙", R.drawable.my_logo);
            childItems.add(childData3);

            List<ChildItem> childItems2 = new ArrayList<ChildItem>();
            ChildItem childData4 = new ChildItem("潘少华", R.drawable.my_logo);
            childItems2.add(childData4);
            ChildItem childData5 = new ChildItem("潘少华", R.drawable.my_logo);
            childItems2.add(childData5);
            ChildItem childData6 = new ChildItem("潘少华", R.drawable.my_logo);
            childItems2.add(childData6);
            ChildItem childData7 = new ChildItem("潘少华", R.drawable.my_logo);
            childItems2.add(childData7);

            childData = new HashMap<Integer, List<ChildItem>>();
            childData.put(0, childItems);
            childData.put(1, childItems2);

            myAdapter = new MyBaseExpandableListAdapter(getContext(), groupData, childData);
        }

        private void initView() {
            expandList = (ExpandableListView) view.findViewById(R.id.expandlist);
            //在drawable文件夹下新建了indicator.xml，下面这个语句也可以实现group伸展收缩时的indicator变化
            //expandList.setGroupIndicator(this.getResources().getDrawable(R.drawable.indicator));
            expandList.setGroupIndicator(null);//这里不显示系统默认的group indicator
            expandList.setAdapter(myAdapter);
            registerForContextMenu(expandList);//给ExpandListView添加上下文菜单
        }
        private void initEvents() {
            //child子项的单击事件
            expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    Toast.makeText(getActivity(), "你单击了："
                            +myAdapter.getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

}


