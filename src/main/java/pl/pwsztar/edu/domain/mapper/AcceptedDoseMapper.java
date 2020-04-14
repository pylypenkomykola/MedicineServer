package pl.pwsztar.edu.domain.mapper;

import org.springframework.stereotype.Component;
import pl.pwsztar.edu.domain.dto.AcceptedDoseDto;
import pl.pwsztar.edu.domain.entity.AcceptedDose;
import pl.pwsztar.edu.domain.mapper.converter.Convert;

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
