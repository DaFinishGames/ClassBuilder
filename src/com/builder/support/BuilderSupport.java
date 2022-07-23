package com.builder.support;

import com.querydsl.core.types.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import static com.builder.constant.BuilderConstants.*;
import static com.builder.support.FileSupport.*;
import static com.builder.support.RuleExpressionResolver.*;
import static com.builder.support.Support.*;

public class BuilderSupport {


    public static void buildExpressions(File expressionOutputFile, File classFile,String className){
        try {
            writeLine(expressionOutputFile,"package com.play.performance.Play.Performance.Expressions;\n\n");
            writeLine(expressionOutputFile,"import com.play.performance.Play.Performance.DataObjects.Q" + className + ";\n");
            writeLine(expressionOutputFile,"import com.play.performance.Play.Performance.utils.PlayPerformanceUtils;\n");
            writeLine(expressionOutputFile,"import com.querydsl.core.types.Expression;\n");
            writeLine(expressionOutputFile,"import com.querydsl.core.types.dsl.BooleanExpression;\n");
            writeLine(expressionOutputFile,"import java.util.Date;\n");
            writeLine(expressionOutputFile,"import java.util.List;\n\n");
            Scanner scanner = new Scanner(classFile);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains(PRIVATE_PREFIX)) {
                    line = cleanLine(line);
                    String[] splittedLine = line.split(" ");
                    if(splittedLine.length >= 2) {
                        writeLine(expressionOutputFile, buildExpressionMethodsForVariableOfType(className,  splittedLine[1],splittedLine[0]));
                    }
                }else if(line.contains(CLASS_PREFIX)){
                    writeLine(expressionOutputFile, PUBLIC_PREFIX + CLASS_PREFIX + className + EXPRESSIONS_SUFFIX+  " {\n\n");
                    writeLine(expressionOutputFile, buildExpressionField(className));
                }
            }
            writeLine(expressionOutputFile, "}");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("file cannot be found?");
        }
    }

    public static void buildModel(File modelOutputFile, File classFile, String className){
        try {
            Scanner scanner = new Scanner(classFile);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains(PRIVATE_PREFIX)) {
                    line = cleanLine(line);
                    String[] splittedLine = line.split(" ");
                    if(splittedLine.length >= 2) {
                        writeLine(modelOutputFile, buildAngularVariableOfType(splittedLine[1],splittedLine[0]));
                    }
                }else if(line.contains(CLASS_PREFIX)){
                    writeLine(modelOutputFile, "export class " + className + "{\n");
                }
            }
            writeLine(modelOutputFile, "}");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("file canot be found?");
        }
    }

    public static void buildTemplate(String templateFileName,String[] placeholders, String[] values, File targetFile) {
        File templateFile = prepareFile(TEMPLATES_PATH + "/" + templateFileName, true, false, false);
        String template = getTemplate(templateFile);
        writeLine(targetFile, replaceTemplatePlaceHolderInBulk(template, placeholders, values));
    }

    public static void buildService(File serviceOutputFile, String className) {
        String[] placeholders = new String[] {
                CLASSNAME_DASH_REJEX,
                CLASSNAME_REJEX,
                CLASSNAME_UPPERCASE_REJEX
        };
        String[] values = new String[] {
                toDashCase(className).toLowerCase(),
                className,
                toUnderlineCase(className).toUpperCase()
        };
        buildTemplate(SERVICE_TEMPLATE_FILE_NAME, placeholders, values, serviceOutputFile);
    }

    public static void buildRepository(File repositoryOutputFile, String className) {
        String[] placeholders = new String[] {
                CLASSNAME_REJEX,
                TYPE_REJEX
        };
        String[] values = new String[] {
                className,
                Long.class.getSimpleName()
        };
        buildTemplate(REPOSITORY_TEMPLATE_FILE_NAME, placeholders, values, repositoryOutputFile);
    }

    public static void buildController(File controllerOutputFile, String className) {
        String[] placeholders = new String[] {
                CLASSNAME_LOWERCASE_REJEX,
                CLASSNAME_REJEX
        };
        String[] values = new String[] {
                uncapitalize(className),
                className
        };
        buildTemplate(CONTROLLER_TEMPLATE_FILE_NAME, placeholders, values, controllerOutputFile);
    }

    public static String buildAngularVariableOfType(String variableName, String variableType) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(variableName);
        if(variableType.equals(Long.TYPE.getSimpleName()) ||
                variableType.equals(Integer.TYPE.getSimpleName()) ||
                variableType.equals(Double.TYPE.getSimpleName()) ||
                variableType.equals(Float.TYPE.getSimpleName())) {
            sb.append(" : number;\n");
        }else if(variableType.equals(String.class.getSimpleName())) {
            sb.append(" : ");
            sb.append(variableType.toLowerCase());
            sb.append(";\n");
        }else {
            sb.append(" : ");
            sb.append(variableType);
            sb.append(";\n");
        }
        sb.append("\tpublic static readonly ");
        sb.append(transformToField(variableName));
        sb.append(" : string=\"");
        sb.append(variableName);
        sb.append("\";\n");
        return sb.toString();
    }

    public static String buildExpressionMethodsForVariableOfType(String className,String variableName, String variableType) {
        StringBuilder sb = new StringBuilder();
        if(variableType.equals(Long.TYPE.getSimpleName()) ||
                variableType.equals(Integer.TYPE.getSimpleName()) ||
                variableType.equals(Double.TYPE.getSimpleName()) ||
                variableType.equals(Float.TYPE.getSimpleName())||
                variableType.equals(Character.TYPE.getSimpleName())) {
            for(RuleLogicOperator operator : NUMERIC_LOGIC_OPERATORS){
                sb.append(buildExpressionMethod(className, variableName,variableType,operator));
                sb.append(buildExpressionMethod(className, variableName, Expression.class.getSimpleName(),operator));
            }
        }else if(variableType.equals(String.class.getSimpleName())) {
            for(RuleLogicOperator operator : STRING_LOGIC_OPERATORS){
                sb.append(buildExpressionMethod(className, variableName,variableType,operator));
                sb.append(buildExpressionMethod(className, variableName, Expression.class.getSimpleName(),operator));
            }
        }else if(variableType.equals(Boolean.TYPE.getSimpleName())) {
            for(RuleLogicOperator operator : BOOLEAN_LOGIC_OPERATORS){
                sb.append(buildExpressionMethod(className, variableName,variableType,operator));
                sb.append(buildExpressionMethod(className, variableName, Expression.class.getSimpleName(),operator));
            }
        }else if(variableType.equals(Date.class.getSimpleName())) {
            for(RuleLogicOperator operator : DATE_LOGIC_OPERATORS){
                sb.append(buildExpressionMethod(className, variableName,variableType,operator));
                sb.append(buildExpressionMethod(className, variableName, Expression.class.getSimpleName(),operator));
            }
        }else{
            sb.append("variable ");
            sb.append(variableName);
            sb.append("of type ");
            sb.append(variableType);
            sb.append("not supported\n");
        }
        return sb.toString();
    }

    private static String buildExpressionMethod(String className, String variableName, String variableType, RuleLogicOperator operator) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t public static BooleanExpression ");
        sb.append(RuleExpressionResolver.resolveFieldExpression(variableName, operator));
        sb.append("(");
        if((operator.equals(RuleLogicOperator.IN) || operator.equals(RuleLogicOperator.NOT_IN)) && !variableType.equals(Expression.class.getSimpleName())){
            sb.append("List<");
            Class cl = getPrimitiveClass(variableType);
            sb.append(cl != null ? getPrimitiveClass(variableType).getSimpleName() : variableType);
            sb.append("> param");
        }else if(operator.equals(RuleLogicOperator.BETWEEN)){
            sb.append(variableType);
            sb.append(" param1,");
            sb.append(variableType);
            sb.append(" param2");
        }else{
            sb.append(variableType);
            sb.append(" param");
        }
        sb.append(") {\n\t\treturn ");
        sb.append(operator.equals(RuleLogicOperator.BETWEEN) ?
                "PlayPerformanceUtils.isNotEmpty(param1) && PlayPerformanceUtils.isNotEmpty(param2) ":
                "PlayPerformanceUtils.isNotEmpty(param) ");
        sb.append("?  Q");
        sb.append(className);
        sb.append(".");
        sb.append(uncapitalize(className));
        sb.append(".");
        sb.append(variableName);
        sb.append(".");
        sb.append(RuleExpressionResolver.getOperation(operator));
        sb.append("(");
        sb.append(operator.equals(RuleLogicOperator.BETWEEN)? "param1, param2" : "param");
        sb.append(") : null;\n\t }\n\n");
        return sb.toString();
    }

    private static String buildExpressionField(String className) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t public static final Q");
        sb.append(className);
        sb.append(" TABLE = Q");
        sb.append(className);
        sb.append(".");
        sb.append(uncapitalize(className));
        sb.append(";\n\n");
        return sb.toString();
    }


    public static String transformToField(String field) {
        return MODEL_FIELD_PREFIX + toUnderlineCase(field).toUpperCase();
    }
}
