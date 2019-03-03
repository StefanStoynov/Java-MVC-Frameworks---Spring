package realestate.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.domain.entities.Offer;
import realestate.domain.models.service.OfferServiceModel;
import realestate.repository.OfferRepository;

import javax.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }


    @Override
    public void offerRegister(OfferServiceModel offerServiceModel) {
        if (this.validator.validate(offerServiceModel).size()!=0){
            throw new IllegalArgumentException("Validation failed!");
        }

        this.offerRepository.saveAndFlush(this.modelMapper.map(offerServiceModel, Offer.class));
    }

    @Override
    public List<OfferServiceModel> findAllOffers() {

        List<OfferServiceModel> offers = this.offerRepository.findAll()
                .stream()
                .map(o-> this.modelMapper.map(o,OfferServiceModel.class))
                .collect(Collectors.toList());
        return offers;
    }
}
