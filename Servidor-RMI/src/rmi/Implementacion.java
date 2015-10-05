package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi_interface.Interface;

public class Implementacion extends UnicastRemoteObject implements Interface {
    
    static ArrayList<String> usuarios;
    static ArrayList<String> rrhh;   
    static ArrayList<String> finanzas;
    
    static Logger logger;

    public Implementacion() throws RemoteException {
        logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de Implementacion del Servidor");
        usuarios = new ArrayList<>();
        rrhh = new ArrayList<>();
        finanzas = new ArrayList<>();
    }

    /*
     * Debo escribir todos los métodos que se encuentran en la interface
     */
    // Por cada metodo se escribe Override que se utiliza para que utilize este metodo en vez del metodo del padre
    @Override
    public boolean borrarrrhh(String usuario) throws RemoteException {
        logger.log(Level.INFO, "Se desea eliminar un usuario al servidor");
        if(rrhh.contains(usuario)){
            rrhh.remove(usuario);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean ingresarrrhh(String usuario) throws RemoteException {
        logger.log(Level.INFO, "Se desea ingresar un usuario al servidor");
        if(!rrhh.contains(usuario)){
            rrhh.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<String> verUsuarios() throws RemoteException {
        logger.log(Level.INFO, "Se desea ver los usuarios del servidor");
        return rrhh;
    }

}
