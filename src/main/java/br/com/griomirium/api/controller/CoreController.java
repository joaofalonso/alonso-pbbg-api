package br.com.griomirium.api.controller;

import br.com.griomirium.api.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core")
public class CoreController {

    @Autowired
    private CoreRepository coreRepository;

    @PostMapping
    @Transactional
    public void addCore(@RequestBody CoreRecord core ){
        this.coreRepository.save(new CoreBase(core));
    }

    @GetMapping

    public Page<CoreBaseList> listCores(@PageableDefault(size = 2, sort = {"name"}) Pageable pageable){
        return this.coreRepository.findAllByActiveTrue(pageable).map(CoreBaseList::new);
    }

    @PutMapping
    @Transactional
    public void updateCore(@RequestBody UpdateCoreBase updateCoreBase){
        CoreBase c = this.coreRepository.getReferenceById(updateCoreBase.id());
        c.updateData(updateCoreBase);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteCore(@PathVariable Long id){
        CoreBase c = this.coreRepository.getReferenceById(id);
        c.deactivate();
    }

}
