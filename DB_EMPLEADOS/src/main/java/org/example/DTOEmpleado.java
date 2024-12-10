package org.example;

public class DTOEmpleado {
    private int id;
    private String nombre;
    private int edad;
    public int dpt_Id;

    public DTOEmpleado(String nombre, int edad, int dpt_Id) {
        this.nombre = nombre;
        this.edad = edad;
        this.dpt_Id = dpt_Id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getDpt_Id() {
        return dpt_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDpt_Id(int dpt_Id) {
        this.dpt_Id = dpt_Id;
    }

    @Override
    public String toString() {
        return "DTOEmpleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dpt_Id=" + dpt_Id +
                '}';
    }
}
