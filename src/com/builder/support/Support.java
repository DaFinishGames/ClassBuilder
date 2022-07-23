package com.builder.support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.builder.constant.BuilderConstants.*;

public class Support {
    private static final String INT = "int";
    private static final String LONG = "long";
    private static final String DOUBLE = "double";
    private static final String FLOAT = "float";
    private static final String CHAR = "char";
    private static final String BOOLEAN = "boolean";
    private static final String SHORT = "short";

    public static Class getPrimitiveClass(String className){
        switch(className){
            case INT -> {
                return Integer.class;
            }
            case DOUBLE -> {
                return Double.class;
            }
            case LONG -> {
                return Long.class;
            }
            case FLOAT -> {
                return Float.class;
            }
            case CHAR -> {
                return Character.class;
            }
            case BOOLEAN -> {
                return Boolean.class;
            }
            case SHORT -> {
                return Short.class;
            }
        }
        return null;
    }

    public static String toUnderlineCase(String text) {
        for(int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if(character.equals('_')) {
                i++;
            }else if(Character.isUpperCase(character)) {
                if(i != 0) {
                    text = text.replace(character.toString(), "_"+character.toString());
                }else {
                    text = text.replaceFirst(character.toString(), character.toString().toLowerCase());
                }
                i++;
            }
        }
        return text;
    }

    public static String toDashCase(String text) {
        for(int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if(character.equals('-')) {
                i++;
            }else if(Character.isUpperCase(character)) {
                if(i != 0) {
                    text = text.replace(character.toString(), "-"+character.toString());
                }else {
                    text = text.replaceFirst(character.toString(), character.toString().toLowerCase());
                }
                i++;
            }
        }
        return text;
    }

    public static String capitalize(String text) {
        Character character = text.charAt(0);
        if(Character.isLowerCase(character)) {
            text = text.replaceFirst(character.toString(), character.toString().toUpperCase());
        }
        return text;
    }

    public static String uncapitalize(String text) {
        Character character = text.charAt(0);
        if(Character.isUpperCase(character)) {
            text = text.replaceFirst(character.toString(), character.toString().toLowerCase());
        }
        return text;
    }


    public static String cleanLine(String line) {
        return line.replaceAll("\t", "").
                replaceAll(";", "").
                replaceAll(PRIVATE_PREFIX, "").
                replaceAll(PUBLIC_PREFIX, "").
                replaceAll(FINAL_PREFIX, "").
                replaceAll(STATIC_PREFIX, "").
                replaceAll(CLASS_PREFIX, "");
    }
}
