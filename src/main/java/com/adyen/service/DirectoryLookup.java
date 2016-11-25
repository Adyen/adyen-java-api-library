package com.adyen.service;

import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

public class DirectoryLookup {

	private final static String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	private final static Charset C_UTF8 = Charset.forName("UTF8");
	private byte[] hmacKey;
	private Calendar calendar = Calendar.getInstance();
	private SortedMap<String, String> params = new TreeMap();
	private String merchantAccount;
	private String currencyCode;
	private String paymentAmount;
	private String sessionValidity;
	private String merchantReference;
	private String skinCode;
	private String countryCode;

	private DirectoryLookup(PaymentFieldBuilder PaymentFieldBuilder) {
		this.merchantAccount = PaymentFieldBuilder.merchantAccount;
		this.skinCode = PaymentFieldBuilder.skinCode;
		this.hmacKey = PaymentFieldBuilder.hmacKey;
		this.countryCode = PaymentFieldBuilder.countryCode;
		this.currencyCode = PaymentFieldBuilder.currencyCode;
		this.paymentAmount = PaymentFieldBuilder.paymentAmount == null || PaymentFieldBuilder.paymentAmount.isEmpty()
				? "199" : PaymentFieldBuilder.paymentAmount;
		this.sessionValidity = PaymentFieldBuilder.sessionValidity == null
				|| PaymentFieldBuilder.sessionValidity.isEmpty()
						? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(getSessionDate())
						: PaymentFieldBuilder.sessionValidity;
		this.merchantReference = PaymentFieldBuilder.merchantReference == null
				|| PaymentFieldBuilder.merchantReference.isEmpty()
						? "TEST-PAYMENT-" + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(getCurrentDate())
						: PaymentFieldBuilder.merchantReference;
	}

	Date getCurrentDate() {
		Date currentDate = calendar.getTime(); // current date
		return currentDate;
	}

	Date getSessionDate() {
		Date sessionDate = calendar.getTime(); // current date + 1 day
		calendar.add(Calendar.DATE, 2);
		return sessionDate;
	}

	void setAndOrderParameters() {
		params.put("merchantAccount", merchantAccount);
		params.put("currencyCode", currencyCode);
		params.put("paymentAmount", paymentAmount);
		params.put("sessionValidity", sessionValidity);
		params.put("merchantReference", merchantReference);
		params.put("skinCode", skinCode);
		params.put("countryCode", countryCode);
	}

//	String getSigningString() {
//		setAndOrderParameters();
//		String signingData = Stream.concat(params.keySet().stream(), params.values().stream())
//				.map(signingTest -> escapeVal(signingTest)).collect(Collectors.joining(":"));
//		return signingData;
//	}

//	void setMerchantsignature() {
//		try {
//			params.put("merchantSig", calculateHMAC(getSigningString(), hmacKey));
//		} catch (SignatureException e) {
//			e.printStackTrace();
//			return;
//		}
//	}

	public SortedMap<String, String> getHppFieldsToFoward() {
//		setAndOrderParameters();
//		setMerchantsignature();
		return params;
	}

	// To escape embedded "\" characters as "\\", and embedded ":" as "\:".
	private static String escapeVal(String val) {
		if (val == null) {
			return "";
		}
		return val.replace("\\", "\\\\").replace(":", "\\:");
	}

	// To calculate the HMAC SHA-256
	private static String calculateHMAC(String data, byte[] key) throws java.security.SignatureException {
		try {

			// Create an hmac_sha256 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA256_ALGORITHM);

			// Get an hmac_sha256 Mac instance and initialize with the signing
			// key
			Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);

			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(data.getBytes(C_UTF8));

			// Base64-encode the hmac
			return BaseEncoding.base64().encode(rawHmac);

		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
	}

	public static void main(String[] args) {

		DirectoryLookup directoryLookup = new DirectoryLookup.PaymentFieldBuilder("MarcoBurgos", "g6yYygGD",
				"35C0D462A6980F69A4CC1E1AA0338BB6F2EA2C5852DE9EDCE51D328069869706", "GB", "GBP").build();
		System.out.println(directoryLookup.getHppFieldsToFoward());

	}

	public static class PaymentFieldBuilder {

		private byte[] hmacKey;

		private String merchantAccount;
		private String currencyCode;
		private String paymentAmount;
		private String sessionValidity;
		private String merchantReference;
		private String skinCode;
		private String countryCode;

		PaymentFieldBuilder(String merchantAccount, String skinCode, String hmacKey, String countryCode,
				String currencyCode) {
			this.merchantAccount = merchantAccount;
			this.skinCode = skinCode;
//			this.hmacKey = BaseEncoding.base16().decode(hmacKey);
			this.countryCode = countryCode == null || countryCode.isEmpty() ? "NL" : countryCode;
			this.currencyCode = currencyCode == null || currencyCode.isEmpty() ? "EUR" : currencyCode;
		}

		public PaymentFieldBuilder setPaymentAmount(String paymentAmount) {
			this.paymentAmount = paymentAmount;
			return this;
		}

		public PaymentFieldBuilder setMerchantReference(String merchantReference) {
			this.merchantReference = merchantReference;
			return this;
		}

		public PaymentFieldBuilder setSessionValidity(String sessionValidity) {
			this.sessionValidity = sessionValidity;
			return this;
		}

		public DirectoryLookup build() {
			return new DirectoryLookup(this);
		}

	}

	
}