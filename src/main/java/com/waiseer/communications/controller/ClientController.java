package com.waiseer.communications.controller;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ClientResponse saveMember(@RequestBody ClientRequest clientRequest){
        return clientService.saveMember(clientRequest);
    }

}
/*
@PostMapping("/members")
public MemberResponse saveMember(@RequestBody MemberRequest memberRequest){
    return memberService.saveMember(memberRequest);
}*/
