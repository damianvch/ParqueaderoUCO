package co.com.k4soft.parqueaderouco.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.com.k4soft.parqueaderouco.persistencia.Tabla;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

//@Entity(tableName = Tabla.TARIFA)
@Data
@AllArgsConstructor
public class Tarifa {

    private int imagen;
    private String nombreTarifa;
    private double precioTarifa;

/*
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idTarifa")
    private Integer idTarifa;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "precio")
    private double precio;

 */


}
