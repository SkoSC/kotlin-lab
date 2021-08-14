package com.lexadiky.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Stats {

    @SerializedName("HP")
    private final int hp;
    @SerializedName("Attack")
    private final int attack;
    @SerializedName("Defense")
    private final int defense;
    @SerializedName("Sp. Attack")
    private final int spAttack;
    @SerializedName("Sp. Defense")
    private final int spDefense;
    @SerializedName("Speed")
    private final int speed;

    public Stats(int hp, int attack, int defence, int spAttack, int spDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defence;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return hp == stats.hp && attack == stats.attack && defense == stats.defense && spAttack == stats.spAttack && spDefense == stats.spDefense && speed == stats.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, attack, defense, spAttack, spDefense, speed);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defense +
                ", spAttack=" + spAttack +
                ", spDefense=" + spDefense +
                ", speed=" + speed +
                '}';
    }
}