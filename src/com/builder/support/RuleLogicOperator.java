package com.builder.support;

public enum RuleLogicOperator {
    EQUAL,
    NOT_EQUAL,
    LIKE, // STRING ONLY
    NOT_LIKE, // STRING ONLY
    CONTAINS,
    GREATER,
    GREATER_EQUAL,
    LOWER,
    LOWER_EQUAL,
    IN,
    NOT_IN,
    OR, // LOGIC ONLY
    AND, // LOGIC ONLY
    BETWEEN,
    BEFORE, // DATE ONLY
    AFTER // DATE ONLY
}
