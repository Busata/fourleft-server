package io.busata.fourleft.club.championship.creator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CycleOptionsSelectorTest {


    @Test
    public void testBagOccurence() {
        var occurenceSelector = new CycleOptionsSelector();

        var option = occurenceSelector.generate(Arrays.asList(VehicleGroups.values()),
                List.of(
                        VehicleGroups.CLASSIC_FWD,
                        VehicleGroups.CLASSIC,
                        VehicleGroups.MODERN,
                        VehicleGroups.GROUP_B
                        ));

        assertThat(option).isEqualTo(VehicleGroups.MODERN_CLASSICS);
    }
}