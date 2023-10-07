package br.com.griomirium.api.domain.pbbg;

import br.com.griomirium.api.domain.core.CoreBase;

public class GameLoop {

//    public List<CoreBase> gameLoop(List<CoreBase> coreBaseList){
//
//        return updatedCoreBaseList;
//    }

    public void updateCore(CoreBase core){
        core.updateExp();
    }


}
