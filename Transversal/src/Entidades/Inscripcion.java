package Entidades;

public class Inscripcion {
    int idInscripto;
    Alumno alumno;
    Materia materia;
    double nota;
//    int idAlumn;
//    int idMateri;
    public Inscripcion() {
    }

    public Inscripcion(int idInscripto,  double nota, Alumno alumno, Materia materia) {
        this.idInscripto = idInscripto;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
//        this.idAlumn = idAlumn;
//        this.idMateri = idMateri;
        this.idInscripto = -1;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

//        @Override
//        public String toString(){
//        
//    return "Inscripción [idInscripto=" + idInscripto + ", nota=" + nota + "]";}

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", idAlumno=" + alumno.idAlumno + ", idMateria=" + materia.idMateria + ", nota=" + nota + '}';
    }
    
}

    
    


