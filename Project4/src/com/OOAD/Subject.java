package com.OOAD;
import java.util.*;

public interface Subject{
    //passing the messages to the announcer
    public void registerObserver(Observer observer);
    //public void removeObserver(Observer observer); don't particularly need this since we won't remove Guy
    public void notifyObserver(Observer observer);
}