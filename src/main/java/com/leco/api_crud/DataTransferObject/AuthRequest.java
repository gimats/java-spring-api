package com.leco.api_crud.DataTransferObject;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}