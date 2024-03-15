package com.waiseer.communications.service.impl;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.repository.ClientRepository;
import com.waiseer.communications.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ClientResponse saveMember(ClientRequest clientRequest) {
        Client client = Client.builder()
                .email(clientRequest.getEmail())
                .telephone(clientRequest.getTelephone())
                .build();

        clientRepository.save(client);

        return ClientResponse.builder()
                .clientId(client.getClientId())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .build();
    }
}
