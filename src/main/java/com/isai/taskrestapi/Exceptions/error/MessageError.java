package com.isai.taskrestapi.Exceptions.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageError {
    private HttpStatus httpStatus;
    private String message;
}
