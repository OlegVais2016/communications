package com.waiseer.communications.model.dto;

import com.waiseer.communications.model.entity.Client;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailRequest {

    private Long emailId;
    private String emailAddress;
}
