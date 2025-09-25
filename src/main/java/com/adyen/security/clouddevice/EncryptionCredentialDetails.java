package com.adyen.security.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details of the encryption credential used for encrypting the request payload (nexoBlob)
 */
public class EncryptionCredentialDetails {

	/**
	 * The passphrase used to derive the encryption key.
	 */
	@JsonProperty("Passphrase")
	private String passphrase;

	/**
	 * The unique identifier of the key.
	 */
	@JsonProperty("KeyIdentifier")
	private String keyIdentifier;

	/**
	 * The version of the key.
	 */
	@JsonProperty("KeyVersion")
	private Integer keyVersion;

	/**
	 * The version of the Adyen-specific crypto implementation.
	 */
	@JsonProperty("AdyenCryptoVersion")
	private Integer adyenCryptoVersion;


	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getKeyIdentifier() {
		return keyIdentifier;
	}

	public void setKeyIdentifier(String keyIdentifier) {
		this.keyIdentifier = keyIdentifier;
	}

	public Integer getKeyVersion() {
		return keyVersion;
	}

	public void setKeyVersion(Integer keyVersion) {
		this.keyVersion = keyVersion;
	}

	public Integer getAdyenCryptoVersion() {
		return adyenCryptoVersion;
	}

	public void setAdyenCryptoVersion(Integer adyenCryptoVersion) {
		this.adyenCryptoVersion = adyenCryptoVersion;
	}
}
