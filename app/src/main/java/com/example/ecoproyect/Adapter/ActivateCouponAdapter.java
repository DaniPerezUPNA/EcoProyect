package com.example.ecoproyect.Adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecoproyect.Model.ActivateCouponItem;
import com.example.ecoproyect.R;

import java.util.ArrayList;

public class ActivateCouponAdapter extends RecyclerView.Adapter<ActivateCouponAdapter.ActivateCouponItemViewHolder> {
    private ArrayList<ActivateCouponItem> arrayList;
    private Activity activity;

    public ActivateCouponAdapter(Activity activity, ArrayList<ActivateCouponItem> arrayList) {
        this.arrayList = arrayList;
        this.activity = activity;
    }

    public static class ActivateCouponItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNombre, textViewEmail, textViewNombreTienda, textViewCodigo;
        private Button btnActivar;
        public ActivateCouponItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreUsuario);
            textViewEmail = itemView.findViewById(R.id.txtEmail);
            textViewNombreTienda = itemView.findViewById(R.id.txtNombreTienda);
            textViewCodigo = itemView.findViewById(R.id.txtCodigo);
            btnActivar = itemView.findViewById(R.id.btnActivar);
        }

    }

    @NonNull
    @Override
    public ActivateCouponItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activate_coupon_item, parent, false);
        return new ActivateCouponAdapter.ActivateCouponItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivateCouponItemViewHolder holder, int position) {
        ActivateCouponItem activateCouponItem = arrayList.get(position);
        holder.textViewNombre.setText(activateCouponItem.getNombreUsuario());
        holder.textViewEmail.setText(activateCouponItem.getEmail());
        holder.textViewNombreTienda.setText(activateCouponItem.getNombreTienda());
        holder.textViewCodigo.setText(activateCouponItem.getCodigo());

        if (activateCouponItem.getCanjeable() == 0){
            holder.btnActivar.setBackgroundResource(R.drawable.btn_desactivado);
            holder.btnActivar.setText("DESACTIVADO");
        } else {
            holder.btnActivar.setBackgroundResource(R.drawable.btn_activado);
            holder.btnActivar.setText("ACTIVADO");
        }


        holder.btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.btnActivar.getBackground().getConstantState().equals(
                        ContextCompat.getDrawable(view.getContext(), R.drawable.btn_activado).getConstantState())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Desactivar cupon")
                            .setCancelable(true)
                            .setMessage("¿Estás seguro de que deseas desactivar el cupón?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    holder.btnActivar.setBackgroundResource(R.drawable.btn_desactivado);
                                    holder.btnActivar.setText("DESACTIVADO");
                                }
                            })
                            .setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Activacion cupon")
                            .setCancelable(true)
                            .setMessage("¿Estás seguro de que deseas activar el cupón?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    holder.btnActivar.setBackgroundResource(R.drawable.btn_activado);
                                    holder.btnActivar.setText("ACTIVADO");
                                }
                            })
                            .setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            }).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
