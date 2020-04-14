package pl.pwsztar.edu.service;

import pl.pwsztar.edu.domain.entity.Client;

public interface MedicineService {
    void register(Client personal);
    boolean login(Client personal);
}
