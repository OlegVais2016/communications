package com.waiseer.communications.controller;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
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
    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientService.getMembers();
    }

}

