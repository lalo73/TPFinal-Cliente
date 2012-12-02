package interfaces;

import java.util.Calendar;

import client.Client;
import exceptions.NoLoggedUserException;

public interface IEvent {
  public boolean valid(Calendar d);
  public void run(Client c) throws NoLoggedUserException;
}
