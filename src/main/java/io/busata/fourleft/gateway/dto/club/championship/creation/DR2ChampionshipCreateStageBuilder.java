package io.busata.fourleft.gateway.dto.club.championship.creation;

import io.busata.fourleft.club.championship.creator.StageConditionOption;
import io.busata.fourleft.club.championship.creator.StageOption;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class DR2ChampionshipCreateStageBuilder {

        @Setter
        StageOption route;
        @Setter
        ServiceArea serviceArea = ServiceArea.MEDIUM;
        @Setter
        SurfaceDegradation degradation = SurfaceDegradation.NONE;

        @Setter
        StageConditionOption stageConditionOption = null;

        public static DR2ChampionshipCreateStageBuilder stage() {
            return new DR2ChampionshipCreateStageBuilder();
        }

        public DR2ChampionshipCreateStage build() {
                if(stageConditionOption == null) {
                        throw new RuntimeException("Requires stage condition");
                }

                return new DR2ChampionshipCreateStage(
                        route.id(),
                        serviceArea.id(),
                        degradation.degradation(),
                        stageConditionOption.getConditionId()
                );
        }

}
