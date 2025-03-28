import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import org.json.JSONObject;

public class CalculateHmacPayments {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java CalculateHmacPayments <hmacKey> <payloadFile>");
            System.exit(1);
        }

        String hmacKey = args[0];
        String jsonFilePath = args[1];

        try {
            // Read the JSON payload from the file
            String payload = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Parse the JSON payload
            JSONObject jsonObject = new JSONObject(payload);

            // Compute the HMAC signature
            String dataToSign = getDataToSign(jsonObject);
            String computedHmac = calculateHmac(dataToSign, hmacKey);

            // Output the computed HMAC signature
            System.out.println("Computed HMAC: " + computedHmac);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDataToSign(JSONObject jsonObject) {
        // Example: Sign specific fields from JSON
        StringBuilder data = new StringBuilder();
        data.append(jsonObject.optString("pspReference", ""));
        data.append(jsonObject.optString("originalReference", ""));
        data.append(jsonObject.optString("merchantAccountCode", ""));
        data.append(jsonObject.optString("merchantReference", ""));
        data.append(jsonObject.optJSONObject("amount").optString("value", ""));
        data.append(jsonObject.optJSONObject("amount").optString("currency", ""));
        data.append(jsonObject.optString("eventCode", ""));
        data.append(jsonObject.optString("success", ""));
        return data.toString();
    }

    private static String calculateHmac(String data, String hmacKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(hmacKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}
