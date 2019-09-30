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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.terminal.util;

import com.adyen.model.Amount;
import com.adyen.model.nexo.AmountsReq;
import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageReference;
import com.adyen.model.nexo.PaymentRequest;
import com.adyen.model.nexo.PaymentTransaction;
import com.adyen.model.nexo.ResultType;
import com.adyen.model.nexo.SaleData;
import com.adyen.model.nexo.SaleToPOIResponse;
import com.adyen.model.nexo.TransactionIdentification;
import com.adyen.model.nexo.TransactionStatusRequest;
import com.adyen.model.nexo.TransactionStatusResponse;
import com.adyen.model.terminal.TerminalAPIResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public final class TerminalAPIUtil {
    private TerminalAPIUtil() {
    }

    public static PaymentRequest createPaymentRequest(String transactionId, Amount amount) throws DatatypeConfigurationException {
        PaymentRequest paymentRequest = new PaymentRequest();

        SaleData saleData = new SaleData();
        TransactionIdentification transactionIdentification = new TransactionIdentification();
        transactionIdentification.setTransactionID(transactionId);
        XMLGregorianCalendar timestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        transactionIdentification.setTimeStamp(timestamp);
        saleData.setSaleTransactionID(transactionIdentification);

        paymentRequest.setSaleData(saleData);

        PaymentTransaction paymentTransaction = new PaymentTransaction();
        AmountsReq amountsReq = new AmountsReq();
        amountsReq.setCurrency(amount.getCurrency());
        amountsReq.setRequestedAmount(amount.getDecimalValue());
        paymentTransaction.setAmountsReq(amountsReq);

        paymentRequest.setPaymentTransaction(paymentTransaction);

        return paymentRequest;
    }

    public static ResultType getPaymentResult(TerminalAPIResponse terminalApiResponse) {
        if (terminalApiResponse != null && terminalApiResponse.getSaleToPOIResponse() != null) {
            SaleToPOIResponse saleToPoiResponse = terminalApiResponse.getSaleToPOIResponse();

            if (saleToPoiResponse.getPaymentResponse() != null) {
                return terminalApiResponse
                        .getSaleToPOIResponse()
                        .getPaymentResponse()
                        .getResponse()
                        .getResult();
            } else if (saleToPoiResponse.getTransactionStatusResponse() != null) {
                TransactionStatusResponse transactionStatusResponse = saleToPoiResponse.getTransactionStatusResponse();

                if (ResultType.SUCCESS == transactionStatusResponse.getResponse().getResult()) {
                    return transactionStatusResponse
                            .getRepeatedMessageResponse()
                            .getRepeatedResponseMessageBody()
                            .getPaymentResponse()
                            .getResponse()
                            .getResult();
                }
            }
        }

        return ResultType.FAILURE;
    }

    public static TransactionStatusRequest createPaymentTransactionStatusRequest(String paymentSaleId, String paymentServiceId) {
        MessageReference messageReference = new MessageReference();
        messageReference.setMessageCategory(MessageCategoryType.PAYMENT);
        messageReference.setSaleID(paymentSaleId);
        messageReference.setServiceID(paymentServiceId);

        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest();
        transactionStatusRequest.setMessageReference(messageReference);

        return transactionStatusRequest;
    }
}
