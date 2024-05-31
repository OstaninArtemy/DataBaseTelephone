package com.mirea.kt.databasetelephone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterForPhone extends RecyclerView.Adapter<AdapterForPhone.PhoneViewHolder> {

    private List<Phone> phoneList;

    public AdapterForPhone(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = phoneList.get(position);
        holder.textViewModel.setText(phone.getModel());
        holder.textViewSerialNumber.setText(phone.getSerialNumber());
        holder.textViewPrice.setText(String.valueOf(phone.getPrice()));
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    class PhoneViewHolder extends RecyclerView.ViewHolder {
        TextView textViewModel;
        TextView textViewSerialNumber;
        TextView textViewPrice;

        PhoneViewHolder(View itemView) {
            super(itemView);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            textViewSerialNumber = itemView.findViewById(R.id.textViewSerialNumber);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
