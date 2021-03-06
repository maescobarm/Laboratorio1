package cliente;

import java.util.ArrayList;
import java.util.Scanner;
import rmi.ConexionCliente;
import rmi_interface.Interface;
import rmi_interface.InterfaceTrabajador;

/**
 *
 * @author Daniel Wladdimiro Cottet
 * @title Taller de sistemas distribuidos - Clase 1
 */

public class Cliente {

    public static int Puerto = 2014;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaRemota = "Ejemplo-RMI"; // Nombre del objeto subido
    public static String TrabajadorReferenciaRemota = "Ejemplo-RMITrabajador";

    public static void main(String[] args) {

        Interface objetoRemoto; //Se crea un nuevo objeto llamado objetoRemoto
        InterfaceTrabajador objetoRemotoTrabajador;

        //Se instancia el objeto que conecta con el servidor
        ConexionCliente conexion = new ConexionCliente();
        try {
            //Se conecta con el servidor
            if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRemota) && conexion.iniciarRegistro(IPServer, Puerto, TrabajadorReferenciaRemota)) {
                
                //Se obtiene la referencia al objeto remoto
                objetoRemoto = conexion.getServidor();
                objetoRemotoTrabajador = conexion.getTrabajadorServidor();

                int opcion = 0;
                while (opcion != 6) {

                    //Escoger alguna opción del menú
                    System.out.println("Menú RMI\n1. Ingresar un usuario al servidor\n2. Ver usuarios del servidor\n3. Eliminar un usuario\n4. Ingresar un nuevo Trabajador\n5. Listar datos trabajador\n6. Salir");
                    Scanner sc = new Scanner(System.in);
                    opcion = Integer.parseInt(sc.next());

                    if (opcion == 1) {

                        System.out.println("Ingrese el nombre del usuario: ");
                        sc = new Scanner(System.in);
                        String usuario = sc.next();

                        //Llama a un método del objeto remoto, y se le ingresa un parámetro a éste método
                        boolean ingreso = objetoRemoto.ingresarrrhh(usuario);
                        if (ingreso) {
                            System.out.println("¡Felicitaciones, ha sido agregado el usuario!");
                        } else {
                            System.out.println("Lamentablemente no ha sido ingresado el usuario, pruebe con otro nombre...");
                        }

                    } else if (opcion == 2) {
                        //Llama a un método del objeto remoto
                        ArrayList<String> usuarios = objetoRemoto.verUsuarios();

                        for (String usuario : usuarios) {
                            System.out.println("Usuario: " + usuario);
                        }
                    } else if (opcion == 3) {
                       System.out.println("Ingrese el nombre del usuario a eliminar: ");
                        sc = new Scanner(System.in);
                        String usuario = sc.next();

                        //Llama a un método del objeto remoto, y se le ingresa un parámetro a éste método
                        boolean borrado = objetoRemoto.borrarrrhh(usuario);
                        if (borrado) {
                            System.out.println("¡Felicitaciones, ha sido eliminado el usuario!");
                        } else {
                            System.out.println("Lamentablemente no ha sido eliminado el usuario, pruebe con otro nombre...");
                        }
                    } else if (opcion == 4) {
                        //Llama a un método del objeto remoto
                        boolean resp = objetoRemotoTrabajador.ingresar();

                        
                    } else if (opcion == 5) {
                        //Llama a un método del objeto remoto
                        ArrayList<String> usuarios = objetoRemoto.verUsuarios();

                        for (String usuario : usuarios) {
                            System.out.println("Usuario: " + usuario);
                        }

                    } else if (opcion != 6) {
                        System.out.println("Ingrese un número válido por favor...");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error...");
        }

        System.exit(0);
    }
}
