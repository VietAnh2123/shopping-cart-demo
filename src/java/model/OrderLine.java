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
public class OrderLine {

    private int oId;
    private int pId;
    private int quantity;
    private float price;

}
