package com.minha_carteira.carteira_finaceira.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.Instant;

@Getter @Setter
public class StandardError implements Serializable {
    public static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

}
