package com.waiseer.communications.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientResponse {

    private Long clientId;
    private String email;
    private String telephone;

}
