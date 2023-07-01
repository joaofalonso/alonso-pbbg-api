package br.com.griomirium.api.core;

public record CoreBaseList(String name, int base_level, CoreElementType coreElementType, int gold, int food, double exp) {

    public CoreBaseList(CoreBase coreBase){
        this(coreBase.getName(), coreBase.getBaseLevel(), coreBase.getCoreElementType(), coreBase.getGold(), coreBase.getFood(), coreBase.getExp());

    }

}
