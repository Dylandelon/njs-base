package com.njs.basecore.myBeans;

import java.io.Serializable;
import java.util.Date;

public class NpayMerchant implements Serializable
{
    private String merchantId;

    private String merchantName;

    private Long userId;

    private String brandCode;

    private String merchDiv;

    private String mcc;

    private String merchantOrg;

    private String developChannel;

    private String vassaFiliale;

    private String agencyLevel;

    private String authLevel;

    private String merchType;

    private String status;

    private Short clearingFlag;

    private String clearingType;

    private String retGoodsFlag;

    private String feeRetFlag;

    private Date createDate;

    private String signType;

    private String signKey;

    private String transportAlgorithm;

    private String transportKey;

    private String returnUrl;

    private String notifyUrl;

    private String cardType;

    private String queryId;

    private String auditDesc;

    private static final long serialVersionUID = 1L;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getMerchDiv() {
        return merchDiv;
    }

    public void setMerchDiv(String merchDiv) {
        this.merchDiv = merchDiv;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMerchantOrg() {
        return merchantOrg;
    }

    public void setMerchantOrg(String merchantOrg) {
        this.merchantOrg = merchantOrg;
    }

    public String getDevelopChannel() {
        return developChannel;
    }

    public void setDevelopChannel(String developChannel) {
        this.developChannel = developChannel;
    }

    public String getVassaFiliale() {
        return vassaFiliale;
    }

    public void setVassaFiliale(String vassaFiliale) {
        this.vassaFiliale = vassaFiliale;
    }

    public String getAgencyLevel() {
        return agencyLevel;
    }

    public void setAgencyLevel(String agencyLevel) {
        this.agencyLevel = agencyLevel;
    }

    public String getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(String authLevel) {
        this.authLevel = authLevel;
    }

    public String getMerchType() {
        return merchType;
    }

    public void setMerchType(String merchType) {
        this.merchType = merchType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getClearingFlag() {
        return clearingFlag;
    }

    public void setClearingFlag(Short clearingFlag) {
        this.clearingFlag = clearingFlag;
    }

    public String getClearingType() {
        return clearingType;
    }

    public void setClearingType(String clearingType) {
        this.clearingType = clearingType;
    }

    public String getRetGoodsFlag() {
        return retGoodsFlag;
    }

    public void setRetGoodsFlag(String retGoodsFlag) {
        this.retGoodsFlag = retGoodsFlag;
    }

    public String getFeeRetFlag() {
        return feeRetFlag;
    }

    public void setFeeRetFlag(String feeRetFlag) {
        this.feeRetFlag = feeRetFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getTransportAlgorithm() {
        return transportAlgorithm;
    }

    public void setTransportAlgorithm(String transportAlgorithm) {
        this.transportAlgorithm = transportAlgorithm;
    }

    public String getTransportKey() {
        return transportKey;
    }

    public void setTransportKey(String transportKey) {
        this.transportKey = transportKey;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", userId=").append(userId);
        sb.append(", brandCode=").append(brandCode);
        sb.append(", merchDiv=").append(merchDiv);
        sb.append(", mcc=").append(mcc);
        sb.append(", merchantOrg=").append(merchantOrg);
        sb.append(", developChannel=").append(developChannel);
        sb.append(", vassaFiliale=").append(vassaFiliale);
        sb.append(", agencyLevel=").append(agencyLevel);
        sb.append(", authLevel=").append(authLevel);
        sb.append(", merchType=").append(merchType);
        sb.append(", status=").append(status);
        sb.append(", clearingFlag=").append(clearingFlag);
        sb.append(", clearingType=").append(clearingType);
        sb.append(", retGoodsFlag=").append(retGoodsFlag);
        sb.append(", feeRetFlag=").append(feeRetFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", signType=").append(signType);
        sb.append(", signKey=").append(signKey);
        sb.append(", transportAlgorithm=").append(transportAlgorithm);
        sb.append(", transportKey=").append(transportKey);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", cardType=").append(cardType);
        sb.append(", queryId=").append(queryId);
        sb.append(", auditDesc=").append(auditDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}