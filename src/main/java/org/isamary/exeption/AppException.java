package org.isamary.exeption;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class AppException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private String message;

    public AppException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}
