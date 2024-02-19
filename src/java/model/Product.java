/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AD
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    private int id;
    private String name;
    private float price;
    private int quantity;
}
