package br.com.griomirium.api.pbbg;

import br.com.griomirium.api.core.CoreBase;
import br.com.griomirium.api.core.CoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {

//    public List<CoreBase> gameLoop(List<CoreBase> coreBaseList){
//
//        return updatedCoreBaseList;
//    }

    public void updateCore(CoreBase core){
        core.updateExp();
    }


}
