import entities.dto.Airplane;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @org.junit.jupiter.api.Test
    void userToDto(){
        entities.dto.User eu = new entities.dto.User(62, "admin", "admin");
        contract.dto.User u = eu.toDto();
        System.out.println(u);
        assertEquals(u.getUserName(), new contract.dto.User(0, 62, "admin", "admin").getUserName());
    }

    @org.junit.jupiter.api.Test
    void airplaneToDto(){
        entities.dto.Airplane ea = new Airplane(200, "aba");
        contract.dto.Airplane a = ea.toDto();
        assertEquals(ea.getIata(), new Airplane(a).getIata());
    }

}
