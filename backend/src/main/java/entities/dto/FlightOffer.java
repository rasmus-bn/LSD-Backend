package entities.dto;

import contract.dto.Flight;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class FlightOffer implements Serializable {
    public FlightOffer(double price, boolean oneWay, FlightRoute outRoute, FlightRoute returnRoute) {
        this.price = price;
        this.oneWay = oneWay;
        this.outRoute = outRoute;
        this.returnRoute = returnRoute;
    }

    public FlightOffer() {
    }

    public FlightOffer(contract.dto.FlightOffer fo){
        this.price = fo.getPrice();
        this.oneWay = fo.isOneWay();
        this.outRoute = new FlightRoute(fo.getOutRoute());
        this.returnRoute = new FlightRoute(fo.getReturnRoute());
    }

    private double price;
    private boolean oneWay;
    private FlightRoute outRoute;
    private FlightRoute returnRoute;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public FlightRoute getOutRoute() {
        return outRoute;
    }

    public void setOutRoute(FlightRoute outRoute) {
        this.outRoute = outRoute;
    }

    public FlightRoute getReturnRoute() {
        return returnRoute;
    }

    public void setReturnRoute(FlightRoute returnRoute) {
        this.returnRoute = returnRoute;
    }

    public contract.dto.FlightOffer toDto(){
        return new contract.dto.FlightOffer(this.price, this.oneWay, this.outRoute.toDto(), this.returnRoute.toDto());
    }


}
