/*
 * 文 件 名:  AgentMerchRefInfo.java
 * 版    权:  China In Pay Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Ryan
 * 修改时间:  2016年11月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.njs.basecore.myBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Ryan
 * @version [版本号, 2016年11月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AgentMerchRefInfo implements Serializable
{
    
    /**
     * <默认构造函数>
     */
    private AgentMerchRefInfo(String merssageId, String tranId, BigDecimal tranAmt, BigDecimal freeAmt,
        ConcurrentMap<String, NpayMerchant> agentMerchant, NpayMerchant directMerchant, String tranType,
        String merOrderId, Date tranTime) {
        this.merssageId = merssageId;
        this.tranId = tranId;
        this.merOrderId = merOrderId;
        this.tranTime = tranTime;
        this.tranAmt = tranAmt;
        this.freeAmt = freeAmt;
        this.agentMerchants = agentMerchant;
        this.directMerchant = directMerchant;
        this.tranType = tranType;
    }
    
    private static final long serialVersionUID = -8537013119199857823L;
    
    private final String merOrderId;
    
    private final Date tranTime;
    
    // 消息编号
    private final String merssageId;
    
    // 交易号
    private final String tranId;
    
    // 交易金额
    private final BigDecimal tranAmt;
    
    // 手续费金额
    private final BigDecimal freeAmt;
    
    // 代理商映射表
    private final ConcurrentMap<String, NpayMerchant> agentMerchants;
    
    // 直接消费商户
    private final NpayMerchant directMerchant;
    
    // 交易类型
    private String tranType;
    
    /**
     * 获取 merssageId
     * 
     * @return 返回 merssageId
     */
    public String getMerssageId() {
        
        return merssageId;
    }
    
    /**
     * 获取 tranId
     * 
     * @return 返回 tranId
     */
    public String getTranId() {
        
        return tranId;
    }
    
    /**
     * 获取 tranAmt
     * 
     * @return 返回 tranAmt
     */
    public BigDecimal getTranAmt() {
        
        return tranAmt;
    }
    
    /**
     * 获取 freeAmt
     * 
     * @return 返回 freeAmt
     */
    public BigDecimal getFreeAmt() {
        
        return freeAmt;
    }
    
    /**
     * 获取 directMerchant
     * 
     * @return 返回 directMerchant
     */
    public NpayMerchant getDirectMerchant() {
        
        return directMerchant;
    }
    
    public static class AgentMerchRefInfoBuilder {
        
        private String merOrderId;
        
        private Date tranTime;
        
        // 消息编号
        private String merssageId;
        
        // 交易号
        private String tranId;
        
        // 交易金额
        private BigDecimal tranAmt;
        
        // 手续费金额
        private BigDecimal freeAmt;
        
        private ConcurrentMap<String, NpayMerchant> agentMerchants;
        
        // 直接代理商或商户
        private NpayMerchant directMerchant;
        
        // 交易类型
        private String tranType;
        
        public AgentMerchRefInfoBuilder addTranType(String tranType) {
            
            this.tranType = tranType;
            return this;
        }
        
        public AgentMerchRefInfoBuilder() {
        
        }
        
        public static AgentMerchRefInfoBuilder getInstance() {
            
            return new AgentMerchRefInfoBuilder();
        }
        
        public AgentMerchRefInfoBuilder addTranId(String tranId) {
            
            this.tranId = tranId;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addMessageId(String messageId) {
            
            this.merssageId = messageId;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addTranAmt(BigDecimal tranAmt) {
            
            this.tranAmt = tranAmt;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addFreeAmt(BigDecimal freeAmt) {
            
            this.freeAmt = freeAmt;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addAgentMerchant(ConcurrentMap<String, NpayMerchant> agentMerchants) {
            
            this.agentMerchants = agentMerchants;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addDirectMerchant(NpayMerchant directMerchant) {
            
            this.directMerchant = directMerchant;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addMerOrderId(String merOrderId) {
            
            this.merOrderId = merOrderId;
            return this;
        }
        
        public AgentMerchRefInfoBuilder addTanTime(Date tranTime) {
            
            this.tranTime = tranTime;
            return this;
        }
        
        public AgentMerchRefInfo build() {
            
            return new AgentMerchRefInfo(merssageId, tranId, tranAmt, freeAmt, agentMerchants, directMerchant, tranType,
                merOrderId, tranTime);
        }
        
    }
    
    /**
     * 获取 agentMerchant
     * 
     * @return 返回 agentMerchant
     */
    public ConcurrentMap<String, NpayMerchant> getAgentMerchants() {
        
        return agentMerchants;
    }
    
    /**
     * 获取 tranType
     * 
     * @return 返回 tranType
     */
    public String getTranType() {
        
        return tranType;
    }
    
    /**
     * 获取 merOrderId
     * 
     * @return 返回 merOrderId
     */
    public String getMerOrderId() {
        
        return merOrderId;
    }
    
    /**
     * 获取 tranTime
     * 
     * @return 返回 tranTime
     */
    public Date getTranTime() {
        
        return tranTime;
    }
}
