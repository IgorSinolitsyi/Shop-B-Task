package app.models;

import app.base.BaseModel;
import app.utils.Constants;

public class OrderBModel implements BaseModel {
    @Override
    public double getOrderCost(int quota, double price) {
        return (quota * price) * (1 + Constants.DELIVERY_RATE / 100);
    }

    public double getDeliveryCost(int quota, double price) {
        return quota * price * Constants.DELIVERY_RATE / 100;
    }
}
