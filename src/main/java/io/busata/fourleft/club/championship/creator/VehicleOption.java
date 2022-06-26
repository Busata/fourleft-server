package io.busata.fourleft.club.championship.creator;

import lombok.Getter;

import java.util.Arrays;

import static io.busata.fourleft.club.championship.creator.VehicleDriveTrain.*;

public enum VehicleOption {

    GROUP_A("eRallyGrpACaps", "Group A", AWD),
    GROUP_B_4WD("eRallyGrpB4wdCaps", "Group B (4WD)", AWD),
    GROUP_B_RWD("eRallyGrpBRwdCaps", "Group B (RWD)", RWD),
    F2_KIT_CAR("eRallyKitcarCaps", "F2 Kit Car", FWD),
    R5("eRallyR5Caps", "R5", AWD),
    CC_2000("eRallyUpTo20004wdCaps", "Up to 2000cc (4WD)", AWD),
    NR4_R4("eRallyNr4R4Caps","NR4/R4", AWD),
    H2_RWD("eRallyH2RwdCaps","H2 RWD", RWD),
    H3_RWD("eRallyH3RwdCaps","H3 RWD", RWD),
    R2("eRallyR2Caps","R2", FWD),
    H2_FWD("eRallyH2FwdCaps", "H2 FWD", FWD),
    H1_FWD("eRallyH1FwdCaps","H1 FWD", FWD),
    RGT("eRallyRGtCaps","Rally GT", RWD);

    @Getter
    private String id;
    private String displayName;

    private VehicleDriveTrain driveTrain;

    VehicleOption(String id, String displayName, VehicleDriveTrain driveTrain) {
        this.id = id;
        this.displayName = displayName;
        this.driveTrain = driveTrain;
    }

    public static VehicleOption findById(String id) {
        return Arrays.stream(VehicleOption.values()).filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().orElseThrow();
    }


    public String id() {
        return this.id;
    }
    public String displayName() {
        return this.displayName;
    }
}
