/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Marcelo
 */
public interface InterfaceTrabajador extends Remote {
    public boolean ingresar() throws RemoteException;
    public boolean imprimir() throws RemoteException;
}
