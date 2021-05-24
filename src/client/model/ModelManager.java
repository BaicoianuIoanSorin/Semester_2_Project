package client.model;

import client.mediator.RMIClient;
import server.model.domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ModelManager implements Model {
    private RMIClient client;
    private String userName;
    private PropertyChangeSupport support;

    public ModelManager(RMIClient client) {
        userName = "";
        this.client = client;
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void register(String userName, String password) {
        try {
            this.userName = userName;
            client.register(userName, password);
        } catch (RemoteException ignored) {

        }
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            this.userName = userName;
            return client.login(userName, password);
        } catch (RemoteException | SQLException ignored) {

        }
        return false;
    }

    @Override
    public void registerFirstAndLastName(String firstName, String lastName, String userName) {
        try {
            
            client.registerFirstAndLastName(firstName, lastName, userName);
        } catch (RemoteException | SQLException e) {

        }
    }

    @Override
    public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException {
        client.registerSpace(username, parkingSpace, time, date);
    }

    @Override
    public User getUserByUserName() throws RemoteException, SQLException
    {
        return client.getUserByUserName(userName);
    }

    @Override
    public void registerVehicle(String licenseNo,
                                String color, String carBrand) throws RemoteException {
        client.registerVehicle(userName, licenseNo, color, carBrand);
    }

    @Override
    public ParkingLot getParkingLot() throws RemoteException {
        return client.getParkingLot();
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void setNameSpace(String name) {
        support.firePropertyChange(name,null,1);
    }


}
