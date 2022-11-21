package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // 508
        // c3 = 1
        // c17 = 15
        StringBuffer stringBuffer = new StringBuffer ();
        stringBuffer.append ("sdfjk sdknfsn kjfkl sd sjjw akdksldaskl qqqq");
        System.out.println (replace (stringBuffer, 4, new StringBuffer ("aaaa")));
    }

    public static StringBuffer replace (StringBuffer stringBuffer, int length, StringBuffer str) {
        List<String> wordsWithNeededLength = findWords (stringBuffer, length);
        wordsWithNeededLength.stream ()
                .mapToInt (stringBuffer::indexOf)
                .forEach (index -> stringBuffer.replace (index, index + length, str.toString ()));
        return stringBuffer;
    }

    private static List<String> findWords (StringBuffer stringBuffer, int length) {
        List<String> wordList = Arrays.asList (stringBuffer
                        .toString ()
                        .split (" "));
        List<String> wordsWithNeededLength = wordList.stream()
                .filter (word -> word.length () == length)
                .collect(Collectors.toList());
        return wordsWithNeededLength;
    }
}
