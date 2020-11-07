package com.robotor.domain;

import java.util.List;
import java.util.Optional;

public class GroupRobot {
    private double distance = 0;
    private final List<Robot> robots;

    public GroupRobot(List<Robot> robots) {
        this.robots = robots;
    }

    GroupRobot go(double distance) {
        this.distance += distance;
        return this;
    }

    GroupRobot printStatus() {
        robots.forEach(Robot::printInformation);
        return this;
    }

    Optional<Robot> getEnergyConsumptionHighest() {
        return robots.stream().max((robot1, robot2) -> robot1.getEnergyConsumption(distance) > robot1.getEnergyConsumption(distance) ? 1 : 0);
    }
}
