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
@Getter
@Setter
public class Item {

    private Product product;
    private int quantity;
    private float price;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
