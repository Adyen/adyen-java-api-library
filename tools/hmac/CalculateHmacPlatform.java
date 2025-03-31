import com.adyen.util.HMACValidator;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 Script to calculate the HMAC signature of Payments webhooks Banking/Management webhooks (where the signature is calculated
 over the entire webhook payload)

 Run with: mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPlatform -Dexec.args= "{hmacKey} {path_to_JSON_file}"

 cd tools/hmac
 mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPlatform -Dexec.args="11223344D785FBAE710E7F943F307971BB61B21281C98C9129B3D4018A57B2EB payload2.json"

 */
public class CalculateHmacPlatform {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("‼️Error running the script");
            System.err.println("Usage: java CalculateHmacPlatform <hmacKey> <payloadFile>");
            System.exit(1);
        }

        String hmacKey = args[0];
        String jsonFilePath = args[1];

        System.out.println("Calculating HMAC signature with payload from " + jsonFilePath);

        try {

            HMACValidator hmacValidator = new HMACValidator();

            String data = loadFromJson(jsonFilePath);

            String hmacSignature = hmacValidator.calculateHMAC(data, hmacKey);

            System.out.println("HMAC signature: " + hmacSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
	 * Load payload as String from JSON file
     * @param filepath
	 * @return
	 * @throws Exception
     */
    private static String loadFromJson(String filepath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}
