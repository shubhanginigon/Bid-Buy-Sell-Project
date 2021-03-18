package com.SAD.Main_Project.model;

public enum Gender {
    Male(Values.Male), Female(Values.Female);

    private final String val;

    Gender(String val) {
        if (!this.name().equalsIgnoreCase(val)) {
            throw new IllegalArgumentException("Incorrect use of ELanguage");
        } else {
            this.val = val;
        }
    }

    public static class Values {
        public static final String Male = "Male";
        public static final String Female = "Female";
    }

}
