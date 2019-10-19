/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadb;

import java.util.ArrayList;

/**
 *
 * @author Walter
 */
public class Alumno extends Persona {
    private int id_alumno;
    private int nroregistro;
    private int ingreso;
    private String carrera;
    private ArrayList<Materia> materias;
    
    public Alumno(int id, String nombre, String apellido, String dni, String mail, String telefono) {
        super(id, nombre, apellido, dni, mail, telefono);
    }

    public Alumno(int id_alumno, int nroregistro, int ingreso, String carrera, int id, String nombre, String apellido, String dni, String mail, String telefono) {
        super(id, nombre, apellido, dni, mail, telefono);
        this.id_alumno = id_alumno;
        this.nroregistro = nroregistro;
        this.ingreso = ingreso;
        this.carrera = carrera;
    }
    
    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getNroregistro() {
        return nroregistro;
    }

    public void setNroregistro(int nroregistro) {
        this.nroregistro = nroregistro;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    
    
    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", nroregistro=" + nroregistro + ", ingreso=" + ingreso + ", carrera=" + carrera + '}';
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
    
    public void inscribir(Materia m){
        this.materias.add(m);
    }
    
}
