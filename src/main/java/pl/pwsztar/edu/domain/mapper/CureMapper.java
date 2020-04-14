package pl.pwsztar.edu.domain.mapper;

import org.springframework.stereotype.Component;
import pl.pwsztar.edu.domain.dto.CureDto;
import pl.pwsztar.edu.domain.entity.Cure;
import pl.pwsztar.edu.domain.mapper.converter.Convert;

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
