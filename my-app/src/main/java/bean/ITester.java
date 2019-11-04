package bean;

import javax.ejb.Remote;

@Remote
public interface ITester {
    String whoAmI();
}
