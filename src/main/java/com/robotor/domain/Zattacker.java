package com.robotor.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Zattacker extends Robot {
    private double power;

    Zattacker() {
        power = ThreadLocalRandom.current().nextInt(20, 31);
    }

    @Override
    public double getWeight() {
        return 50;
    }

    public double getPower() {
        return power;
    }

    @Override
    public double getEnergyConsumption(double km) {
        return getWeight() * km + getPower() * getPower() * km;
    }

    @Override
    public String getExtraPropertiesAsString() {
        return String.format("Power:: %s%n", getPower());
    }
}
