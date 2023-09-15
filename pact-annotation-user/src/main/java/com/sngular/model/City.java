package com.sngular.model;

import java.util.Date;
import java.util.List;

import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class City {

    private String cityName;

    private double coords;

    private boolean isCapital;

    private List<Date> objectList;
}
