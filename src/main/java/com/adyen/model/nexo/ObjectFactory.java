
package com.adyen.model.nexo;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.adyen.model.nexo package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName CARD_READER_INIT_REQUEST_FORCE_ENTRY_MODE_QNAME = new QName("", "ForceEntryMode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.adyen.model.nexo
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaleToPOIRequest }
     */
    public SaleToPOIRequest createSaleToPOIRequest() {
        return new SaleToPOIRequest();
    }

    /**
     * Create an instance of {@link MessageHeader }
     */
    public MessageHeader createMessageHeader() {
        return new MessageHeader();
    }

    /**
     * Create an instance of {@link AbortRequest }
     */
    public AbortRequest createAbortRequest() {
        return new AbortRequest();
    }

    /**
     * Create an instance of {@link BalanceInquiryRequest }
     */
    public BalanceInquiryRequest createBalanceInquiryRequest() {
        return new BalanceInquiryRequest();
    }

    /**
     * Create an instance of {@link BatchRequest }
     */
    public BatchRequest createBatchRequest() {
        return new BatchRequest();
    }

    /**
     * Create an instance of {@link CardAcquisitionRequest }
     */
    public CardAcquisitionRequest createCardAcquisitionRequest() {
        return new CardAcquisitionRequest();
    }

    /**
     * Create an instance of {@link AdminRequest }
     */
    public AdminRequest createAdminRequest() {
        return new AdminRequest();
    }

    /**
     * Create an instance of {@link DiagnosisRequest }
     */
    public DiagnosisRequest createDiagnosisRequest() {
        return new DiagnosisRequest();
    }

    /**
     * Create an instance of {@link DisplayRequest }
     */
    public DisplayRequest createDisplayRequest() {
        return new DisplayRequest();
    }

    /**
     * Create an instance of {@link EnableServiceRequest }
     */
    public EnableServiceRequest createEnableServiceRequest() {
        return new EnableServiceRequest();
    }

    /**
     * Create an instance of {@link EventNotification }
     */
    public EventNotification createEventNotification() {
        return new EventNotification();
    }

    /**
     * Create an instance of {@link GetTotalsRequest }
     */
    public GetTotalsRequest createGetTotalsRequest() {
        return new GetTotalsRequest();
    }

    /**
     * Create an instance of {@link InputRequest }
     */
    public InputRequest createInputRequest() {
        return new InputRequest();
    }

    /**
     * Create an instance of {@link InputUpdate }
     */
    public InputUpdate createInputUpdate() {
        return new InputUpdate();
    }

    /**
     * Create an instance of {@link LoginRequest }
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    /**
     * Create an instance of {@link LogoutRequest }
     */
    public LogoutRequest createLogoutRequest() {
        return new LogoutRequest();
    }

    /**
     * Create an instance of {@link LoyaltyRequest }
     */
    public LoyaltyRequest createLoyaltyRequest() {
        return new LoyaltyRequest();
    }

    /**
     * Create an instance of {@link PaymentRequest }
     */
    public PaymentRequest createPaymentRequest() {
        return new PaymentRequest();
    }

    /**
     * Create an instance of {@link PINRequest }
     */
    public PINRequest createPINRequest() {
        return new PINRequest();
    }

    /**
     * Create an instance of {@link PrintRequest }
     */
    public PrintRequest createPrintRequest() {
        return new PrintRequest();
    }

    /**
     * Create an instance of {@link CardReaderInitRequest }
     */
    public CardReaderInitRequest createCardReaderInitRequest() {
        return new CardReaderInitRequest();
    }

    /**
     * Create an instance of {@link CardReaderAPDURequest }
     */
    public CardReaderAPDURequest createCardReaderAPDURequest() {
        return new CardReaderAPDURequest();
    }

    /**
     * Create an instance of {@link CardReaderPowerOffRequest }
     */
    public CardReaderPowerOffRequest createCardReaderPowerOffRequest() {
        return new CardReaderPowerOffRequest();
    }

    /**
     * Create an instance of {@link ReconciliationRequest }
     */
    public ReconciliationRequest createReconciliationRequest() {
        return new ReconciliationRequest();
    }

    /**
     * Create an instance of {@link ReversalRequest }
     */
    public ReversalRequest createReversalRequest() {
        return new ReversalRequest();
    }

    /**
     * Create an instance of {@link SoundRequest }
     */
    public SoundRequest createSoundRequest() {
        return new SoundRequest();
    }

    /**
     * Create an instance of {@link StoredValueRequest }
     */
    public StoredValueRequest createStoredValueRequest() {
        return new StoredValueRequest();
    }

    /**
     * Create an instance of {@link TransactionStatusRequest }
     */
    public TransactionStatusRequest createTransactionStatusRequest() {
        return new TransactionStatusRequest();
    }

    /**
     * Create an instance of {@link TransmitRequest }
     */
    public TransmitRequest createTransmitRequest() {
        return new TransmitRequest();
    }

    /**
     * Create an instance of {@link ContentInformation }
     */
    public ContentInformation createContentInformation() {
        return new ContentInformation();
    }

    /**
     * Create an instance of {@link SaleToPOIResponse }
     */
    public SaleToPOIResponse createSaleToPOIResponse() {
        return new SaleToPOIResponse();
    }

    /**
     * Create an instance of {@link BalanceInquiryResponse }
     */
    public BalanceInquiryResponse createBalanceInquiryResponse() {
        return new BalanceInquiryResponse();
    }

    /**
     * Create an instance of {@link BatchResponse }
     */
    public BatchResponse createBatchResponse() {
        return new BatchResponse();
    }

    /**
     * Create an instance of {@link CardAcquisitionResponse }
     */
    public CardAcquisitionResponse createCardAcquisitionResponse() {
        return new CardAcquisitionResponse();
    }

    /**
     * Create an instance of {@link AdminResponse }
     */
    public AdminResponse createAdminResponse() {
        return new AdminResponse();
    }

    /**
     * Create an instance of {@link DiagnosisResponse }
     */
    public DiagnosisResponse createDiagnosisResponse() {
        return new DiagnosisResponse();
    }

    /**
     * Create an instance of {@link DisplayResponse }
     */
    public DisplayResponse createDisplayResponse() {
        return new DisplayResponse();
    }

    /**
     * Create an instance of {@link EnableServiceResponse }
     */
    public EnableServiceResponse createEnableServiceResponse() {
        return new EnableServiceResponse();
    }

    /**
     * Create an instance of {@link GetTotalsResponse }
     */
    public GetTotalsResponse createGetTotalsResponse() {
        return new GetTotalsResponse();
    }

    /**
     * Create an instance of {@link InputResponse }
     */
    public InputResponse createInputResponse() {
        return new InputResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link LoyaltyResponse }
     */
    public LoyaltyResponse createLoyaltyResponse() {
        return new LoyaltyResponse();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link PINResponse }
     */
    public PINResponse createPINResponse() {
        return new PINResponse();
    }

    /**
     * Create an instance of {@link PrintResponse }
     */
    public PrintResponse createPrintResponse() {
        return new PrintResponse();
    }

    /**
     * Create an instance of {@link CardReaderInitResponse }
     */
    public CardReaderInitResponse createCardReaderInitResponse() {
        return new CardReaderInitResponse();
    }

    /**
     * Create an instance of {@link CardReaderAPDUResponse }
     */
    public CardReaderAPDUResponse createCardReaderAPDUResponse() {
        return new CardReaderAPDUResponse();
    }

    /**
     * Create an instance of {@link CardReaderPowerOffResponse }
     */
    public CardReaderPowerOffResponse createCardReaderPowerOffResponse() {
        return new CardReaderPowerOffResponse();
    }

    /**
     * Create an instance of {@link ReconciliationResponse }
     */
    public ReconciliationResponse createReconciliationResponse() {
        return new ReconciliationResponse();
    }

    /**
     * Create an instance of {@link ReversalResponse }
     */
    public ReversalResponse createReversalResponse() {
        return new ReversalResponse();
    }

    /**
     * Create an instance of {@link SoundResponse }
     */
    public SoundResponse createSoundResponse() {
        return new SoundResponse();
    }

    /**
     * Create an instance of {@link StoredValueResponse }
     */
    public StoredValueResponse createStoredValueResponse() {
        return new StoredValueResponse();
    }

    /**
     * Create an instance of {@link TransactionStatusResponse }
     */
    public TransactionStatusResponse createTransactionStatusResponse() {
        return new TransactionStatusResponse();
    }

    /**
     * Create an instance of {@link TransmitResponse }
     */
    public TransmitResponse createTransmitResponse() {
        return new TransmitResponse();
    }

    /**
     * Create an instance of {@link PaymentReceipt }
     */
    public PaymentReceipt createPaymentReceipt() {
        return new PaymentReceipt();
    }

    /**
     * Create an instance of {@link POITerminalData }
     */
    public POITerminalData createPOITerminalData() {
        return new POITerminalData();
    }

    /**
     * Create an instance of {@link POIProfile }
     */
    public POIProfile createPOIProfile() {
        return new POIProfile();
    }

    /**
     * Create an instance of {@link SaleToIssuerData }
     */
    public SaleToIssuerData createSaleToIssuerData() {
        return new SaleToIssuerData();
    }

    /**
     * Create an instance of {@link SoundContent }
     */
    public SoundContent createSoundContent() {
        return new SoundContent();
    }

    /**
     * Create an instance of {@link PaymentAcquirerData }
     */
    public PaymentAcquirerData createPaymentAcquirerData() {
        return new PaymentAcquirerData();
    }

    /**
     * Create an instance of {@link SaleProfile }
     */
    public SaleProfile createSaleProfile() {
        return new SaleProfile();
    }

    /**
     * Create an instance of {@link PaymentToken }
     */
    public PaymentToken createPaymentToken() {
        return new PaymentToken();
    }

    /**
     * Create an instance of {@link LoyaltyAccountID }
     */
    public LoyaltyAccountID createLoyaltyAccountID() {
        return new LoyaltyAccountID();
    }

    /**
     * Create an instance of {@link PaymentInstrumentData }
     */
    public PaymentInstrumentData createPaymentInstrumentData() {
        return new PaymentInstrumentData();
    }

    /**
     * Create an instance of {@link Parameter }
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link EnvelopedData }
     */
    public EnvelopedData createEnvelopedData() {
        return new EnvelopedData();
    }

    /**
     * Create an instance of {@link SignerIdentifier }
     */
    public SignerIdentifier createSignerIdentifier() {
        return new SignerIdentifier();
    }

    /**
     * Create an instance of {@link MessageReference }
     */
    public MessageReference createMessageReference() {
        return new MessageReference();
    }

    /**
     * Create an instance of {@link PaymentAccountStatus }
     */
    public PaymentAccountStatus createPaymentAccountStatus() {
        return new PaymentAccountStatus();
    }

    /**
     * Create an instance of {@link IssuerAndSerialNumber }
     */
    public IssuerAndSerialNumber createIssuerAndSerialNumber() {
        return new IssuerAndSerialNumber();
    }

    /**
     * Create an instance of {@link StoredValueAccountID }
     */
    public StoredValueAccountID createStoredValueAccountID() {
        return new StoredValueAccountID();
    }

    /**
     * Create an instance of {@link Signer }
     */
    public Signer createSigner() {
        return new Signer();
    }

    /**
     * Create an instance of {@link TransactionConditions }
     */
    public TransactionConditions createTransactionConditions() {
        return new TransactionConditions();
    }

    /**
     * Create an instance of {@link EncryptedContent }
     */
    public EncryptedContent createEncryptedContent() {
        return new EncryptedContent();
    }

    /**
     * Create an instance of {@link OriginalPOITransaction }
     */
    public OriginalPOITransaction createOriginalPOITransaction() {
        return new OriginalPOITransaction();
    }

    /**
     * Create an instance of {@link AlgorithmIdentifier }
     */
    public AlgorithmIdentifier createAlgorithmIdentifier() {
        return new AlgorithmIdentifier();
    }

    /**
     * Create an instance of {@link RecipientIdentifier }
     */
    public RecipientIdentifier createRecipientIdentifier() {
        return new RecipientIdentifier();
    }

    /**
     * Create an instance of {@link PaymentData }
     */
    public PaymentData createPaymentData() {
        return new PaymentData();
    }

    /**
     * Create an instance of {@link KEKIdentifier }
     */
    public KEKIdentifier createKEKIdentifier() {
        return new KEKIdentifier();
    }

    /**
     * Create an instance of {@link PrintOutput }
     */
    public PrintOutput createPrintOutput() {
        return new PrintOutput();
    }

    /**
     * Create an instance of {@link AmountsResp }
     */
    public AmountsResp createAmountsResp() {
        return new AmountsResp();
    }

    /**
     * Create an instance of {@link LoyaltyAccountStatus }
     */
    public LoyaltyAccountStatus createLoyaltyAccountStatus() {
        return new LoyaltyAccountStatus();
    }

    /**
     * Create an instance of {@link TransactionToPerform }
     */
    public TransactionToPerform createTransactionToPerform() {
        return new TransactionToPerform();
    }

    /**
     * Create an instance of {@link MenuEntry }
     */
    public MenuEntry createMenuEntry() {
        return new MenuEntry();
    }

    /**
     * Create an instance of {@link DisplayOutput }
     */
    public DisplayOutput createDisplayOutput() {
        return new DisplayOutput();
    }

    /**
     * Create an instance of {@link SignedData }
     */
    public SignedData createSignedData() {
        return new SignedData();
    }

    /**
     * Create an instance of {@link Amount }
     */
    public Amount createAmount() {
        return new Amount();
    }

    /**
     * Create an instance of {@link PaymentTotals }
     */
    public PaymentTotals createPaymentTotals() {
        return new PaymentTotals();
    }

    /**
     * Create an instance of {@link CurrencyConversion }
     */
    public CurrencyConversion createCurrencyConversion() {
        return new CurrencyConversion();
    }

    /**
     * Create an instance of {@link SensitiveMobileData }
     */
    public SensitiveMobileData createSensitiveMobileData() {
        return new SensitiveMobileData();
    }

    /**
     * Create an instance of {@link Instalment }
     */
    public Instalment createInstalment() {
        return new Instalment();
    }

    /**
     * Create an instance of {@link LoyaltyAccount }
     */
    public LoyaltyAccount createLoyaltyAccount() {
        return new LoyaltyAccount();
    }

    /**
     * Create an instance of {@link TrackData }
     */
    public TrackData createTrackData() {
        return new TrackData();
    }

    /**
     * Create an instance of {@link PaymentAccountReq }
     */
    public PaymentAccountReq createPaymentAccountReq() {
        return new PaymentAccountReq();
    }

    /**
     * Create an instance of {@link GeographicCoordinates }
     */
    public GeographicCoordinates createGeographicCoordinates() {
        return new GeographicCoordinates();
    }

    /**
     * Create an instance of {@link LoyaltyResult }
     */
    public LoyaltyResult createLoyaltyResult() {
        return new LoyaltyResult();
    }

    /**
     * Create an instance of {@link CardData }
     */
    public CardData createCardData() {
        return new CardData();
    }

    /**
     * Create an instance of {@link LoyaltyAmount }
     */
    public LoyaltyAmount createLoyaltyAmount() {
        return new LoyaltyAmount();
    }

    /**
     * Create an instance of {@link SensitiveCardData }
     */
    public SensitiveCardData createSensitiveCardData() {
        return new SensitiveCardData();
    }

    /**
     * Create an instance of {@link Issuer }
     */
    public Issuer createIssuer() {
        return new Issuer();
    }

    /**
     * Create an instance of {@link NamedKeyEncryptedData }
     */
    public NamedKeyEncryptedData createNamedKeyEncryptedData() {
        return new NamedKeyEncryptedData();
    }

    /**
     * Create an instance of {@link POISoftware }
     */
    public POISoftware createPOISoftware() {
        return new POISoftware();
    }

    /**
     * Create an instance of {@link PerformedTransaction }
     */
    public PerformedTransaction createPerformedTransaction() {
        return new PerformedTransaction();
    }

    /**
     * Create an instance of {@link ICCResetData }
     */
    public ICCResetData createICCResetData() {
        return new ICCResetData();
    }

    /**
     * Create an instance of {@link CardholderPIN }
     */
    public CardholderPIN createCardholderPIN() {
        return new CardholderPIN();
    }

    /**
     * Create an instance of {@link StoredValueResult }
     */
    public StoredValueResult createStoredValueResult() {
        return new StoredValueResult();
    }

    /**
     * Create an instance of {@link POIData }
     */
    public POIData createPOIData() {
        return new POIData();
    }

    /**
     * Create an instance of {@link KEK }
     */
    public KEK createKEK() {
        return new KEK();
    }

    /**
     * Create an instance of {@link DigestedData }
     */
    public DigestedData createDigestedData() {
        return new DigestedData();
    }

    /**
     * Create an instance of {@link SignaturePoint }
     */
    public SignaturePoint createSignaturePoint() {
        return new SignaturePoint();
    }

    /**
     * Create an instance of {@link AmountsReq }
     */
    public AmountsReq createAmountsReq() {
        return new AmountsReq();
    }

    /**
     * Create an instance of {@link TransactionTotals }
     */
    public TransactionTotals createTransactionTotals() {
        return new TransactionTotals();
    }

    /**
     * Create an instance of {@link RepeatedMessageResponse }
     */
    public RepeatedMessageResponse createRepeatedMessageResponse() {
        return new RepeatedMessageResponse();
    }

    /**
     * Create an instance of {@link SponsoredMerchant }
     */
    public SponsoredMerchant createSponsoredMerchant() {
        return new SponsoredMerchant();
    }

    /**
     * Create an instance of {@link UTMCoordinates }
     */
    public UTMCoordinates createUTMCoordinates() {
        return new UTMCoordinates();
    }

    /**
     * Create an instance of {@link Geolocation }
     */
    public Geolocation createGeolocation() {
        return new Geolocation();
    }

    /**
     * Create an instance of {@link SaleSoftware }
     */
    public SaleSoftware createSaleSoftware() {
        return new SaleSoftware();
    }

    /**
     * Create an instance of {@link LoyaltyData }
     */
    public LoyaltyData createLoyaltyData() {
        return new LoyaltyData();
    }

    /**
     * Create an instance of {@link Rebates }
     */
    public Rebates createRebates() {
        return new Rebates();
    }

    /**
     * Create an instance of {@link InputResult }
     */
    public InputResult createInputResult() {
        return new InputResult();
    }

    /**
     * Create an instance of {@link AreaSize }
     */
    public AreaSize createAreaSize() {
        return new AreaSize();
    }

    /**
     * Create an instance of {@link CapturedSignature }
     */
    public CapturedSignature createCapturedSignature() {
        return new CapturedSignature();
    }

    /**
     * Create an instance of {@link LoyaltyAccountReq }
     */
    public LoyaltyAccountReq createLoyaltyAccountReq() {
        return new LoyaltyAccountReq();
    }

    /**
     * Create an instance of {@link AllowedProduct }
     */
    public AllowedProduct createAllowedProduct() {
        return new AllowedProduct();
    }

    /**
     * Create an instance of {@link HostStatus }
     */
    public HostStatus createHostStatus() {
        return new HostStatus();
    }

    /**
     * Create an instance of {@link RelativeDistinguishedName }
     */
    public RelativeDistinguishedName createRelativeDistinguishedName() {
        return new RelativeDistinguishedName();
    }

    /**
     * Create an instance of {@link POIStatus }
     */
    public POIStatus createPOIStatus() {
        return new POIStatus();
    }

    /**
     * Create an instance of {@link TransactionIdentification }
     */
    public TransactionIdentification createTransactionIdentification() {
        return new TransactionIdentification();
    }

    /**
     * Create an instance of {@link CustomerOrder }
     */
    public CustomerOrder createCustomerOrder() {
        return new CustomerOrder();
    }

    /**
     * Create an instance of {@link StoredValueData }
     */
    public StoredValueData createStoredValueData() {
        return new StoredValueData();
    }

    /**
     * Create an instance of {@link OutputText }
     */
    public OutputText createOutputText() {
        return new OutputText();
    }

    /**
     * Create an instance of {@link OutputBarcode }
     */
    public OutputBarcode createOutputBarcode() {
        return new OutputBarcode();
    }

    /**
     * Create an instance of {@link SaleItem }
     */
    public SaleItem createSaleItem() {
        return new SaleItem();
    }

    /**
     * Create an instance of {@link LoyaltyTransaction }
     */
    public LoyaltyTransaction createLoyaltyTransaction() {
        return new LoyaltyTransaction();
    }

    /**
     * Create an instance of {@link LoyaltyAcquirerData }
     */
    public LoyaltyAcquirerData createLoyaltyAcquirerData() {
        return new LoyaltyAcquirerData();
    }

    /**
     * Create an instance of {@link StoredValueAccountStatus }
     */
    public StoredValueAccountStatus createStoredValueAccountStatus() {
        return new StoredValueAccountStatus();
    }

    /**
     * Create an instance of {@link LoyaltyTotals }
     */
    public LoyaltyTotals createLoyaltyTotals() {
        return new LoyaltyTotals();
    }

    /**
     * Create an instance of {@link POISystemData }
     */
    public POISystemData createPOISystemData() {
        return new POISystemData();
    }

    /**
     * Create an instance of {@link CardAcquisitionTransaction }
     */
    public CardAcquisitionTransaction createCardAcquisitionTransaction() {
        return new CardAcquisitionTransaction();
    }

    /**
     * Create an instance of {@link CoinsOrBills }
     */
    public CoinsOrBills createCoinsOrBills() {
        return new CoinsOrBills();
    }

    /**
     * Create an instance of {@link InputData }
     */
    public InputData createInputData() {
        return new InputData();
    }

    /**
     * Create an instance of {@link SaleItemRebate }
     */
    public SaleItemRebate createSaleItemRebate() {
        return new SaleItemRebate();
    }

    /**
     * Create an instance of {@link AuthenticatedData }
     */
    public AuthenticatedData createAuthenticatedData() {
        return new AuthenticatedData();
    }

    /**
     * Create an instance of {@link TotalFilter }
     */
    public TotalFilter createTotalFilter() {
        return new TotalFilter();
    }

    /**
     * Create an instance of {@link SaleData }
     */
    public SaleData createSaleData() {
        return new SaleData();
    }

    /**
     * Create an instance of {@link PredefinedContent }
     */
    public PredefinedContent createPredefinedContent() {
        return new PredefinedContent();
    }

    /**
     * Create an instance of {@link Input }
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link KeyTransport }
     */
    public KeyTransport createKeyTransport() {
        return new KeyTransport();
    }

    /**
     * Create an instance of {@link CheckData }
     */
    public CheckData createCheckData() {
        return new CheckData();
    }

    /**
     * Create an instance of {@link SaleTerminalData }
     */
    public SaleTerminalData createSaleTerminalData() {
        return new SaleTerminalData();
    }

    /**
     * Create an instance of {@link PaymentTransaction }
     */
    public PaymentTransaction createPaymentTransaction() {
        return new PaymentTransaction();
    }

    /**
     * Create an instance of {@link OutputContent }
     */
    public OutputContent createOutputContent() {
        return new OutputContent();
    }

    /**
     * Create an instance of {@link PaymentResult }
     */
    public PaymentResult createPaymentResult() {
        return new PaymentResult();
    }

    /**
     * Create an instance of {@link MobileData }
     */
    public MobileData createMobileData() {
        return new MobileData();
    }

    /**
     * Create an instance of {@link OutputResult }
     */
    public OutputResult createOutputResult() {
        return new OutputResult();
    }

    /**
     * Create an instance of {@link CashHandlingDevice }
     */
    public CashHandlingDevice createCashHandlingDevice() {
        return new CashHandlingDevice();
    }

    /**
     * Create an instance of {@link Response }
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link EncapsulatedContent }
     */
    public EncapsulatedContent createEncapsulatedContent() {
        return new EncapsulatedContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link ForceEntryModeType }{@code >}{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "ForceEntryMode", scope = CardReaderInitRequest.class)
    public JAXBElement<List<ForceEntryModeType>> createCardReaderInitRequestForceEntryMode(List<ForceEntryModeType> value) {
        return new JAXBElement<List<ForceEntryModeType>>(CARD_READER_INIT_REQUEST_FORCE_ENTRY_MODE_QNAME, ((Class) List.class), CardReaderInitRequest.class, ((List<ForceEntryModeType>) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link ForceEntryModeType }{@code >}{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "ForceEntryMode", scope = CardAcquisitionTransaction.class)
    public JAXBElement<List<ForceEntryModeType>> createCardAcquisitionTransactionForceEntryMode(List<ForceEntryModeType> value) {
        return new JAXBElement<List<ForceEntryModeType>>(CARD_READER_INIT_REQUEST_FORCE_ENTRY_MODE_QNAME, ((Class) List.class), CardAcquisitionTransaction.class, ((List<ForceEntryModeType>) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link ForceEntryModeType }{@code >}{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "ForceEntryMode", scope = TransactionConditions.class)
    public JAXBElement<List<ForceEntryModeType>> createTransactionConditionsForceEntryMode(List<ForceEntryModeType> value) {
        return new JAXBElement<List<ForceEntryModeType>>(CARD_READER_INIT_REQUEST_FORCE_ENTRY_MODE_QNAME, ((Class) List.class), TransactionConditions.class, ((List<ForceEntryModeType>) value));
    }

}
