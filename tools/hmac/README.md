## HMAC Tools

This folder contains the tools/scripts to calculate the HMAC signature of the webhook payload.  
They can be used to troubleshoot the HMAC signature calculation.

Check tools/hmac/pom.xml to confirm the Adyen Java API library version

Note: make sure you are using the HMAC key used to generate the signature associated with the payload in the JSON file

### Payments webhooks

Copy the content of the webhook in the payload.json (or provide a different file), then run with: 
`mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPayments -Dexec.args= "{hmacKey} {path_to_JSON_file}"`
```
cd tools/hmac

mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPayments -Dexec.args="11223344D785FBAE710E7F943F307971BB61B21281C98C9129B3D4018A57B2EB payload.json"
```

### Platform webhooks (AfP, Management API, etc..)

Copy the content of the webhook in the payload2.json (or provide a different file), then run with: 
`mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPlatform -Dexec.args= "{hmacKey} {path_to_JSON_file}"`
```
cd tools/hmac

mvn clean compile exec:java -Dexec.mainClass=CalculateHmacPlatform -Dexec.args="11223344D785FBAE710E7F943F307971BB61B21281C98C9129B3D4018A57B2EB payload2.json"
```