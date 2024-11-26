
package pruebasemana8;

import java.util.Scanner;


public class PruebaSemana8 {
    
        
      public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        
        int[][] preciosDia = {
                {80, 100, 120, 10},  // Lunes
                {85, 95, 110, 10},   // Martes
                {90, 105, 135, 10},  // Miércoles
                {88, 99, 129, 10},   // Jueves
                {79, 95, 115, 10},   // Viernes
                {86, 100, 125, 10},  // Sábado
                {95, 110, 140, 10}   // Domingo
        };

        System.out.println("Seleccione el día de la semana:");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miércoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sábado");
        System.out.println("7. Domingo");
        int dia = entrada.nextInt();

        if (dia < 1 || dia > 7) {
            System.out.println("Día no válido. Fin del programa.");
            return;
        }

   
        int[] preciosDelDia = preciosDia[dia - 1];
        int precioEconomica = preciosDelDia[0];
        int precioRegular = preciosDelDia[1];
        int precioPremium = preciosDelDia[2];
        int precioComplemento = preciosDelDia[3];

        System.out.printf("Precios para el día seleccionado:\nEconómica: %d\nRegular: %d\nPremium: %d\nComplementos: %d\n\n",
                precioEconomica, precioRegular, precioPremium, precioComplemento);

        
        GestionPedidos gestionPedidos = new GestionPedidos(precioEconomica, precioRegular, precioPremium, precioComplemento);

        int opcion;
        do {
            System.out.println("Menú del sistema:");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Mostrar total de ventas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    gestionPedidos.registrarPedido();
                    break;
                case 2:
                    gestionPedidos.mostrarVentas();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

          System.exit(0);
      }
}


class GestionPedidos {
    public  double pEconomica;
    public  double pRegular;
    public  double pPremium;
    public  double precioComplemento;
    public  double totalVentas;

    public GestionPedidos(double precioEconomica, double precioRegular, double precioPremium, double precioComplemento) {
        this.pEconomica = precioEconomica;
        this.pRegular = precioRegular;
        this.pPremium = precioPremium;
        this.precioComplemento = precioComplemento;
        this.totalVentas = 0;
    }

    public void registrarPedido() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente:");
        String cliente = entrada.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccion = entrada.nextLine();

        System.out.println("Ingrese el número de teléfono del cliente:");
        String telefono = entrada.nextLine();

        System.out.println("Seleccione el tipo de comida:");
        System.out.println("1. Económica");
        System.out.println("2. Regular");
        System.out.println("3. Premium");
        int comida = entrada.nextInt();

        System.out.println("Ingrese la cantidad de complementos:");
        int complementos = entrada.nextInt();

        System.out.println("Seleccione el tipo de cliente:");
        System.out.println("1. Normal");
        System.out.println("2. Frecuente (15% descuento)");
        System.out.println("3. Tercera edad (25% descuento)");
        int tcliente = entrada.nextInt();

        double cComida = 0;

        switch (comida) {
            case 1:
                cComida = pEconomica;
                break;
            case 2:
                cComida = pRegular;
                break;
            case 3:
                cComida = pPremium;
                break;
            default:
                System.out.println("Tipo de comida no válido.");
                return;
        }

        double cComplementos = complementos * precioComplemento;
        double total = cComida + cComplementos;

        
        switch (tcliente) {
            case 2:
                total *= 0.85;
                break;
            case 3: 
                total *= 0.75;
                break;
            case 1:
                break; 
            default:
                System.out.println("Cliente no válido");
        }

        totalVentas += total;

        System.out.printf("Pedido registrado. Total a pagar: ", total);
    }

    public void mostrarVentas() {
        System.out.printf("Total de ventas del día: ", totalVentas);
    }
}
