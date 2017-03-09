package com.example.gsh.recyclerviewbmob;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by gsh on 2017/3/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> mArrayList;

    public MyAdapter(List<Person> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recy_item, parent, false));
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Person person = mArrayList.get(position);

        holder.text_name.setText(person.getName());
        holder.text_age.setText(person.getAge() + "");
        holder.text_address.setText(person.getAddress());
       holder.btn_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p2 = new Person();
               ;
                p2.setObjectId(mArrayList.get(position).getObjectId());

               p2.delete(new UpdateListener() {
                   @Override
                   public void done(BmobException e) {

                   }
               });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_name;
        private TextView text_age;
        private TextView text_address;
        private Button btn_delect;

        public ViewHolder(View itemView) {
            super(itemView);

            text_name = (TextView) itemView.findViewById(R.id.tv_name);
            text_age = (TextView) itemView.findViewById(R.id.tv_age);
            text_address = (TextView) itemView.findViewById(R.id.tv_addr);
            btn_delect = (Button) itemView.findViewById(R.id.btn_delect2);
        }


    }

}
