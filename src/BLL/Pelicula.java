package BLL;


import DLL.PeliculaDAL;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernan
 */
public class Pelicula {
    
    private String codigo;
    private String nombre;
    private String categoria;
    private int diasPrestamo;
    private String formato;
    private Timestamp fechaIngreso;

    public Pelicula() {
    }

    public Pelicula(String codigo, String nombre, String categoria, int diasPrestamo, String formato) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.diasPrestamo = diasPrestamo;
        this.formato = formato;
        //this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public String guardar(String codigo,String nombre,String categoria,int prestamo,String formato){
        
        try {
            
            Pelicula p = new Pelicula(codigo,nombre,categoria,prestamo,formato);
            int resultado;
            p.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
            resultado = new PeliculaDAL().guardar(p);
            
            if (resultado == 1) {
                return "ingresado";
            }
            if (resultado == -1) {
                return "movil ya ingresado";
            }
            else {
                return "movil no ingresado";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
     
    }
    
    
}
