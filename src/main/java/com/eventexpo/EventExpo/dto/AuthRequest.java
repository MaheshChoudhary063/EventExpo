package com.eventexpo.EventExpo.dto;
//
//import lombok.*;
//

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {
        private String email;
        private String password;

}