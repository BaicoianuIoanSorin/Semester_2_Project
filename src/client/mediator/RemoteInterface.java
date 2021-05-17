package client.mediator;

import server.model.domain.ParkingSpace;
import server.model.domain.Vehicle;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote
{
  void login(String username, String password) throws RemoteException;
  void register(String username, String password) throws RemoteException;
  void registerSpace(String username, Vehicle vehicle, ParkingSpace parkingSpace) throws RemoteException;
}