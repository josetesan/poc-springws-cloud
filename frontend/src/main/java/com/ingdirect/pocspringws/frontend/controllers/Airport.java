package com.ingdirect.pocspringws.frontend.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * Created by josetesan on 4/06/17.
 */
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Airport {

    String name;
    String code;
}
