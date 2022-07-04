package io.busata.fourleft.club.championship.creator;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum VehicleGroups {

    UNPOPULAR(
            VehicleOption.H1_FWD,
            VehicleOption.H2_FWD,
            VehicleOption.F2_KIT_CAR
    ),
    CLASSIC(
            VehicleOption.H2_RWD,
            VehicleOption.H3_RWD
    ),
    MODERN_ALTERNATIVE(
            VehicleOption.R2,
            VehicleOption.RGT
    ),
    MODERN(
            VehicleOption.R5,
            VehicleOption.CC_2000
            ),
    MODERN_CLASSICS(
            VehicleOption.GROUP_A,
            VehicleOption.NR4_R4
    ),
    GROUP_B(
            VehicleOption.GROUP_B_4WD,
            VehicleOption.GROUP_B_RWD
    );

    @Getter
    private final List<VehicleOption> vehicleOptions;

    VehicleGroups(VehicleOption... vehicleOptions) {
        this.vehicleOptions = Arrays.asList(vehicleOptions);
    }

    public boolean containsVehicleOption(VehicleOption option) {
        return this.vehicleOptions.contains(option);
    }

    public static VehicleGroups findGroup(VehicleOption option) {
        return Arrays.stream(VehicleGroups.values()).filter(vehicleOptions -> vehicleOptions.containsVehicleOption(option)).findFirst().orElseThrow();
    }

}
