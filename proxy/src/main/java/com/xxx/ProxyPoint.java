package com.xxx;

/**
 * 代售点
 * @author Ether
 */
public class ProxyPoint implements SellTickets{

    //声明火车站对象
    private TrainStation station = new TrainStation();

    @Override
    public void sell() {
        System.out.println("进行收费");
        station.sell();
    }
}
