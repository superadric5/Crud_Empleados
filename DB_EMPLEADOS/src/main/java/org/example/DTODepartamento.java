package org.example;

public class DTODepartamento {

    private int id;
    private String nombre;

    public DTODepartamento(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTODepartamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
