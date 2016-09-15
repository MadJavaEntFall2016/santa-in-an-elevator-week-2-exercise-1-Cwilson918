package edu.madisoncollege.entjava;

import org.apache.log4j.*;



import java.io.*;
import java.util.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application, you will use only unit tests to find the answer.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<String> getFloorDirections() {

        List<String> floorDirections = new ArrayList<String>();


        try {

            ClassLoader loader = getClass().getClassLoader();
            File inputFile = new File(loader.getResource("SantaUpDown.txt").getFile());
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            while (reader.ready()) {
                floorDirections = Arrays.asList(reader.readLine().split(""));
            }

        } catch (FileNotFoundException fnfe) {
            logger.info("File not found exception.");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            logger.info("IO exception.");
            ioe.printStackTrace();
        } catch (Exception e) {
            logger.info("General Error.");
            e.printStackTrace();
        }

        return floorDirections;
    }

    public int getFloor(List<String> floorDirections) {

        int floorNumber = 0;

        for (String floorDirection : floorDirections) {
            if (floorDirection.equals("(")) {
                floorNumber++;
            } else if (floorDirection.equals(")")) {
                floorNumber--;
            }
        }

        return floorNumber;
    }

    public int findSantasFloorNumber() {

        int santasFloorNumber = getFloor(getFloorDirections());
        logger.info("Santas floor is: " + getFloor(getFloorDirections()));

        return santasFloorNumber;
    }

}
