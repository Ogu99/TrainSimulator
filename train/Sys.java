/*
 * This class is part of the "Train Simulation" application.
 * Copyright (c) 2020, Ogu99
 */

package train;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringJoiner;

/**
 * Heavy Modification of an internal (and private) utility-class for input/output
 * operations provided by the "Karlsruher Institute for Technology".
 * Credits for the original (and not published file) goes to them.
 * 
 * @author Ogu99
 * @author  ITI, VeriAlg Group
 * @author  IPD, SDQ Group
 * @version 1.1 (there Version 5.03, 2016/05/07)
 */
public final class Sys {

    /**
     * {@link BufferedReader} to read input through the command line and also to read
     * input files.
     */
    private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Whitespace constant.
     */
    private static final String WHITESPACE = " ";

    /**
     * Block object generation.
     */
    private Sys() {
        throw new IllegalAccessError("you cannot instantiate this class!");
    }
    
    /**
     * Behaves exactly as <b>System.out.println(Object)</b>. Prints the objects
     * string representation to the console.
     * 
     * @param o - The object to print.
     * @see String#valueOf(Object)
     */
    public static void ln(final Object o) {
        System.out.println(o);
    }
    
    /**
     * Behaves exactly as <b>System.err.println(String)</b>. Prints an
     * error message to the console. 
     * 
     * @param message - The error message.
     */
    public static void err(final String message) {
        System.err.println(message);
    }
    
    /**
     * Behaves exactly as <b>System.err.println(String)</b>. Prints an
     * error message to the console.
     * It provides the possibility to add a prefix to the error message, separated
     * with a whitespace.
     * 
     * @param prefix - The prefix of the message.
     * @param message - The error message.
     */
    public static void err(final String prefix, final String message) {
        err(prefix + WHITESPACE + message);
    }
    
    /**
     * Reads a line of text. A line is considered to be terminated by any one of a line feed ('\n'), a carriage return
     * ('\r'), or a carriage return followed immediately by a linefeed.
     *
     * @return a {@code String} containing the contents of the line, not including any line-termination characters, or
     *         {@code null} if the end of the stream has been reached
     */
    public static String read() {
        try {
            return IN.readLine();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Reads the file with the specified path and returns its content stored in a {@code String} array, whereas the
     * first array field contains the file's first line, the second field contains the second line, and so on.
     *
     * @param  path the path of the file to be read
     * @return the content of the file stored in a {@code String} array
     */
    public static String[] readFile(final String path) {
        try (final BufferedReader r = new BufferedReader(new FileReader(path))) {
            return r.lines().toArray(String[]::new);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Joins the given strings by the given delimeter and returns the
     * newly created string. Every element is separated by the delimeter and
     * at the end of the last element is no delimeter added.
     * This method uses whitespaces as delimeter automatically.
     * 
     * @param strings
     * @return the joined strings
     * 
     * @deprecated Due to shadowing problems.
     */
    @Deprecated
    public static String join() {
        throw new IllegalAccessError("not implemented due to problems");
    }
    
    /**
     * Joins the given strings by the given delimeter and returns the
     * newly created string. Every element is separated by the delimeter and
     * at the end of the last element is no delimeter added.
     * 
     * @param delimeter - The delimeter.
     * @param strings - The string to join.
     * @return the joined strings.
     */
    public static String join(final String delimeter, final Object... objects) {
        final StringJoiner join = new StringJoiner(delimeter);
        for (final Object o : objects) {
            join.add(o.toString());
        }
        return join.toString();
    }
    
    /**
     * The Sys class also provides functionality for working with {@link java.util.regex.Pattern}.
     * It can create pattern and match them with other strings.
     */
    public static final class Pattern {
    	/**
    	 * Creates a new pattern.
    	 * 
    	 * @param pattern - The pattern to create.
    	 * @return a new pattern.
    	 */
        public static java.util.regex.Pattern of(final String pattern) {
            return java.util.regex.Pattern.compile(pattern);
        }
        
        /**
         * Matches the given pattern with the given string.
         * 
         * @param pattern - The pattern to use.
         * @param s - The string to match.
         * @return {@code true} if the string matches the pattern otherwise {@code false}.
         */
        public static boolean matches(final java.util.regex.Pattern pattern, final String s) {
            return pattern.matcher(s).matches();
        }
    }
}
