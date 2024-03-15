package com.waiseer.communications.service;

import com.waiseer.communications.model.dto.ClientRequest;
import com.waiseer.communications.model.dto.ClientResponse;

public interface ClientService {

    ClientResponse saveMember(ClientRequest clientRequest);
}
