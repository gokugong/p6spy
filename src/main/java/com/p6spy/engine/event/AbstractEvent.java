package com.p6spy.engine.event;

import java.util.EventObject;

/**
 * Base class for all events generated by P6Spy
 */
public abstract class AbstractEvent extends EventObject {

  /**
   * Constructs a new event
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public AbstractEvent(Object source) {
    super(source);
  }
}
