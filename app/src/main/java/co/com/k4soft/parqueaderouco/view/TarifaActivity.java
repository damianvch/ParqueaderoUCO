package co.com.k4soft.parqueaderouco.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.k4soft.parqueaderouco.R;
import co.com.k4soft.parqueaderouco.adapter.TarifaAdapter;
import co.com.k4soft.parqueaderouco.entidades.Tarifa;
import co.com.k4soft.parqueaderouco.persistencia.room.DataBaseHelper;
import co.com.k4soft.parqueaderouco.utilities.ActionBarUtil;

public class TarifaActivity extends AppCompatActivity {

    private ActionBarUtil actionBarUtil;

    @BindView(R.id.listViewTarifas)
    public ListView listViewTarifas;


    public List<Tarifa> listaTarifas;
    DataBaseHelper db;


    public void goToRegistroTarifa(View view) {
        Intent intent = new Intent(this, RegistroTarifaActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa);
        ButterKnife.bind(this);
        initComponents();
        loadTarifas();

    }

    private void loadTarifas() {
        List<Tarifa>listaTarifas = new ArrayList<>();
        listaTarifas.add(new Tarifa(R.drawable.moneda,"Carro",5.000));
        listaTarifas.add(new Tarifa(R.drawable.moneda,"Moto",2.000));
        listaTarifas.add(new Tarifa(R.drawable.moneda,"Camión",10.000));

        TarifaAdapter tarifaAdapter = new TarifaAdapter(this, listaTarifas);

        listViewTarifas.setAdapter(tarifaAdapter);



        listaTarifas = db.getTarifaDAO().listar();
        if (listaTarifas.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.sin_tarifas, Toast.LENGTH_SHORT).show();
        } else {
            String[] tarifasArray = new String[listaTarifas.size()];
            for (int i = 0; i < listaTarifas.size(); i++) {
                tarifasArray[i] = listaTarifas.get(i).getNombreTarifa();
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, tarifasArray);
            listViewTarifas.setAdapter(arrayAdapter);
        }

    }


   private void initComponents() {
        db = DataBaseHelper.getDBMainThread(this);
        actionBarUtil = new ActionBarUtil(this);
        actionBarUtil.setToolBar(getString(R.string.tarifas));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onRestart() {
        super.onRestart();
        loadTarifas();
    }



}
