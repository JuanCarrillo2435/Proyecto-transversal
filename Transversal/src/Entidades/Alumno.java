package Entidades;

import java.time.LocalDate;

public class Alumno {
    int idAlumno;
    String apellido;
    String nombre;
    LocalDate fechaDeNacimiento;
    boolean estado;

    public Alumno() {
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaDeNacimiento, boolean estado) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public Alumno(String apellido, String nombre, LocalDate fechaDeNacimiento, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", estado=" + estado + '}';
    }
    
    
        
}
