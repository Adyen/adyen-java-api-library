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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.security.clouddevice;

/** Exception thrown when an error occurs during Nexo message encryption or decryption. */
public class NexoSecurityException extends Exception {

  /**
   * @param message the detail message
   */
  public NexoSecurityException(String message) {
    super(message);
  }

  /**
   * @param message the detail message
   * @param cause the cause
   */
  public NexoSecurityException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @param cause the cause
   */
  public NexoSecurityException(Throwable cause) {
    super(cause);
  }
}
