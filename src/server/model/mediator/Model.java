package server.model.mediator;

import server.model.domain.*;

import java.sql.SQLException;

public interface Model
{
  void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date);
  void reserveParkingSpace(ParkingSpace parkingSpace, User user);
  void reserveParkingSpace(int index, User user);
  void register(String userName, String password) throws SQLException;
  boolean login(String userName, String password) throws SQLException;
  void registerFirstAndLastName(String firstName, String lastName, String username)
      throws SQLException;
  User getUserByUserName(String userName) throws SQLException;
  void registerVehicle(String username, String licenseNo, String color, String carBrand);
  ParkingLot getParkingLot();
}
