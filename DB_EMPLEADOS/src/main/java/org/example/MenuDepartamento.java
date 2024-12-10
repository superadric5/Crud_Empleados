package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDepartamento {

    private Scanner teclado;
    private DAODepartamento daoDepartamento;

    public MenuDepartamento() {
        this.daoDepartamento = new DAODepartamento();
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
            case 1: mostrarDepartamentos();
                break;
            case 2: insertarDepartamento();
                break;
            case 3: actualizarDepartamento();
                break;
            case 4: eliminarDepartamento();
                break;
            default: System.out.println("Opcion invalida");
                ;
        }
    }

    public void mostrarDepartamentos() {
        try {
            ArrayList<DTODepartamento> departamentos = daoDepartamento.getAllDepartamentos();
            for (int i = 0; i < departamentos.size(); i++) {
                System.out.println(departamentos.get(i).toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarDepartamento() {
        System.out.println("Indica el nombre que desea darle al departamento: ");
        String nombre = teclado.next();
        DTODepartamento dp =  new DTODepartamento(nombre);
        try{
            daoDepartamento.addDepartamento(dp);
            System.out.println("Departamento insertado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizarDepartamento() {
        System.out.println("Indica el id del departamento que desea modificar: ");
        int id = teclado.nextInt();
        System.out.println("Indica el nombre que desea ponerle: ");
        String nombre = teclado.next();
        DTODepartamento dp = new DTODepartamento(nombre);

        try {
            daoDepartamento.updateNombreDepartamento(id, dp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminarDepartamento() {
        System.out.println("Digame el id del departamento que deseas eliminar: ");
        int id = teclado.nextInt();
        try {
            daoDepartamento.deleteDepartamentoById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
