package io.busata.fourleft.club.domain;

import io.busata.fourleft.gateway.dto.club.DR2ClubResultChampionshipEventStage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StageFactory {

    public Stage createStage(DR2ClubResultChampionshipEventStage resultStage) {
        Stage stage = new Stage();
        stage.setReferenceId(Long.valueOf(resultStage.id()));
        stage.setName(resultStage.name());
        return stage;
    }
}
