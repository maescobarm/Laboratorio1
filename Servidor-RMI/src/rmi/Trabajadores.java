package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi_interface.InterfaceTrabajador;

public class Trabajadores extends UnicastRemoteObject implements InterfaceTrabajador{
    
    static String rut;
    static String nombre;
    static Integer edad;
    static String cargo;
    static Integer sueldo;
    
    public Trabajadores() throws RemoteException{
        rut = new String();
        nombre = new String();
        cargo = new String();
        
    }
    
    @Override
    public boolean ingresar() throws RemoteException{
        System.out.print("Ingreso de nuevo trabajador.\nRut: ");
        Scanner sc = new Scanner(System.in);
        String rut = sc.next();
        System.out.print("Nombre: ");
        nombre=sc.next();
        return true;
    }
    @Override
    public boolean imprimir() throws RemoteException{
        System.out.println("Nombre: "+nombre);
        System.out.println("Rut: "+rut);
        return true;
    }
}
