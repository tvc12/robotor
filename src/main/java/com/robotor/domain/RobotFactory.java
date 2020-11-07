package com.robotor.domain;

import java.util.List;

public class RobotFactory {
    private List<Robot> robots;

    public <T extends Robot> RobotFactory create(Class<T> clazz, int quality) {
//        throw new Exception();
        return this;
    }

    public GroupRobot build() {
        return new GroupRobot(robots);
    }
}
