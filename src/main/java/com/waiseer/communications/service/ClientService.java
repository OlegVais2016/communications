package com.waiseer.communications.service;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;
import com.waiseer.communications.model.dto.PhoneRequest;
import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Phone;

import java.util.List;

public interface ClientService {

    ClientResponse saveMember(ClientRequest clientRequest);
    Phone addPhoneToClient(Long clientId, PhoneRequest phoneRequest);
    List<Client> getMembers();
}
