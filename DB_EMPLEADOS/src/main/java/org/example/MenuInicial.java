package org.example;

import java.util.Scanner;

public class MenuInicial {

    private Scanner teclado;
    private MenuEmpleado menuEmpleado;
    private MenuDepartamento menuDepartamento;

    public MenuInicial() {
        teclado = new Scanner(System.in);
        menuEmpleado = new MenuEmpleado();
        menuDepartamento = new MenuDepartamento();
    }

    public void mostrarMenu() {
        System.out.println("1. Empleados");
        System.out.println("2. Departamentos");
    }

    public void selecionarMenu() {
        System.out.println("Selecione el menu al que quiere acceder");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                menuEmpleado.mostrarMenu();
                menuEmpleado.elegirOpcion();
                break;
            case 2:
                menuDepartamento.mostrarMenu();
                menuDepartamento.elegirOpcion();
                break;
        }
    }
}
