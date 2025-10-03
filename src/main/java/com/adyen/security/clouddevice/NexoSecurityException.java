/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.security.clouddevice;

public class NexoSecurityException extends Exception {
  public NexoSecurityException(String message) {
    super(message);
  }

  public NexoSecurityException(String message, Throwable cause) {
    super(message, cause);
  }

  public NexoSecurityException(Throwable cause) {
    super(cause);
  }

  @Override
  public String toString() {
    return "NexoSecurityException{message=" + getMessage() + '}';
  }
}
