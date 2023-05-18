package com.xxx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 快餐类
 * @author Ether
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FastFood {

    private float price;

    private String desc;

    public abstract float cost();
}
