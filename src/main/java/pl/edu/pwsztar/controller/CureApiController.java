package pl.edu.pwsztar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.dto.cure.CureDto;
import pl.edu.pwsztar.service.ClientDoseService;
import pl.edu.pwsztar.service.CureService;

import java.util.List;

@Controller
@RequestMapping(value = "/api/cure")
public class CureApiController {
    private final CureService cureService;
    private final ClientDoseService clientDoseService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CureApiController.class);


    @Autowired
    public CureApiController(ClientDoseService clientDoseService, CureService cureService){
        this.cureService=cureService;
        this.clientDoseService = clientDoseService;
    }

    @CrossOrigin
    @PostMapping(value = "/{userId}/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> createCure(@PathVariable Long userId, @RequestBody CureDto cure) {
        boolean result;

        result = cureService.createNewCure(userId, cure);
        LOGGER.info("Medicine was created " + result);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{userId}/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> deleteCure(@PathVariable Long userId, @RequestBody CureDto cure) {

        cureService.deleteCure(userId,cure);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{userId}/allCures", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getCure(@PathVariable Long userId) {
        List<CureDto> data = null;

        data = clientDoseService.getAllCure(userId);


        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
