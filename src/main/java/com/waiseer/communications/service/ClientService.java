package com.waiseer.communications.service;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.EmailRequest;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Email;
import com.waiseer.communications.model.entity.Phone;

import java.util.List;

public interface ClientService {

    ClientResponse saveMember(ClientRequest clientRequest);
    Phone addPhoneToClient(Long clientId, PhoneRequest phoneRequest);
    Email addEmailToClientEmail(Long clientId, EmailRequest emailRequest);
    List<Client> getMembers();
    ClientResponse getClientById(Long clientId);
    List<Phone> getPhonesByClientId(Long clientId);
    List<Email> getEmailsByClientId(Long clientId);
    List<String> getPhonesEmailsByClientId(Long clientId);
}
