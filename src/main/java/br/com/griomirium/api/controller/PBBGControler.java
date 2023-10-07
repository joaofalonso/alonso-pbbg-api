package br.com.griomirium.api.controller;

import br.com.griomirium.api.domain.core.CoreBase;
import br.com.griomirium.api.domain.core.CoreRepository;
import br.com.griomirium.api.domain.pbbg.GameLoop;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pbbg")
@SecurityRequirement(name = "bearer-key")
public class PBBGControler {

    @Autowired
    private CoreRepository coreRepository;

    @GetMapping
    @Transactional
    public ResponseEntity gameLoop(){
        var gameLoop = new GameLoop();

        List<CoreBase> coreBaseList = this.coreRepository.findAll();
        for (CoreBase c: coreBaseList) {
            c.consumeFood();
            c.updateExp();
            c.produceResources();
        }

        return  ResponseEntity.ok().body(coreBaseList);
    }

}
