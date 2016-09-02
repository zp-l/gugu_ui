package com.qibei.gugu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import com.qibei.gugu.adapter.MyBaseExpandableListAdapter;
import com.qibei.gugu.model.ChildItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ConsultationActivity  为下拉列表测试类   可删除
 */
public class ConsultationActivity  extends Activity {
	private ExpandableListView expandList;
	private List<String> groupData;//group的数据源
	private Map<Integer, List<ChildItem>> childData;//child的数据源
	private MyBaseExpandableListAdapter myAdapter;

	final int CONTEXT_MENU_GROUP_DELETE = 0;//添加上下文菜单时每一个菜单项的item ID
	final int CONTEXT_MENU_GROUP_RENAME = 1;
	final int CONTEXT_MENU_CHILD_EDIT = 2;
	final int CONTEXT_MENU_CHILD_DELETE = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_doctor_online);
		initDatas();
		initView();
		initEvents();
	}
	/**
	 * group和child子项的数据源
	 */
	private void initDatas() {

		groupData = new ArrayList<String>();
		groupData.add("国内医生");
		groupData.add("国外医生");

		List<ChildItem> childItems = new ArrayList<ChildItem>();
		ChildItem childData1 = new ChildItem("王大仙", R.drawable.doctor_logo);
		childItems.add(childData1);
		ChildItem childData2 = new ChildItem("王大仙", R.drawable.doctor_logo);
		childItems.add(childData2);
		ChildItem childData3 = new ChildItem("王大仙", R.drawable.doctor_logo);
		childItems.add(childData3);

		List<ChildItem> childItems2 = new ArrayList<ChildItem>();
		ChildItem childData4 = new ChildItem("潘少华", R.drawable.doctor_logo);
		childItems2.add(childData4);
		ChildItem childData5 = new ChildItem("潘少华", R.drawable.doctor_logo);
		childItems2.add(childData5);
		ChildItem childData6 = new ChildItem("潘少华", R.drawable.doctor_logo);
		childItems2.add(childData6);
		ChildItem childData7 = new ChildItem("潘少华", R.drawable.doctor_logo);
		childItems2.add(childData7);


		childData = new HashMap<Integer, List<ChildItem>>();
		childData.put(0, childItems);
		childData.put(1, childItems2);

		myAdapter = new MyBaseExpandableListAdapter(this, groupData, childData);
	}

	private void initView() {
		expandList = (ExpandableListView) findViewById(R.id.expandlist);
		//在drawable文件夹下新建了indicator.xml，下面这个语句也可以实现group伸展收缩时的indicator变化
		//expandList.setGroupIndicator(this.getResources().getDrawable(R.drawable.indicator));
		expandList.setGroupIndicator(null);//这里不显示系统默认的group indicator
		expandList.setAdapter(myAdapter);
		registerForContextMenu(expandList);//给ExpandListView添加上下文菜单
	}
	private void initEvents() {
		//child子项的单击事件
		expandList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
										int groupPosition, int childPosition, long id) {
				Toast.makeText(ConsultationActivity .this, "你单击了："
						+myAdapter.getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show();
				return true;
			}
		});

	}

}
