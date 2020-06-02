package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.cure.AcceptedDoseDto;
import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class AcceptedDoseMapper implements Convert<AcceptedDoseDto, AcceptedDose> {
    @Override
    public AcceptedDose convert(AcceptedDoseDto acceptedDose){
        return new AcceptedDose.Builder()
                .accepted(acceptedDose.isAccepted())
                .delayed(acceptedDose.isDelayed())
                .build();
    }
}
