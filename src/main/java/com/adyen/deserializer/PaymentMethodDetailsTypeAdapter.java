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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.deserializer;

import com.adyen.model.checkout.DefaultPaymentMethodDetails;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.adyen.model.checkout.details.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PaymentMethodDetailsTypeAdapter implements TypeAdapterFactory {

    @Override
    public TypeAdapter<PaymentMethodDetails> create(Gson gson, TypeToken type) {

        if (type.getRawType() != PaymentMethodDetails.class) {
            return null;
        }

        return new TypeAdapter<PaymentMethodDetails>() {

            @Override
            public void write(JsonWriter out, PaymentMethodDetails details) throws IOException {
                TypeAdapter<Object> adapter = gson.getAdapter(Object.class);
                adapter.write(out, details);
            }

            @Override
            public PaymentMethodDetails read(JsonReader in) {
                JsonElement jsonElement = Streams.parse(in);
                String paymentMethodType = jsonElement.getAsJsonObject().get("type").getAsString();

                switch (paymentMethodType) {
                    case AfterpayDetails.AFTERPAY_DEFAULT:
                    case AfterpayDetails.AFTERPAYTOUCH:
                    case AfterpayDetails.AFTERPAY_B2B:
                        return gson.getAdapter(AfterpayDetails.class).fromJsonTree(jsonElement);
                    case AchDetails.ACH:
                        return gson.getAdapter(AchDetails.class).fromJsonTree(jsonElement);
                    case AmazonPayDetails.AMAZONPAY:
                        return gson.getAdapter(AmazonPayDetails.class).fromJsonTree(jsonElement);
                    case AndroidPayDetails.ANDROIDPAY:
                        return gson.getAdapter(AndroidPayDetails.class).fromJsonTree(jsonElement);
                    case ApplePayDetails.APPLEPAY:
                        return gson.getAdapter(ApplePayDetails.class).fromJsonTree(jsonElement);
                    case BacsDirectDebitDetails.DIRECTDEBIT_GB:
                        return gson.getAdapter(BacsDirectDebitDetails.class).fromJsonTree(jsonElement);
                    case BillDeskOnlineDetails.BILLDESK_ONLINE:
                        return gson.getAdapter(BillDeskOnlineDetails.class).fromJsonTree(jsonElement);
                    case BillDeskWalletDetails.BILLDESK_WALLET:
                        return gson.getAdapter(BillDeskWalletDetails.class).fromJsonTree(jsonElement);
                    case BlikDetails.BLIK:
                        return gson.getAdapter(BlikDetails.class).fromJsonTree(jsonElement);
                    case CellulantDetails.CELLULANT:
                        return gson.getAdapter(CellulantDetails.class).fromJsonTree(jsonElement);
                    case DokuDetails.ALFAMART:
                    case DokuDetails.BCA_VA:
                    case DokuDetails.BNI_VA:
                    case DokuDetails.BRI_VA:
                    case DokuDetails.CIMB_VA:
                    case DokuDetails.DANAMON_VA:
                    case DokuDetails.INDOMARET:
                    case DokuDetails.MANDIRI_VA:
                    case DokuDetails.PERMATA_ATM:
                    case DokuDetails.PERMATA_LITE_ATM:
                    case DokuDetails.SINARMAS_VA:
                        return gson.getAdapter(DokuDetails.class).fromJsonTree(jsonElement);
                    case DotpayDetails.DOTPAY:
                        return gson.getAdapter(DotpayDetails.class).fromJsonTree(jsonElement);
                    case DragonpayDetails.EBANKING:
                    case DragonpayDetails.OTC_BANKING:
                    case DragonpayDetails.OTC_NON_BANKING:
                    case DragonpayDetails.OTC_PHILIPPINES:
                        return gson.getAdapter(DragonpayDetails.class).fromJsonTree(jsonElement);
                    case EcontextVoucherDetails.SEVENELEVEN:
                    case EcontextVoucherDetails.STORES:
                        return gson.getAdapter(EcontextVoucherDetails.class).fromJsonTree(jsonElement);
                    case EntercashDetails.ENTERCASH:
                        return gson.getAdapter(EntercashDetails.class).fromJsonTree(jsonElement);
                    case GiropayDetails.GIROPAY:
                        return gson.getAdapter(GiropayDetails.class).fromJsonTree(jsonElement);
                    case GooglePayDetails.GOOGLEPAY:
                        return gson.getAdapter(GooglePayDetails.class).fromJsonTree(jsonElement);
                    case PayWithGoogleDetails.PAYWITHGOOGLE:
                        return gson.getAdapter(PayWithGoogleDetails.class).fromJsonTree(jsonElement);
                    case IdealDetails.IDEAL:
                        return gson.getAdapter(IdealDetails.class).fromJsonTree(jsonElement);
                    case KlarnaDetails.KLARNA:
                    case KlarnaDetails.KLARNA_ACCOUNT:
                    case KlarnaDetails.KLARNA_B2B:
                    case KlarnaDetails.KLARNA_PAY_NOW:
                    case KlarnaDetails.KLARNA_PAYMENTS:
                    case KlarnaDetails.KLARNA_PAYMENTS_ACCOUNT:
                    case KlarnaDetails.KLARNA_PAYMENTS_B2B:
                        return gson.getAdapter(KlarnaDetails.class).fromJsonTree(jsonElement);
                    case LianLianPayDetails.EBANKING_CREDIT:
                    case LianLianPayDetails.EBANKING_DEBIT:
                    case LianLianPayDetails.EBANKING_ENTERPRISE:
                        return gson.getAdapter(LianLianPayDetails.class).fromJsonTree(jsonElement);
                    case MasterpassDetails.MASTERPASS:
                        return gson.getAdapter(MasterpassDetails.class).fromJsonTree(jsonElement);
                    case MbwayDetails.MBWAY:
                        return gson.getAdapter(MbwayDetails.class).fromJsonTree(jsonElement);
                    case MobilePayDetails.MOBILEPAY:
                        return gson.getAdapter(MobilePayDetails.class).fromJsonTree(jsonElement);
                    case MolPayDetails.EBANKING_DIRECT_MY:
                    case MolPayDetails.EBANKING_FPX_MY:
                    case MolPayDetails.EBANKING_MY:
                    case MolPayDetails.EBANKING_TH:
                    case MolPayDetails.EBANKING_VN:
                    case MolPayDetails.FPX:
                        return gson.getAdapter(MolPayDetails.class).fromJsonTree(jsonElement);
                    case PayPalDetails.PAYPAL:
                        return gson.getAdapter(PayPalDetails.class).fromJsonTree(jsonElement);
                    case PayUUpiDetails.PAYUINUPI:
                        return gson.getAdapter(PayUUpiDetails.class).fromJsonTree(jsonElement);
                    case QiwiWalletDetails.QIWIWALLET:
                        return gson.getAdapter(QiwiWalletDetails.class).fromJsonTree(jsonElement);
                    case SamsungPayDetails.SAMSUNGPAY:
                        return gson.getAdapter(SamsungPayDetails.class).fromJsonTree(jsonElement);
                    case SepaDirectDebitDetails.SEPADIRECTDEBIT_AMAZONPAY:
                    case SepaDirectDebitDetails.SEPADIRECTDEBIT:
                        return gson.getAdapter(SepaDirectDebitDetails.class).fromJsonTree(jsonElement);
                    case UpiIntentDetails.UPI_INTENT:
                        return gson.getAdapter(UpiIntentDetails.class).fromJsonTree(jsonElement);
                    case UpiCollectDetails.UPI_COLLECT:
                        return gson.getAdapter(UpiCollectDetails.class).fromJsonTree(jsonElement);
                    case UpiDetails.UPI:
                        return gson.getAdapter(UpiDetails.class).fromJsonTree(jsonElement);
                    case VippsDetails.VIPPS:
                        return gson.getAdapter(VippsDetails.class).fromJsonTree(jsonElement);
                    case VisaCheckoutDetails.VISA_CHECKOUT:
                        return gson.getAdapter(VisaCheckoutDetails.class).fromJsonTree(jsonElement);
                    case WeChatPayDetails.WECHATPAY:
                        return gson.getAdapter(WeChatPayDetails.class).fromJsonTree(jsonElement);
                    case WeChatPayMiniProgramDetails.WECHATPAYMINIPROGRAM:
                        return gson.getAdapter(WeChatPayMiniProgramDetails.class).fromJsonTree(jsonElement);
                    case StoredPaymentMethodDetails.BCMC_MOBILE:
                    case StoredPaymentMethodDetails.BCMC_MOBILE_QR:
                    case StoredPaymentMethodDetails.BCMC_MOBILE_APP:
                    case StoredPaymentMethodDetails.MOMO_WALLET:
                    case StoredPaymentMethodDetails.MOMO_WALLET_APP:
                    case StoredPaymentMethodDetails.PAYMAYA_WALLET:
                    case StoredPaymentMethodDetails.GRABPAY_SG:
                    case StoredPaymentMethodDetails.GRABPAY_MY:
                    case StoredPaymentMethodDetails.GRABPAY_TH:
                    case StoredPaymentMethodDetails.GRABPAY_ID:
                    case StoredPaymentMethodDetails.GRABPAY_VN:
                    case StoredPaymentMethodDetails.GRABPAY_PH:
                    case StoredPaymentMethodDetails.OXXO:
                    case StoredPaymentMethodDetails.GCASH:
                    case StoredPaymentMethodDetails.KAKAOPAY:
                    case StoredPaymentMethodDetails.TRUEMONEY:
                        return gson.getAdapter(StoredPaymentMethodDetails.class).fromJsonTree(jsonElement);
                    default:
                        return gson.getAdapter(DefaultPaymentMethodDetails.class).fromJsonTree(jsonElement);
                }
            }
        };
    }
}
