package com.yangyang.zhihu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yy on 16/6/28.
 * 为滑动列表编写adapter
 */
public class RecycleriewAdapter extends RecyclerView.Adapter<Myholder>{
    private LayoutInflater layoutInflater;
    private List<News> data;

    public RecycleriewAdapter(Context context ,List<News> data) {
        this.data = data;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.cardview_item,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.content.setText(data.get(position).getContent());

    }



}
class Myholder extends RecyclerView.ViewHolder{
    TextView title,content;


    public Myholder(View itemView) {
        super(itemView);
        title= (TextView) itemView.findViewById(R.id.title);
        content= (TextView) itemView.findViewById(R.id.content);
    }
}
