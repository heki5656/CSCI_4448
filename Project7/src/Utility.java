package Project7.src;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.*;

public interface Utility {
    // https://www.baeldung.com/java-generating-random-numbers-in-range
    // Referenced this source that was included in Professor Montgomery's implementation
    static int rndFromRange(int min, int max) {
        //returns a uniform inclusive random number from a given min and max range
        return (int) ((Math.random() * ((max+1) - min)) + min);
    }
}
