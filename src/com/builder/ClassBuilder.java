package com.builder;

import java.io.File;

import static com.builder.constant.BuilderConstants.*;
import static com.builder.support.BuilderSupport.*;
import static com.builder.support.FileSupport.*;
import static com.builder.support.Support.*;

public class ClassBuilder {
	private static File modelOutputFile;
	private static File serviceOutputFile;
	private static File repositoryOutputFile;
	private static File controllerOutputFile;
	private static File expressionsOutputFile;

	private static final boolean BUILD_MODEL=false;
	private static final boolean BUILD_SERVICE=false;
	private static final boolean BUILD_REPOSITORY=false;
	private static final boolean BUILD_CONTROLLER=false;
	private static final boolean BUILD_EXPRESSIONS=true;
	
	public static void main(String[] args) {
		File file = prepareDirectory(CLASS_PATH);
		prepareDirectory(TEMPLATES_PATH);
		prepareDirectory(OUTPUT_PATH);
		if(BUILD_MODEL){
			prepareDirectory(MODEL_OUTPUT_PATH);
		}
		if(BUILD_SERVICE){
			prepareDirectory(SERVICE_OUTPUT_PATH);
		}
		if(BUILD_REPOSITORY){
			prepareDirectory(REPOSITORY_OUTPUT_PATH);
		}
		if(BUILD_CONTROLLER){
			prepareDirectory(CONTROLLER_OUTPUT_PATH);
		}
		String[] classes = file.list();
		File classFile;
		String className;
		for(String cl : classes) {
			className = cl.substring(0, cl.indexOf("."));
			classFile = prepareFile(CLASS_PATH + "/" + cl, true, false, false);
			if(BUILD_MODEL){
				modelOutputFile = prepareFile(MODEL_OUTPUT_PATH + "/" + toDashCase(className).toLowerCase() + MODEL_EXTENSION, false, true);
			}
			if(BUILD_SERVICE){
				serviceOutputFile = prepareFile(SERVICE_OUTPUT_PATH + "/" + toDashCase(className).toLowerCase() + SERVICE_EXTENSION, false, true);
			}
			if(BUILD_REPOSITORY){
				repositoryOutputFile = prepareFile(REPOSITORY_OUTPUT_PATH + "/" + capitalize(className) + REPOSITORY_EXTENSION, false, true);
			}
			if(BUILD_CONTROLLER){
				controllerOutputFile = prepareFile(CONTROLLER_OUTPUT_PATH + "/" + capitalize(className) + CONTROLLER_EXTENSION, false, true);
			}
			if(BUILD_EXPRESSIONS){
				expressionsOutputFile = prepareFile(EXPRESSIONS_OUTPUT_PATH + "/" + capitalize(className) + EXPRESSIONS_EXTENSION, false, true);
			}
			if(classFile.canRead()) {
				if(BUILD_MODEL && modelOutputFile.canWrite()){
					buildModel(modelOutputFile, classFile,className);
				}
				if(BUILD_SERVICE && serviceOutputFile.canWrite()){
					buildService(serviceOutputFile, className);
				}
				if(BUILD_REPOSITORY && repositoryOutputFile.canWrite()){
					buildRepository(repositoryOutputFile, className);
				}
				if(BUILD_CONTROLLER && controllerOutputFile.canWrite()){
					buildController(controllerOutputFile, className);
				}
				if(BUILD_EXPRESSIONS && expressionsOutputFile.canWrite()){
					buildExpressions(expressionsOutputFile,classFile,className);
				}
			}else {
				System.out.print("Permission error");
				return; 
			}
		}
	}
}
