package com.waiseer.communications.model.dto;

import com.waiseer.communications.model.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneRequest {

    private Long phoneId;
    private String phoneNumber;
}
