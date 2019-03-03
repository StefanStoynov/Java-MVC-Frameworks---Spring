package realestate.service;

import realestate.domain.models.service.OfferServiceModel;

import java.util.List;

public interface OfferService {

   void offerRegister(OfferServiceModel offerServiceModel);

   List<OfferServiceModel> findAllOffers();
}
