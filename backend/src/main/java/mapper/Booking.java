package mapper;

import org.modelmapper.ModelMapper;

public class Booking {
    contract.dto.Booking bookingDTO = new contract.dto.Booking();

    ModelMapper modelMapper = new ModelMapper();
    entities.Booking booking = modelMapper.map(bookingDTO, entities.Booking.class);
}
