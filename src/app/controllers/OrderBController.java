package app.controllers;

import app.base.BaseController;
import app.models.OrderBModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.views.OrderView;

public class OrderBController implements BaseController {

    private OrderView view;
    private OrderBModel model;
    private String[] data;
    private String orderCostRounded;
    private String deliveryCostRounded;


    public void handleData() {

        view = new OrderView();
        data = getData();
        model = new OrderBModel();
        orderCostRounded = Rounder.roundValue(getOrderCost());
        deliveryCostRounded = Rounder.roundValue(getDeliveryCost());
        view.getOutput(formOutput());
    }

    private String[] getData() {
        return view.getData();
    }

    private double getOrderCost() {
        return model.getOrderCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private double getDeliveryCost() {
        return model.getDeliveryCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private String formOutput() {
        return "\nOrder " + data[0] + " cost is " +
                orderCostRounded + " " + Constants.CURRENCY + "\nDelivery cost is " +
                deliveryCostRounded + " " + Constants.CURRENCY;
    }
}
