package ru.test.bgbilling.service.bill.common.bean;

import java.math.BigDecimal;

/**
 * @author sintezwh1te
 */
public class Bill1CPayment {
    private int contractId;
    private int paymentId;
    private String contractTitle;
    private String contractComment;
    private String paymentTitle;
    private String paymentComment;
    private BigDecimal paymentSum;

    public Bill1CPayment() {
    }

    public Bill1CPayment(int contractId, int paymentId, String contractTitle, String contractComment, String paymentTitle, String paymentComment, BigDecimal paymentSum) {
        this.contractId = contractId;
        this.paymentId = paymentId;
        this.contractTitle = contractTitle;
        this.contractComment = contractComment;
        this.paymentTitle = paymentTitle;
        this.paymentComment = paymentComment;
        this.paymentSum = paymentSum;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public String getContractComment() {
        return contractComment;
    }

    public void setContractComment(String contractComment) {
        this.contractComment = contractComment;
    }

    public String getPaymentTitle() {
        return paymentTitle;
    }

    public void setPaymentTitle(String paymentTitle) {
        this.paymentTitle = paymentTitle;
    }

    public String getPaymentComment() {
        return paymentComment;
    }

    public void setPaymentComment(String paymentComment) {
        this.paymentComment = paymentComment;
    }

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(BigDecimal paymentSum) {
        this.paymentSum = paymentSum;
    }
}
