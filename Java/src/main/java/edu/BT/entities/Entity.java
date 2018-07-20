package edu.BT.entities;

import javafx.beans.property.IntegerProperty;

public abstract class Entity {
    protected String eId;
    protected IntegerProperty gravityState; //is it affected by gravity
    protected IntegerProperty xpos;
    protected IntegerProperty ypos;

}
  