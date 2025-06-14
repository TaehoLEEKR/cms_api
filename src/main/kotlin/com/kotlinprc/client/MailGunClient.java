package com.kotlinprc.client;

import feign.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mailgun", url = "https://api.mailgun.net/v3/")
@Qualifier("mailgun")
public interface MailGunClient {

    @PostMapping("sandbox30766b81279e44dbb45f11addc523432.mailgun.org/messages")
    ResponseEntity<String> sendEmail(
            @SpringQueryMap SendMailForm form
    );
}
