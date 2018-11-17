package com.jv.test.sameClass;

import com.jv.sameClass.SameClass;

public class TestSameNameClassFromTwoScope {

    public static void main(String args[]){
        SameClass.sameMethod();

        //With java 8, will fail at runtime on the second method because the first is specified at provided and
        //only SameClass of sameClassRuntime is disponible at runtime.
        //With java 9 and module path, with requires static, the application will run and not even found the
        //first method because it will wait for the specific class of the module path and not the version
        //found at runtime in Maven. So it will throws a ClassNotFoundException.
        //With java 9 and module path, with requires without static it will fail
        SameClass.methodOfProvided();
    }

}
