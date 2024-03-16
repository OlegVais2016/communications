package com.waiseer.communications.controller;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.EmailRequest;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Email;
import com.waiseer.communications.model.entity.Phone;
import com.waiseer.communications.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ClientResponse saveMember(@RequestBody ClientRequest clientRequest){
        return clientService.saveMember(clientRequest);
    }
    @PostMapping("/{clientId}/phones/add")
    public Phone addPhoneToClient(@PathVariable Long clientId,
                                  @RequestBody PhoneRequest phoneRequest){
        return clientService.addPhoneToClient(clientId,phoneRequest);
    }
    @PostMapping("/{clientId}/emails/add")
    public Email addEmailToClientEmail(@PathVariable Long clientId,
                                   @RequestBody EmailRequest emailRequest){
        return clientService.addEmailToClientEmail(clientId, emailRequest);
    }
    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientService.getMembers();
    }
    @GetMapping("/clients/{clientId}")
    public ClientResponse getClient(@PathVariable Long clientId){
        return clientService.getClientById(clientId);
    }
    @GetMapping("/{clientId}/phones")
    public List<Phone> getPhonesByClientId(@PathVariable Long clientId){
        return clientService.getPhonesByClientId(clientId);
    }
    @GetMapping("/{clientId}/emails")
    public List<Email> getEmailsByClientId(@PathVariable Long clientId){
        return clientService.getEmailsByClientId(clientId);
    }
    @GetMapping("/{clientId}/phones&emails")
    public List<String> getPhonesEmailsByClientId(@PathVariable Long clientId){
        return clientService.getPhonesEmailsByClientId(clientId);
    }
}

