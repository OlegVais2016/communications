package com.waiseer.communications.service.impl;

import com.waiseer.communications.exception.ClientNotFoundException;
import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Phone;
import com.waiseer.communications.repository.ClientRepository;
import com.waiseer.communications.repository.PhoneRepository;
import com.waiseer.communications.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public ClientResponse saveMember(ClientRequest clientRequest) {
        Client client = Client.builder()
                .name(clientRequest.getName())
                .build();

        clientRepository.save(client);

        return ClientResponse.builder()
                .clientId(client.getClientId())
                .name(client.getName())
                .build();
    }

    @Override
    public List<Client> getMembers() {
        return clientRepository.findAll();
    }

    @Override
    public Phone addPhoneToClient(Long clientId,
                                  PhoneRequest phoneRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));;
        Phone phone = Phone.builder()
                .phoneId(phoneRequest.getPhoneId())
                .phoneNumber(phoneRequest.getPhoneNumber())
                .build();
        phone.setClient(client);
        return phoneRepository.save(phone);
    }

}
/* public Phone addPhoneToClient(Long clientId, Phone phone) {
        Client client = getClientById(clientId);
        phone.setClient(client);
        return phoneRepository.save(phone);
    }*/