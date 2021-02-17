package com.cos.myapplication;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    private Integer id;
    private String title;
    private Integer pic;
}
