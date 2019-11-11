package bean;


import contract.dto.Airplane;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "Tester")
public class Tester implements ITester {

    @Resource
    private SessionContext context;

    @Override
    public String whoAmI(){
        return "I am Backend!";
    }
}
