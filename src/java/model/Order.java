/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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
public class Order {

    private int id;
    private Date date;
    private int cId;
    private float totalMoney;
}
