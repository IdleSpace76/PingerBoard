package dev.pingerboard.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author a.zharov
 */
@SuperBuilder
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceExceptionResponse {

    private LocalDateTime timeStamp;
    private int statusCode;
    private String message;
    private String path;
}
