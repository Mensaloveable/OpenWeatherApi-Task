package com.loveable.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sys {
    public Integer type;
    public Integer id;
    public String country;
    public Integer sunrise;
    public Integer sunset;
}
