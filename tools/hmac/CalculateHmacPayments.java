import java.io.File;

import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.util.HMACValidator;
import com.adyen.model.notification.NotificationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 Script to calculate the HMAC signature of Payments webhooks (where the signature is calculated considering
 a subset of the fields in the payload - i.e. NotificationRequestItem object)

 Run with: mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPayments -Dexec.args= "{hmacKey} {path_to_JSON_file}"

 cd tools/hmac
 mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPayments -Dexec.args="11223344D785FBAE710E7F943F307971BB61B21281C98C9129B3D4018A57B2EB payload.json"

 */
public class CalculateHmacPayments {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("‼️Error running the script");
            System.err.println("Usage: mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPayments -Dexec.args= \"{hmacKey} {path_to_JSON_file}\"");
            System.exit(1);
        }

        String hmacKey = args[0];
        String jsonFilePath = args[1];

        try {

            HMACValidator hmacValidator = new HMACValidator();
            String content = loadFromJsonAsString(jsonFilePath);

            System.out.println("********");
            System.out.println("Payload file: " + jsonFilePath);
            System.out.println("Payload length: " + content.length());

            NotificationRequest notificationRequest = loadFromJson(jsonFilePath);
            // fetch first notificationRequestItem
            NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);

            System.out.println("********");
            String hmacSignature = hmacValidator.calculateHMAC(notificationRequestItem, hmacKey);

            System.out.println("HMAC signature: " + hmacSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load payload from JSON file
     * @param filepath
     * @return
     * @throws Exception
     */
    private static NotificationRequest loadFromJson(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filepath), NotificationRequest.class);
    }

    /**
	 * Load payload as String from JSON file
     * @param filepath
	 * @return
	 * @throws Exception
     */
    private static String loadFromJsonAsString(String filepath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }    

}
