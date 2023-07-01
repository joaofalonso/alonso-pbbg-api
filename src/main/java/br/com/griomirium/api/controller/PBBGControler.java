package br.com.griomirium.api.controller;

import br.com.griomirium.api.core.CoreBase;
import br.com.griomirium.api.core.CoreRepository;
import br.com.griomirium.api.pbbg.GameLoop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pbbg")
public class PBBGControler {

    @Autowired
    private CoreRepository coreRepository;

    @GetMapping
    @Transactional
    public void gameLoop(){
        var gameLoop = new GameLoop();

        List<CoreBase> coreBaseList = this.coreRepository.findAll();
        for (CoreBase c: coreBaseList) {
            c.consumeFood();
            c.updateExp();
            c.produceResources();
        }


    }

}
