package org.aibles.backend.student.delivery.responses;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SystemResponse<T> implements Serializable {

    private static final long serialVersionUID = 7302319210373510173L;

    private String status;
    private String code;
    private String message;
    private T data;
}
