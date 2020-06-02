package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.cure.CureDto;

public interface CureService {
    boolean createNewCure(Long userId, CureDto cure);
    void deleteCure(Long userId, CureDto cure);

}
