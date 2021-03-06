package io.busata.fourleft.club.championship.creator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeightedOccurenceSelectorTest {


    @Test
    public void testWeightedOccurrence() {
        WeightedOccurenceSelector selector = new WeightedOccurenceSelector();


        selector.generate(Arrays.asList(CountryOption.values()),
                List.of(
                        CountryOption.POLAND,
                        CountryOption.FINLAND,
                        CountryOption.ARGENTINA,
                        CountryOption.SWEDEN,
                        CountryOption.WALES,
                        CountryOption.SWEDEN,
                        CountryOption.POLAND,
                        CountryOption.POLAND,
                        CountryOption.NEW_ZEALAND

                ), 13);
    }
}