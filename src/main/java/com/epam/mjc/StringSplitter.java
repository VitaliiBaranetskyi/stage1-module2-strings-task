package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public static List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        list.add(source);
        for(String delim : delimiters){
            for (String s : list) {
                StringTokenizer stringTokenizer = new StringTokenizer(s, delim);
                listTwo.remove(s);
                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                    listTwo.add(token);
                }
            }
            list.clear();
            list.addAll(listTwo);
        }
        return list;
    }
}
