package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuEmpleado {

    private Scanner teclado;
    private DAOEmpleado daoEmpleado;

    public MenuEmpleado() {
        this.daoEmpleado = new DAOEmpleado();
        this.teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("-----MENU-----");
        System.out.println("1.Mostrar");
        System.out.println("2.Insertar");
        System.out.println("3.Actualizar");
        System.out.println("4.Eliminar");
    }

    public void elegirOpcion() {
        int opcion;
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1: mostrarEmpleados();
                break;
            case 2: insertarEmpleado();
                break;
            case 3: actualizarEmpleado();
                break;
            case 4: eliminarEmpleado();
                break;
            default: System.out.println("Opcion invalida");
                ;
        }
    }


    public void mostrarEmpleados() {
        try {
            ArrayList<DTOEmpleado> empleados = daoEmpleado.getAll();
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println(empleados.get(i).toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarEmpleado() {
        System.out.println("Indica su nombre: ");
        String nombre = teclado.next();
        System.out.println("Indica su edad: ");
        int edad = teclado.nextInt();
        System.out.println("Indica su departamento: ");
        int departamento = teclado.nextInt();
        DTOEmpleado emp =  new DTOEmpleado(nombre, edad, departamento);
        try{
            daoEmpleado.addEmpleado(emp);
            System.out.println("Empleado insertado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizarEmpleado() {
        System.out.println("Indica el id del empleado que desea modificar: ");
        int id = teclado.nextInt();
        System.out.println("Indica el nombre que desea ponerle: ");
        String nombre = teclado.next();
        System.out.println("Indica la edad: ");
        int edad = teclado.nextInt();
        System.out.println("Indica su departamento: ");
        int departamento = teclado.nextInt();
        DTOEmpleado emp = new DTOEmpleado(nombre, edad, departamento);

        try {
            daoEmpleado.updateNombreEmpleado(id, emp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminarEmpleado() {
        System.out.println("Digame el id del empleado que deseas eliminar: ");
        int id = teclado.nextInt();
        try {
            daoEmpleado.deleteEmpleadoById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

