package com.loveable.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {

    public Float temp;
    public Float feelsLike;
    public Float tempMin;
    public Float tempMax;
    public Integer pressure;
    public Integer humidity;
    public Integer seaLevel;
    public Integer grndLevel;

}
