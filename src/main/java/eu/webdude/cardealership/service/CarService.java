package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.viewmodel.CarViewModel;

public interface CarService {
	Iterable<CarViewModel> getCarsAvailableForPurchase();
}
