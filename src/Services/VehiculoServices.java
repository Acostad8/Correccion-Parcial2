package Services;

import Models.Camion;
import Models.Taxi;
import Models.Vehiculo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VehiculoServices {
    private Scanner sc;
    public ArrayList<Vehiculo> vehiculos;

    public VehiculoServices() {
        sc = new Scanner(System.in);
        vehiculos = new ArrayList<>();
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("---- Menú de opciones ----");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Modificar vehículo");
            System.out.println("3. Listado de vehículos");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opción del menú:");

            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next(); // Limpia la entrada inválida
                System.out.println("Por favor, ingrese una opción válida.");
                continue;
            }

            switch (opcion) {
                case 1 -> crearVehiculo();
                case 2 -> modificarVehiculo();
                case 3 -> listarVehiculos();
                case 0 -> System.out.println("Gracias por usar este menú.");
                default -> System.out.println("Por favor, ingrese una opción válida del menú.");
            }
        } while (opcion != 0);
    }

    public void crearVehiculo() {
        int opcion = 0;
        do {
            System.out.println("----- Agregar por tipo de vehículo ------");
            System.out.println("1. Taxi");
            System.out.println("2. Camión");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opción del menú:");

            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Por favor, ingrese una opción válida.");
                continue;
            }

            switch (opcion) {
                case 1 -> taxiServices();
                case 2 -> camionServices();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }

    public void modificarVehiculo() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos para modificar.");
            return;
        }

        System.out.println("Ingrese el índice del vehículo que desea modificar:");
        listarVehiculos();

        int indice = -1;
        try {
            indice = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("Por favor, ingrese un índice válido.");
            return;
        }

        if (indice < 0 || indice >= vehiculos.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }

        Vehiculo vehiculo = vehiculos.get(indice);
        if (vehiculo instanceof Taxi) {
            modificarTaxi((Taxi) vehiculo);
        } else if (vehiculo instanceof Camion) {
            modificarCamion((Camion) vehiculo);
        }
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("---- Listado de vehículos ----");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(i + ". " + vehiculos.get(i)); // Llama automáticamente al toString()
        }
        for (int i = 0; i<vehiculos.size(); i++){
            System.out.println(vehiculos.get(i));
        }
    }


    public void taxiServices() {
        System.out.println("------- TAXI -------");
        System.out.println("Ingrese la marca del vehículo:");
        String marca = sc.next();
        System.out.println("Ingrese el modelo del vehículo:");
        String modelo = sc.next();
        System.out.println("Ingrese el propietario del vehículo:");
        String propietario = sc.next();
        System.out.println("Ingrese la fecha de ingreso del vehículo:");
        String fechaIngreso = sc.next();
        System.out.println("Ingrese la tarifa por kilómetro del taxi:");
        String tarifaKm = sc.next();

        Taxi taxi = new Taxi(marca, modelo, propietario, fechaIngreso, tarifaKm);
        vehiculos.add(taxi);
        System.out.println("Taxi registrado con éxito.");
    }

    public void camionServices() {
        System.out.println("------- CAMIÓN -------");
        System.out.println("Ingrese la marca del vehículo:");
        String marca = sc.next();
        System.out.println("Ingrese el modelo del vehículo:");
        String modelo = sc.next();
        System.out.println("Ingrese el propietario del vehículo:");
        String propietario = sc.next();
        System.out.println("Ingrese la fecha de ingreso del vehículo:");
        String fechaIngreso = sc.next();
        System.out.println("Ingrese las toneladas transportadas por el camión:");
        String toneladas = sc.next();
        System.out.println("Ingrese el número de ejes del camión:");
        String numEjes = sc.next();

        Camion camion = new Camion(marca, modelo, propietario, fechaIngreso, toneladas, numEjes);
        vehiculos.add(camion);
        System.out.println("Camión registrado con éxito.");
    }

    public void modificarTaxi(Taxi taxi) {
        System.out.println("------- MODIFICAR TAXI -------");
        System.out.println("Ingrese la nueva marca del vehículo:");
        taxi.setMarca(sc.next());
        System.out.println("Ingrese el nuevo modelo del vehículo:");
        taxi.setModelo(sc.next());
        System.out.println("Ingrese el nuevo propietario del vehículo:");
        taxi.setPropietario(sc.next());
        System.out.println("Ingrese la nueva fecha de ingreso del vehículo:");
        taxi.setFechaIngreso(sc.next());
        System.out.println("Ingrese la nueva tarifa por kilómetro del taxi:");
        taxi.setTarifaKm(sc.next());

        System.out.println("Taxi modificado con éxito.");
    }

    public void modificarCamion(Camion camion) {
        System.out.println("------- MODIFICAR CAMIÓN -------");
        System.out.println("Ingrese la nueva marca del vehículo:");
        camion.setMarca(sc.next());
        System.out.println("Ingrese el nuevo modelo del vehículo:");
        camion.setModelo(sc.next());
        System.out.println("Ingrese el nuevo propietario del vehículo:");
        camion.setPropietario(sc.next());
        System.out.println("Ingrese la nueva fecha de ingreso del vehículo:");
        camion.setFechaIngreso(sc.next());
        System.out.println("Ingrese las nuevas toneladas transportadas por el camión:");
        camion.setToneladas(sc.next());
        System.out.println("Ingrese el nuevo número de ejes del camión:");
        camion.setNumEjes(sc.next());

        System.out.println("Camión modificado con éxito.");
    }
}
