package com.builder.support;

import static com.builder.support.Support.*;

public class RuleExpressionResolver {
    public static final RuleLogicOperator[] STRING_LOGIC_OPERATORS = new RuleLogicOperator[]{
            RuleLogicOperator.EQUAL,
            RuleLogicOperator.CONTAINS,
            RuleLogicOperator.NOT_EQUAL,
            RuleLogicOperator.IN,
            RuleLogicOperator.NOT_IN,
            RuleLogicOperator.LIKE,
            RuleLogicOperator.NOT_LIKE
    };
    public static final RuleLogicOperator[] NUMERIC_LOGIC_OPERATORS = new RuleLogicOperator[]{
            RuleLogicOperator.EQUAL,
            RuleLogicOperator.NOT_EQUAL,
            RuleLogicOperator.IN,
            RuleLogicOperator.NOT_IN,
            RuleLogicOperator.LOWER_EQUAL,
            RuleLogicOperator.LOWER,
            RuleLogicOperator.GREATER_EQUAL,
            RuleLogicOperator.GREATER,
            RuleLogicOperator.BETWEEN
    };
    public static final RuleLogicOperator[] BOOLEAN_LOGIC_OPERATORS = new RuleLogicOperator[]{
            RuleLogicOperator.EQUAL,
            RuleLogicOperator.NOT_EQUAL
    };
    public static final RuleLogicOperator[] DATE_LOGIC_OPERATORS = new RuleLogicOperator[]{
            RuleLogicOperator.EQUAL,
            RuleLogicOperator.NOT_EQUAL,
            RuleLogicOperator.AFTER,
            RuleLogicOperator.BEFORE,
            RuleLogicOperator.BETWEEN
    };

    private static final String EMPTY = "";
    private static final String PREFIX = "has";

    private static final String EQ_OPERATION = "eq";
    private static final String NE_OPERATION = "ne";
    private static final String GT_OPERATION = "gt";
    private static final String GOE_OPERATION = "goe";
    private static final String LT_OPERATION = "lt";
    private static final String LOE_OPERATION = "loe";
    private static final String IN_OPERATION = "in";
    private static final String NOT_IN_OPERATION = "notIn";
    private static final String CONTAINS_OPERATION = "contains";
    private static final String LIKE_OPERATION = "like";
    private static final String NOT_LIKE_OPERATION = "notLike";
    private static final String BETWEEN_OPERATION = "between";
    private static final String AFTER_OPERATION = "after";
    private static final String BEFORE_OPERATION = "before";

    public static String resolveFieldExpression(String fieldName, RuleLogicOperator operator){
        return resolveFieldPrefixLogicOperator(operator) + capitalize(fieldName) + resolveFieldSuffixLogicOperator(operator);
    }

    public static String resolveFieldPrefixLogicOperator(RuleLogicOperator operator){
        return operator.equals(RuleLogicOperator.CONTAINS) ? getOperation(operator) : PREFIX;
    }

    public static String resolveFieldSuffixLogicOperator(RuleLogicOperator operator){
        return !operator.equals(RuleLogicOperator.CONTAINS) ? capitalize(getOperation(operator)) : "";
    }

    public static String getOperation(RuleLogicOperator operator){
        switch(operator){
            case EQUAL -> {
                return EQ_OPERATION;
            }
            case NOT_EQUAL -> {
                return NE_OPERATION;
            }
            case CONTAINS -> {
                return CONTAINS_OPERATION;
            }
            case GREATER -> {
                return GT_OPERATION;
            }
            case GREATER_EQUAL -> {
                return GOE_OPERATION;
            }
            case LOWER -> {
                return LT_OPERATION;
            }
            case LOWER_EQUAL -> {
                return LOE_OPERATION;
            }
            case IN -> {
                return IN_OPERATION;
            }
            case NOT_IN -> {
                return NOT_IN_OPERATION;
            }
            case LIKE -> {
                return LIKE_OPERATION;
            }
            case NOT_LIKE -> {
                return NOT_LIKE_OPERATION;
            }
            case BETWEEN -> {
                return BETWEEN_OPERATION;
            }
            case BEFORE -> {
                return BEFORE_OPERATION;
            }
            case AFTER -> {
                return AFTER_OPERATION;
            }
        }
        return EMPTY;
    }
}
