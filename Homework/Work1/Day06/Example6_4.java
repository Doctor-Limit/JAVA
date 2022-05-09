package Work1.Day06;

/**
 * ********概述：
 */

abstract class MotorVehicles {
    abstract void brake();
}

interface MoneyFare {
    void charge();
}

interface ControlTemperature {
    void controlAirTemperature();
}

class Bus extends MotorVehicles implements MoneyFare {

    @Override
    void brake() {
        System.out.println("公共汽车使用刹车技术");
    }

    @Override
    public void charge() {
        System.out.println("公共汽车:一元/张，不计算公里数");
    }
}

class Taxi extends MotorVehicles implements MoneyFare, ControlTemperature{

    @Override
    public void charge() {
        System.out.println("出租车使用盘式刹车技术");
    }

    @Override
    public void brake() {
        System.out.println("出租车: 2元/公里，起价三公里");
    }
    public void controlAirTemperature() {
        System.out.println("出租车安装了Hair空调");
    }
}

class Cinema implements MoneyFare, ControlTemperature {

    @Override
    public void charge() {
        System.out.println("电影院:门票，十元/张");
    }

    @Override
    public void controlAirTemperature() {
        System.out.println("电影院安装了中央空调");
    }
}

public class Example6_4 {
    public static void main(String[] args) {
        Bus bus101 = new Bus();
        Taxi bluetaxi = new Taxi();

        Cinema redStarCinema = new Cinema();
        MoneyFare fare;
        ControlTemperature temperature;
        fare = bus101;
        bus101.brake();
        fare.charge();
        fare = bluetaxi;
        temperature = bluetaxi;
        bluetaxi.brake();
        fare.charge();
        temperature.controlAirTemperature();
        temperature = redStarCinema;
        fare.charge();
        temperature.controlAirTemperature();
    }
}
