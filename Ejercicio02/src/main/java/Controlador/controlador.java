/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.modelo;
import Vista.Registro;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class controlador implements ActionListener {
 
    Registro Vista;
    modelo Modelo;
    
    public controlador(Registro Vista, modelo Modelo) {
        this.Vista = Vista;
        this.Modelo = Modelo;
        this.Vista.btn_agregar.addActionListener(this);
        this.Vista.btn_eliminartodo.addActionListener(this);
        this.Vista.btn_eliminar.addActionListener(this);
        this.Vista.btn_actualizar.addActionListener(this);
        FechaNacimiento().addPropertyChangeListener("date", evt -> calcularEdad());
    }
    
    public void iniciar(){
        Vista.setTitle("REGISTRO DE ALUMNOS");
        Vista.setSize(650, 590);
        Vista.setLocationRelativeTo(null);
}

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== Vista.btn_agregar){
            agregar(Vista.tblregistro);   
        }
        
        if(e.getSource()== Vista.btn_eliminartodo){
            elimninartodo(Vista.tblregistro);
       }
        
        if(e.getSource()== Vista.btn_eliminar){
            elimninar(Vista.tblregistro);
        }
        
        if(e.getSource()== Vista.btn_actualizar){
            actualizar(Vista.tblregistro);
        }
    }

     public void agregar(JTable tblregistro) {
        try {     
        modelo alumno = new modelo();
        alumno.setNombre(Vista.txtnombre.getText());
        alumno.setCodigo(Vista.txtcodigo.getText());
        alumno.setDireccion(Vista.txtdireccion.getText());
        alumno.setEdad(Integer.parseInt(Vista.txtedad.getText()));
        alumno.setFecha(Vista.JDC_Fecha.getDate());
        Vista.listaAlumno.add(alumno);
        Vista.refrescarTabla();
      } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR ALUMNO");
      }
        Vista.txtnombre.setText("");
        Vista.txtcodigo.setText("");
        Vista.txtdireccion.setText("");
        Vista.txtedad.setText("");
        Vista.JDC_Fecha.setDate(null);
    }

    public void elimninartodo(JTable tblregistro) {
        int eliminartbl = tblregistro.getRowCount();
       for(int i = eliminartbl-1; i >=0; i--){
         Vista.modelo.removeRow(i);
      }
    }
    
    public void elimninar(JTable tblregistro) {
        int filaselect = tblregistro.getSelectedRow();
        if(filaselect != -1){
            Vista.modelo.removeRow(filaselect);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR FILA NO SELECIONADA");
        }
      }
    
    public void actualizar(JTable tblregistro) {
        int filaselect = tblregistro.getSelectedRow();
        if(filaselect >= 0){
            Vista.txtnombre.setText(tblregistro.getValueAt(filaselect, 0).toString());
            Vista.txtcodigo.setText(tblregistro.getValueAt(filaselect, 1).toString());
            Vista.txtdireccion.setText(tblregistro.getValueAt(filaselect, 2).toString());
            Vista.txtedad.setText(tblregistro.getValueAt(filaselect, 3).toString());
            Vista.JDC_Fecha.setDate((Date) tblregistro.getValueAt(filaselect, 4));
            Vista.modelo.removeRow(filaselect);
        }
        
        else{
            
            JOptionPane.showMessageDialog(null, "SELECCIONAR CAMPO");
        }
    }
    
    public JDateChooser FechaNacimiento() {
        return Vista.JDC_Fecha;
    }
    
    public JTextField Edad() {
        return Vista.txtedad;
    }
    
  private void calcularEdad() {
        Date fechaNacimiento = FechaNacimiento().getDate();
        if (fechaNacimiento != null) {
            Date fechaActual = new Date();
            int edad = calcularEdad(fechaNacimiento, fechaActual);
            Edad().setText(String.valueOf(edad));
        }
    }

    private int calcularEdad(Date fechaNacimiento, Date fechaActual) {
        java.util.Calendar fechaNac = java.util.Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        java.util.Calendar fechaAct = java.util.Calendar.getInstance();
        fechaAct.setTime(fechaActual);
        int edad = fechaAct.get(java.util.Calendar.YEAR) - fechaNac.get(java.util.Calendar.YEAR);
        if (fechaAct.get(java.util.Calendar.DAY_OF_YEAR) < fechaNac.get(java.util.Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }
}
