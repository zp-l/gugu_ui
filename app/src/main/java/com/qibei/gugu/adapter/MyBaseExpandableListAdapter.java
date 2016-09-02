package com.qibei.gugu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.model.ChildItem;

import java.util.List;
import java.util.Map;

/**
 * ExpandListView的适配器，继承自BaseExpandableListAdapter   点击下拉列表
 *
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter implements OnClickListener {

	private Context mContext;
	private List<String> groupTitle;
	//子项是一个map，key是group的id，每一个group对应一个ChildItem的list
	private Map<Integer, List<ChildItem>> childMap;

	public MyBaseExpandableListAdapter(Context context, List<String> groupTitle, Map<Integer, List<ChildItem>> childMap) {
		this.mContext = context;
		this.groupTitle = groupTitle;
		this.childMap = childMap;
	}
	/*
	 *  Gets the data associated with the given child within the given group
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		//我们这里返回一下每个item的名称，以便单击item时显示
		return childMap.get(groupPosition).get(childPosition).getTitle();
	}
	/*
	 * 取得给定分组中给定子视图的ID. 该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}
	/*
	 *  Gets a View that displays the data for the given child within the given group
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
							 ViewGroup parent) {
		ChildHolder childHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_doctor_online, null);
			childHolder = new ChildHolder();
			childHolder.childImg = (ImageView) convertView.findViewById(R.id.img_child);
			childHolder.childText = (TextView) convertView.findViewById(R.id.tv_child_text);
			convertView.setTag(childHolder);
		}else {
			childHolder = (ChildHolder) convertView.getTag();
		}
		childHolder.childImg.setBackgroundResource(childMap.get(groupPosition).get(childPosition).getMarkerImgId());
		childHolder.childText.setText(childMap.get(groupPosition).get(childPosition).getTitle());

		return convertView;
	}

	/*
	 * 取得指定分组的子元素数
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childMap.get(groupPosition).size();
	}

	/**
	 * 取得与给定分组关联的数据
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return groupTitle.get(groupPosition);
	}

	/**
	 * 取得分组数
	 */
	@Override
	public int getGroupCount() {
		return groupTitle.size();
	}

	/**
	 * 取得指定分组的ID.该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}
	/*
	 *Gets a View that displays the given group
	 *return: the View corresponding to the group at the specified position
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		GroupHolder groupHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.itemgroup_doctor_online, null);
			groupHolder = new GroupHolder();
			groupHolder.groupImg = (ImageView) convertView.findViewById(R.id.img_indicator);
			groupHolder.groupText = (TextView) convertView.findViewById(R.id.tv_group_text);
			convertView.setTag(groupHolder);
		}else {
			groupHolder = (GroupHolder) convertView.getTag();
		}
		if (isExpanded) {
			groupHolder.groupImg.setBackgroundResource(R.drawable.downarrow);
		}else {
			groupHolder.groupImg.setBackgroundResource(R.drawable.rightarrow);
		}
		groupHolder.groupText.setText(groupTitle.get(groupPosition));

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// Indicates whether the child and group IDs are stable across changes to the underlying data
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// Whether the child at the specified position is selectable
		return true;
	}
	/**
	 * show the text on the child and group item
	 */
	private class GroupHolder
	{
		ImageView groupImg;
		TextView groupText;
	}
	private class ChildHolder
	{
		ImageView childImg;
		TextView childText;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			default:
				break;
		}

	}
}
