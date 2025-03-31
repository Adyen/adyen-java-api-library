import java.io.File;

import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.util.HMACValidator;
import com.adyen.model.notification.NotificationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CalculateHmacPayments {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("‼️Error running the script");
            System.err.println("Usage: java CalculateHmacPayments <hmacKey> <payloadFile>");
            System.exit(1);
        }

        String hmacKey = args[0];
        String jsonFilePath = args[1];

        System.out.println("Calculating HMAC signature with payload from " + jsonFilePath);

        try {

            HMACValidator hmacValidator = new HMACValidator();

            NotificationRequest notificationRequest = loadFromJson(jsonFilePath);
            // fetch first notificationRequestItem
            NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);

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

}
