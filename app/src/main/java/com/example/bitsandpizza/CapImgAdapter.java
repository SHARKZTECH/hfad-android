package com.example.bitsandpizza;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CapImgAdapter extends RecyclerView.Adapter<CapImgAdapter.MyViewHolder> {
    List<Pizza> pizzaList;

    public CapImgAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public CapImgAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cap_img,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CapImgAdapter.MyViewHolder holder, int position) {
        CardView cardView=holder.cardView;

        holder.img.setImageResource(pizzaList.get(position).getImgId());
        holder.txt.setText(pizzaList.get(position).getName());

        cardView.setOnClickListener(view -> {
            Intent intent=new Intent(cardView.getContext(),DetailsActivity.class);
            intent.putExtra(DetailsActivity.EXTRA_PIZZA_ID,position);
            cardView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.info_image);
            txt=itemView.findViewById(R.id.info_text);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }

}
