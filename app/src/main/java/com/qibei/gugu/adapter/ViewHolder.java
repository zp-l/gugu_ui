package com.qibei.gugu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 构造一个通用的viewholder类
 *
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    //layoutId即我们要引入的item布局文件的id
    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position)
    {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);//引入我们的item布局文件
        mConvertView.setTag(this);
    }
    //ViewHolder并不是每次都需要实例化，当convertview不为空时我们就不需要再实例化ViewHolder，因此我们增加一个入口方法
    //来判断是否需要对ViewHolder实例化
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);//返回一个实例化对象
        }
        else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过viewId获取控件,此方法返回的是View的一个子类
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null) {
            //如果mViews没有相应的控件，我们就从convertView中找到这个控件，并将此控件和其id存放在mViews中
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    //mConvertView的get方法
    public View getConvertView() {
        return mConvertView;
    }
    /**
     * 找到我们定义的TextView控件，并给控件赋值
     */
    public ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 如果item中有ImageView控件的话，我们就可以用此方法给控件设置图片资源
     */
    public ViewHolder setImageResource(int viewId, int resId)
    {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }
    //我们还可以添加其他的更多的方法。。。。。。。。。。。
    /**
     * 找到我们定义的TextView控件，并给控件赋值
     */
    public ViewHolder setColor(int viewId, int color)
    {
        TextView tv = getView(viewId);
        tv.setTextColor(color);
        return this;
    }
}
