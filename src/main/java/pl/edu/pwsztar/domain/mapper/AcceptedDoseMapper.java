package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.AcceptedDoseDto;
import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class AcceptedDoseMapper implements Convert<AcceptedDose, AcceptedDoseDto> {
    @Override
    public AcceptedDoseDto convert(AcceptedDose acceptedDose){
        AcceptedDoseDto acceptedDoseDto = new AcceptedDoseDto();

        acceptedDoseDto.setAccepted(acceptedDose.isAccepted());
        acceptedDoseDto.setDelayed(acceptedDose.isDelayed());
        acceptedDoseDto.setClient(acceptedDose.getClient());
        acceptedDoseDto.setId(acceptedDose.getId());

        return acceptedDoseDto;
    }
}
