package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CureDto;
import pl.edu.pwsztar.domain.entity.Cure;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class CureMapper implements Convert<Cure, CureDto> {
    @Override
    public CureDto convert(Cure cure){
        CureDto cureDto = new CureDto();

        cureDto.setCureId(cure.getCureId());
        cureDto.setDose(cure.getDose());
        cureDto.setName(cure.getName());
        cureDto.setType(cure.getType());

        return cureDto;
    }
}
