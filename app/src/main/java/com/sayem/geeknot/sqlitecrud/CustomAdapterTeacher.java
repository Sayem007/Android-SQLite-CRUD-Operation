package com.sayem.geeknot.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapterTeacher extends BaseAdapter {

    private Context context;
    private ArrayList<TeachersModel> teachersModelArrayList;

    public CustomAdapterTeacher(Context context, ArrayList<TeachersModel> teachersModelArrayList) {

        this.context = context;
        this.teachersModelArrayList = teachersModelArrayList;
    }


    @Override
    public int getCount() {
        return teachersModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return teachersModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model_teachers, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.teachers_name);
            holder.tvcourse = (TextView) convertView.findViewById(R.id.teachers_course);
            holder.tvemail = (TextView) convertView.findViewById(R.id.teachers_email);
            holder.tvphone = (TextView) convertView.findViewById(R.id.teachers_phone);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Name: "+teachersModelArrayList.get(position).getName());
        holder.tvcourse.setText("Course: "+teachersModelArrayList.get(position).getCourse());
        holder.tvemail.setText("Email: "+teachersModelArrayList.get(position).getEmail());
        holder.tvphone.setText(""+teachersModelArrayList.get(position).getPhone());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvcourse, tvemail, tvphone;
    }

}