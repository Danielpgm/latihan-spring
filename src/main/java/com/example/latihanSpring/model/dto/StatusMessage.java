package com.example.latihanSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusMessage<Y> {
    private Integer status;
    private String message;
    private Y data;
}