package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String[] splitByBrace = signatureString.split("[()]");
        if(splitByBrace.length > 1) {
            String[] splitByComma = splitByBrace[1].split(", ");
            for (String s : splitByComma) {
                String[] splitByCommaAndBySpace = s.split(" ");
                arguments.add(new MethodSignature.Argument(splitByCommaAndBySpace[0], splitByCommaAndBySpace[1]));
            }
        }
        MethodSignature methodSignature;
        String[] splitBySpace = splitByBrace[0].split(" ");
        if(splitBySpace.length > 2) {
            methodSignature = new MethodSignature(splitBySpace[2], arguments);
            methodSignature.setAccessModifier(splitBySpace[0]);
            methodSignature.setReturnType(splitBySpace[1]);
        } else{
            methodSignature = new MethodSignature(splitBySpace[1], arguments);
            methodSignature.setReturnType(splitBySpace[0]);
        }
        return methodSignature;
    }
}
