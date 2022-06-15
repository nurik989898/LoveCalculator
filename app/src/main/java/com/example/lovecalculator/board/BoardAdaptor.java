package com.example.lovecalculator.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lovecalculator.Model;
import com.example.lovecalculator.R;
import com.example.lovecalculator.databinding.ItemBoardBinding;
import com.example.lovecalculator.inteface.OnClickListener;

import java.util.ArrayList;
public class BoardAdaptor extends RecyclerView.Adapter<BoardAdaptor.ViewHolder> {
    private ArrayList<Model>list;
    private OnClickListener onClickListener;


    public BoardAdaptor(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
        list = new ArrayList<>();
        list.add(new Model("Love everyone","Believe everyone",R.raw.sayhi));
        list.add(new Model("Love everyone","Believe everyone",R.raw.lovesheep));
        list.add(new Model("Love everyone","Believe everyone",R.raw.lov1));
        list.add(new Model("Love everyone","Believe everyone",R.raw.sayhi));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBoardBinding binding;

        public ViewHolder(@NonNull ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Model model) {
            binding.textView.setText(model.getTitle());
            binding.textTitle.setText(model.getDesc());
            binding.Lotie.setAnimation(model.getImage());
            if (getAdapterPosition() == 3) {
                binding.buttonStart.setVisibility(View.VISIBLE);
            }
            binding.buttonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.itemClick();
                }
        });
        }

    }
}
