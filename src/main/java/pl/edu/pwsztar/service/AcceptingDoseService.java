package pl.edu.pwsztar.service;

import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.cure.CureDto;


public interface AcceptingDoseService {
    boolean acceptingCure(Long userId, CureDto cure);
}
