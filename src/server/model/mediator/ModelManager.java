package server.model.mediator;

import server.model.domain.*;

public class ModelManager implements Model
{
  private ParkingLot parkingLot;
  private DatabaseManager databaseManager;
  private Login login;

  public ModelManager()
  {
    parkingLot = new ParkingLot();
    login = new Login();
  }

  @Override public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date)
  {
    // TO BE IMPLEMENTED
  }

  @Override
  public void reserveParkingSpace(ParkingSpace parkingSpace, User user) {
    for(int i = 0; i < parkingLot.size(); i++)
    {
      if(parkingLot.getParkingSpace(i).equals(parkingSpace) && !(parkingSpace.getIsOccupied()))
      {
        parkingLot.getParkingSpace(i).setOccupied(true, user);
      }
    }
  }

  @Override
  public void reserveParkingSpace(int index, User user)
  {
    if(!parkingLot.getParkingSpace(index).getIsOccupied())
    {
      parkingLot.getParkingSpace(index).setOccupied(true, user);
    }
  }

  @Override
  public void register(String userName, String password) {
    login.register(userName,password);
  }

  @Override
  public boolean login(String userName, String password) {
    return login.isCorrectLogin(userName,password);
  }

  @Override
  public void registerFirstAndLastName(String firstName, String lastName, String username) {
    login.getUserList().getUserByUsername(username).setFirstname(firstName);
    login.getUserList().getUserByUsername(username).setLastname(lastName);
  }

  @Override
  public User getUserByUserName(String userName) {
    return login.getUserList().getUserByUsername(userName);
  }
}
