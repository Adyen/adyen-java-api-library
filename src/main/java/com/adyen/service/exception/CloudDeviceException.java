package com.adyen.service.exception;

public class CloudDeviceException extends Exception {

  public CloudDeviceException(String message) {
    super(message);
  }

  public CloudDeviceException(String message, Throwable cause) {}

  @Override
  public String toString() {
    return "CloudDeviceException{message=" + getMessage() + '}';
  }
}
