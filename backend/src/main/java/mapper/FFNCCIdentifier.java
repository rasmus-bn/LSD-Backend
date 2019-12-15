package mapper;

import contract.dto.FFNCCIdenitfier;
import entities.Booking;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class FFNCCIdentifier {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.FFNCCIdenitfier ffnccIdenitfiertDTO = new contract.dto.FFNCCIdenitfier();

    PropertyMap<Booking, FFNCCIdenitfier> ffnccMap = new PropertyMap<Booking, FFNCCIdenitfier>() {
        @Override
        protected void configure() {
            map().setFfcc(source.getFnncc());
        }
    };
}
