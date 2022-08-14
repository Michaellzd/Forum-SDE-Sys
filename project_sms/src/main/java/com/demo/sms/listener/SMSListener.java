package com.demo.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.demo.sms.utils.SmsUtil;
import org.assertj.core.util.Strings;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "SMS")
public class SMSListener {
    @Autowired
    private SmsUtil smsUtil;
    @Value("${aliyun.sms.template_code}")
    private  String template_code;

    @Value("${aliyun.sms.sign_name}")
    private  String sign_name;

    @RabbitHandler
    public void executeSMS(Map<String,String> map) throws ClientException {
        String mobile=map.get("mobile");
        System.out.println("手机号:"+map.get("mobile"));
        System.out.println("验证码："+map.get("checkcode"));
        smsUtil.sendSms(mobile,template_code,sign_name," {\"checkcode\":\""+ map.get("checkcode") +"\"}");
    }
}
