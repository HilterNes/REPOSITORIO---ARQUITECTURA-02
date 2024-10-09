/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author HILTER
 */
public class modelo {
    String nombre;
    String direccion;
    String Codigo;
    Date Fecha;
    int edad;

    public modelo() {
    }

    public modelo(String nombre, String direccion, String Codigo, Date Fecha, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.Codigo = Codigo;
        this.Fecha = Fecha;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "modelo{" + "nombre=" + nombre + ", direccion=" + direccion + ", Codigo=" + Codigo + ", Fecha=" + Fecha + ", edad=" + edad + '}';
    }
    
}
