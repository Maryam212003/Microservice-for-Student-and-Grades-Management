package com.sajaya.scoremicroservice.enumclasses;

public enum LessonGroup {
    MATH(1),
    SCIENCE(2),
    HISTORY(3),
    LANGUAGE(4),
    ART(5),
    MUSIC(6),
    PHYSICAL_EDUCATION(7),
    COMPUTER_SCIENCE(8),
    GEOGRAPHY(9);

    private final int number;

    LessonGroup(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LessonGroup fromNumber(int number) {
        for (LessonGroup group : LessonGroup.values()) {
            if (group.getNumber() == number) {
                return group;
            }
        }
        throw new IllegalArgumentException("No category with number " + number);
    }

    @Override
    public String toString() {
        return this.name() + "(" + this.number + ")";
    }
}
