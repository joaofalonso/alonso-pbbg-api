package br.com.griomirium.api.domain.core;

public record UpdatedCoreBase(Long id, String name, int baseLevel) {

    public UpdatedCoreBase(CoreBase c){
        this(c.getId(), c.getName(), c.getBaseLevel());
    }
}
