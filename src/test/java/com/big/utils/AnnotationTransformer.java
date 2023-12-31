package com.big.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
public class AnnotationTransformer implements IAnnotationTransformer {
    @Override// removed by me on 7-Nov
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(TestNgRetryFailedTest.class);
    }
}
