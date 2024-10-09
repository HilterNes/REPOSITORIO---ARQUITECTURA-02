/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alumno;

import Controlador.controlador;
import Modelo.modelo;
import Vista.Registro;

public class Alumno {

    public static void main(String[] args) {
        
        Registro dato = new Registro();
        modelo modelo = new modelo();
        controlador ctl = new controlador(dato, modelo);
        ctl.iniciar();
        dato.setVisible(true);
        
    }
    
}
