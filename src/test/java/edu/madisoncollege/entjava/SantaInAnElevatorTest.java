package edu.madisoncollege.entjava;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by craigwilson on 9/14/16.
 */
public class SantaInAnElevatorTest {




    @Test
    public void testFindSantasFloorNumber() throws Exception {

        SantaInAnElevator test = new SantaInAnElevator();

        assertEquals("Wrong floor number.", 138, test.findSantasFloorNumber());


    }

}