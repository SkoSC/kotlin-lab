package com.lexadiky.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Name {

    @SerializedName("english")
    private final String english;

    public Name(String english) {
        this.english = english;
    }

    public String getEnglish() {
        return english;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(english, name.english);
    }

    @Override
    public int hashCode() {
        return Objects.hash(english);
    }

    @Override
    public String toString() {
        return "Name{" +
                "english='" + english + '\'' +
                '}';
    }
}