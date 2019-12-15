package mapper;

import org.modelmapper.ModelMapper;

public class Ticket {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.Ticket ticketDTO = new contract.dto.Ticket();

    entities.Ticket ticket = modelMapper.map(ticketDTO, entities.Ticket.class);

}
