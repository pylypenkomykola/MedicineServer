package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.cure.CureDto;
import pl.edu.pwsztar.domain.entity.Cure;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class CureMapper implements Convert<CureDto, Cure> {
    @Override
    public Cure convert(CureDto cure){
        return new Cure.Builder()
                .name(cure.getName())
                .dose(cure.getDose())
                .dailyDose(cure.getDailyDose())
                .doseNumber(cure.getDoseNumber())
                .doseTimestamp(cure.getDoseTimestamp())
                .acceptedDose(cure.getAcceptedDose())
                .build();
    }
}
