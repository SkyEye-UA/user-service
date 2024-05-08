package com.skyeye.skyeyeuserservice.exception;

public class NoSuchUserException extends RuntimeException{

  private static final String MESSAGE = "No such user with id %s";

  public NoSuchUserException(String id) {
    super(String.format(MESSAGE, id));
  }
}
