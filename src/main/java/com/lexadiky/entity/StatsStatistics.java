package com.lexadiky.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class StatsStatistics {
    protected double averageHp;
    protected double averageAttack;
    protected double averageDefence;
    protected double averageSpAttack;
    protected double averageSpDefense;
    protected double averageSpeed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        StatsStatistics that = (StatsStatistics) o;
        return Double.compare(that.averageHp, averageHp) == 0 && Double.compare(that.averageAttack, averageAttack) == 0 && Double.compare(that.averageDefence, averageDefence) == 0 && Double.compare(that.averageSpAttack, averageSpAttack) == 0 && Double.compare(that.averageSpDefense, averageSpDefense) == 0 && Double.compare(that.averageSpeed, averageSpeed) == 0;
    }

    @Override
    public String toString() {
        return "StatsStatistics{" +
                "averageHp=" + averageHp +
                ", averageAttack=" + averageAttack +
                ", averageDefence=" + averageDefence +
                ", averageSpAttack=" + averageSpAttack +
                ", averageSpDefense=" + averageSpDefense +
                ", averageSpeed=" + averageSpeed +
                '}';
    }
}
