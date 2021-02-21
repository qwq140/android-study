package com.cos.myapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Integer id;
    private String username;
    private String massage;
    private String time;
}
