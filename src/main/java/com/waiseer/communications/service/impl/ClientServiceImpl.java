package com.waiseer.communications.service.impl;

import com.waiseer.communications.exception.ClientNotFoundException;
import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.EmailRequest;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Email;
import com.waiseer.communications.model.entity.Phone;
import com.waiseer.communications.repository.ClientRepository;
import com.waiseer.communications.repository.EmailRepository;
import com.waiseer.communications.repository.PhoneRepository;
import com.waiseer.communications.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private EmailRepository emailRepository;

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
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        Phone phone = Phone.builder()
                .phoneId(phoneRequest.getPhoneId())
                .phoneNumber(phoneRequest.getPhoneNumber())
                .build();
        phone.setClient(client);
        return phoneRepository.save(phone);
    }

    @Override
    public Email addEmailToClientEmail(Long clientId, EmailRequest emailRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        Email email = Email.builder()
                .emailId(emailRequest.getEmailId())
                .emailAddress(emailRequest.getEmailAddress())
                .build();
        email.setClient(client);
        return emailRepository.save(email);
    }

    @Override
    public ClientResponse getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        return ClientResponse.builder()
                .clientId(client.getClientId())
                .name(client.getName())
                .build();
    }

    @Override
    public List<Phone> getPhonesByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ClientNotFoundException(clientId));
        List<Phone> phoneList = phoneRepository.findAll();
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getClient().equals(client)) {
                result.add(phone);
            }
        }
        return result;
    }

    @Override
    public List<Email> getEmailsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ClientNotFoundException(clientId));
        List<Email> emailList = emailRepository.findAll();
        List<Email> result = new ArrayList<>();
        for (Email email : emailList) {
            if (email.getClient().equals(client)) {
                result.add(email);
            }
        }
        return result;
    }

    @Override
    public List<String> getPhonesEmailsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ClientNotFoundException(clientId));
        List<Phone> phoneList = phoneRepository.findAll();
        List<Email> emailList = emailRepository.findAll();
        List<String> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getClient().equals(client)) {
                result.add(phone.getPhoneNumber());
            }
        }
        for (Email email : emailList) {
            if (email.getClient().equals(client)) {
                result.add(email.getEmailAddress());
            }
        }
        return result;
    }


}
