package com.robotor.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotFactory {
    private final List<Robot> robots;
    private final Map<Class, RobotBuilderEngine> engineAsMap;

    public RobotFactory(Map<Class, RobotBuilderEngine> engineAsMap) {
        this.engineAsMap = engineAsMap;
        robots = new ArrayList<>();
    }

    public <T extends Robot> RobotFactory create(Class<T> clazz, int quality) throws Exception {
        RobotBuilderEngine engine = engineAsMap.get(clazz);
        if (engine != null) {
            List newRobots = engine.create(quality);
            this.robots.addAll(newRobots);
        } else {
            throw new Exception(String.format("class:: %s can not create at this time", clazz));
        }
        return this;
    }

    public GroupRobot build() {
        return new GroupRobot(robots);
    }

    public static RobotFactoryBuilder builder() {
        return new RobotFactoryBuilder();
    }
}

class RobotFactoryBuilder {
    private final Map<Class, RobotBuilderEngine> engineAsMap;

    public RobotFactoryBuilder() {
        this.engineAsMap = new HashMap<>();
    }

    public RobotFactoryBuilder addEngine(Class clazz, RobotBuilderEngine engine) {
        this.engineAsMap.put(clazz, engine);
        return this;
    }

    public RobotFactory build() {
        return new RobotFactory(this.engineAsMap);
    }
}
