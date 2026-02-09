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

package com.adyen.terminal.security;

import java.security.cert.X509Certificate;

/** An adapter that wraps an X509Certificate to implement CertificateInfo. */
public final class X509CertificateInfo implements CertificateInfo {
  private final X509Certificate certificate;

  /**
   * Creates a new X509CertificateInfo.
   *
   * @param certificate the X509Certificate to wrap.
   */
  public X509CertificateInfo(X509Certificate certificate) {
    this.certificate = certificate;
  }

  @Override
  public String getSubjectName() {
    return certificate.getSubjectX500Principal().getName();
  }
}
