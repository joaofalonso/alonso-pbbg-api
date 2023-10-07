package br.com.griomirium.api.controller;

import br.com.griomirium.api.domain.core.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/core")
@SecurityRequirement(name = "bearer-key")
public class CoreController {

    @Autowired
    private CoreRepository coreRepository;

    @PostMapping
    @Transactional
    public ResponseEntity addCore(@RequestBody CoreRecord core, UriComponentsBuilder uriBuilder){

        CoreBase coreBase = this.coreRepository.save(new CoreBase(core));

        var uri = uriBuilder.path("/core/{id}").buildAndExpand(coreBase.getId()).toUri();

        return ResponseEntity.created(uri).body(new UpdatedCoreBase(coreBase));
    }

    @GetMapping

    public ResponseEntity listCores(@PageableDefault(size = 2, sort = {"name"}) Pageable pageable){
        Page page = this.coreRepository.findAllByActiveTrue(pageable).map(CoreBaseList::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCore(@RequestBody UpdateCoreBase updateCoreBase){
        CoreBase c = this.coreRepository.getReferenceById(updateCoreBase.id());
        c.updateData(updateCoreBase);

        return ResponseEntity.ok(new UpdatedCoreBase(c));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCore(@PathVariable Long id){
        CoreBase c = this.coreRepository.getReferenceById(id);
        c.deactivate();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/core/buy")
    @Transactional
    public ResponseEntity buyUnit(){

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity coreBaseDetail(@PathVariable Long id){
        CoreBase coreBase = this.coreRepository.getReferenceById(id);
        return ResponseEntity.ok(new UpdatedCoreBase(coreBase));
    }
}
