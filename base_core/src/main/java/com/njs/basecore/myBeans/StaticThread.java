package com.njs.basecore.myBeans;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StaticThread implements Runnable
{
    private String messageId;
    public StaticThread(String messageId){
        this.messageId = messageId;
    }
    @Override
    public void run()
    {

        System.out.println(LocalDateTime.now()+":"+Thread.currentThread().getName());
        if(!StringUtils.isEmpty(messageId)){
            sleepTime(messageId);
        }

        AgentMerchRefInfo agentMerchRefInfo = AgentMerchRefInfo.AgentMerchRefInfoBuilder.getInstance().addFreeAmt(new BigDecimal("10")).addMessageId(messageId).build();

        System.out.println(LocalDateTime.now()+":"+agentMerchRefInfo.getMerssageId()+":"+agentMerchRefInfo.toString()+":"+Thread.currentThread().getName());
    }
    private void sleepTime(String messageId){
        long time = 0;

        if(messageId.equals(111)){
            time = 10 * 1000;
        }else if (messageId.equals(222)){

            time = 4 * 1000;
        }else if (messageId.equals(333)){

            time = 13* 1000;
        }
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
