openapi-generator-version:=6.0.1
openapi-generator-url:=https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/$(openapi-generator-version)/openapi-generator-cli-$(openapi-generator-version).jar
openapi-generator-jar:=target/openapi-generator-cli.jar
openapi-generator-cli:=java -jar $(openapi-generator-jar)

generator:=java
library:=okhttp-gson
modelGen:=balanceplatform binlookup checkout legalentitymanagement management payments payout recurring transfers
models:=src/main/java/com/adyen/model
output:=target/out

# Generate models (for each service)
models: $(modelGen)

balancecontrol: spec=BalanceControlService-v1
balancecontrol: smallServiceName=BalanceControlApi
binlookup: spec=BinLookupService-v54
binlookup: smallServiceName=BinLookupApi
checkout: spec=CheckoutService-v70
dataprotection: spec=DataProtectionService-v1
dataprotection: smallServiceName=DataProtectionApi
storedvalue: spec=StoredValueService-v46
storedvalue: smallServiceName=StoredValueApi
posterminalmanagement: spec=TfmAPIService-v1
posterminalmanagement: smallServiceName=PosTerminalManagementApi
payments: spec=PaymentService-v68
recurring: spec=RecurringService-v68
recurring: smallServiceName=RecurringApi
payout: spec=PayoutService-v68
management: spec=ManagementService-v1
balanceplatform: spec=BalancePlatformService-v2
transfers: spec=TransferService-v3
legalentitymanagement: spec=LegalEntityService-v2
# Classic Platforms
marketpay/account: spec=AccountService-v6
marketpay/fund: spec=FundService-v6
marketpay/configuration: spec=NotificationConfigurationService-v6
marketpay/webhooks: spec=MarketPayNotificationService-v6
hop: spec=HopService-v6

$(services): target/spec $(openapi-generator-jar)
	rm -rf $(models)/$@ $(output)
	$(openapi-generator-cli) generate \
		-i target/spec/json/$(spec).json \
		-g $(generator) \
		-t templates \
		-o $(output) \
		--reserved-words-mappings configuration=configuration \
		--ignore-file-override ./.openapi-generator-ignore \
		--skip-validate-spec \
		--model-package $(subst /,.,com.adyen.model.$@) \
		--library $(library) \
		--global-property modelDocs=false \
		--global-property modelTests=false \
		--additional-properties=dateLibrary=java8 \
		--additional-properties=serializationLibrary=gson \
		--additional-properties=openApiNullable=false \
		--additional-properties=resourceClass=$(resourceClass)Resource
	mv $(output)/$(models)/$@ $(models)/$@
	mv $(output)/$(models)/JSON.java $(models)/$@

# Full service + models automation
bigServices:=balanceplatform checkout storedValue payments payout management legalentitymanagement transfers
singleFileServices:=balancecontrol binlookup dataprotection storedvalue posterminalmanagement recurring

services: $(bigServices) $(singleFileServices)

$(bigServices): target/spec $(openapi-generator-jar)
	rm -rf $(models)/$@ $(output)
	rm -rf src/main/java/com/adyen/service/$@ $(output)
	$(openapi-generator-cli) generate \
		-i target/spec/json/$(spec).json \
		-g $(generator) \
		-t templates \
		-o $(output) \
		--reserved-words-mappings configuration=configuration \
		--ignore-file-override ./.openapi-generator-ignore \
		--skip-validate-spec \
		--model-package $(subst /,.,com.adyen.model.$@) \
		--library $(library) \
		--api-package com.adyen.service.$@ \
		--api-name-suffix Api \
		--global-property modelDocs=false \
		--global-property modelTests=false \
		--additional-properties=dateLibrary=java8 \
		--additional-properties=serializationLibrary=gson \
		--additional-properties=openApiNullable=false
	mv $(output)/$(models)/$@ $(models)/$@
	mv $(output)/src/main/java/com/adyen/service/JSON.java $(models)/$@
	mv $(output)/src/main/java/com/adyen/service/$@ src/main/java/com/adyen/service/$@

$(singleFileServices): target/spec $(openapi-generator-jar)
	rm -rf $(models)/$@ $(output)
	rm -rf src/main/java/com/adyen/service/$@ $(output)
	$(openapi-generator-cli) generate \
		-i target/spec/json/$(spec).json \
		-g $(generator) \
		-c templates/libraries/okhttp-gson/config.yaml \
		-o $(output) \
		--reserved-words-mappings configuration=configuration \
		--ignore-file-override ./.openapi-generator-ignore \
		--skip-validate-spec \
		--model-package $(subst /,.,com.adyen.model.$@) \
		--library $(library) \
		--additional-properties customApi=$@ \
		--api-package com.adyen.service \
        --api-name-suffix Api \
		--global-property modelDocs=false \
		--global-property modelTests=false \
		--additional-properties=dateLibrary=java8 \
		--additional-properties=serializationLibrary=gson \
		--additional-properties=openApiNullable=false \
		--additional-properties=smallServiceName=$(smallServiceName)
	mv $(output)/$(models)/$@ $(models)/$@
	mv $(output)/src/main/java/com/adyen/JSON.java $(models)/$@
	mv $(output)/src/main/java/com/adyen/service/*Single.java src/main/java/com/adyen/service/$(smallServiceName).java


# Checkout spec (and patch version)
target/spec:
	git clone https://github.com/Adyen/adyen-openapi.git target/spec
	perl -i -pe's/"openapi" : "3.[0-9].[0-9]"/"openapi" : "3.0.0"/' target/spec/json/*.json


# Extract templates (copy them for modifications)
templates: $(openapi-generator-jar)
	$(openapi-generator-cli) author template -g $(generator) --library $(library) -o target/templates


# Download the generator
$(openapi-generator-jar):
	wget --quiet -o /dev/null $(openapi-generator-url) -O $(openapi-generator-jar)


# Discard generated artifacts and changed models
clean:
	rm -rf $(output)
	git checkout $(models)
	git clean -f -d $(models)


.PHONY: templates models $(services)
