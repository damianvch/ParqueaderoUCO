package co.com.k4soft.parqueaderouco.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.k4soft.parqueaderouco.R;
import co.com.k4soft.parqueaderouco.entidades.Tarifa;

public class TarifaAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private List<Tarifa> listaTarifasOut;
    private List<Tarifa> listaTarifasIn;


    public TarifaAdapter(Context context, List<Tarifa> listaTarifas){
        listaTarifasOut = listaTarifas;
        listaTarifasIn = listaTarifas;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listaTarifasOut.size();
    }

    @Override
    public Tarifa getItem(int position) {
        return listaTarifasOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.tarifa_item_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.imagen.setImageResource(listaTarifasOut.get(position).getImagen());
        holder.txtNombre.setText(listaTarifasOut.get(position).getNombreTarifa());
        String precio;
        holder.txtPrecio.setText(precio = new Double(listaTarifasOut.get(position).getPrecioTarifa()).toString());

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.imagen)
        ImageView imagen;
        @BindView(R.id.txtNombre)
        TextView txtNombre;
        @BindView(R.id.txtPrecio)
        TextView txtPrecio;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
