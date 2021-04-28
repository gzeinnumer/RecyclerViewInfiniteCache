package com.gzeinnumer.recyclerviewinfinitecache;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gzeinnumer.recyclerviewinfinitecache.databinding.RvItemBinding;

import java.util.ArrayList;

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.MyHolder> {

    private ArrayList<String> list;
    private final ArrayList<DummyAdapter.MyHolder> holders;

    public DummyAdapter(ArrayList<String> list) {
        this.list = new ArrayList<>(list);
        this.holders = new ArrayList<>(list.size());
        initHolders();
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
        initHolders();
        notifyDataSetChanged();
    }

    private void initHolders() {
        for (int i = 0; i < list.size(); i++) {
            holders.add(null);
        }
    }

    public ArrayList<MyHolder> getHolders() {
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holders.set(position, holder);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(RvItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public RvItemBinding binding;

        public MyHolder(@NonNull RvItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
