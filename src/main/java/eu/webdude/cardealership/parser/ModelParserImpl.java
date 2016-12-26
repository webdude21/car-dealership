package eu.webdude.cardealership.parser;

import eu.webdude.cardealership.domain.entity.Car;
import eu.webdude.cardealership.domain.viewmodel.CarViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelParserImpl implements ModelParser {

	private ModelMapper modelMapper;

	public ModelParserImpl() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.addMappings(new PropertyMap<Car, CarViewModel>() {
			@Override
			protected void configure() {
				map(source.getModel().getName(), destination.getModel());
			}
		});
	}

	@Override
	public <S, D> D convert(S source, Class<D> destination) {
		return this.modelMapper.map(source, destination);
	}

	@Override
	public <S, D> List<D> convert(List<S> source, Class<D> destination) {
		List<D> convertedList = new ArrayList<D>();
		for (S s : source) {
			D convertedType = this.modelMapper.map(s, destination);
			convertedList.add(convertedType);
		}

		return convertedList;
	}

	@Override
	public <S, D> List<D> convert(List<S> source, Class<D> destination, PropertyMap<S, D> propertyMap) {
		this.modelMapper.addMappings(propertyMap);
		List<D> convertedList = new ArrayList<D>();
		for (S s : source) {
			D convertedType = this.modelMapper.map(s, destination);
			convertedList.add(convertedType);
		}

		return convertedList;
	}

	@Override
	public <S, D> D convert(S source, Class<D> destination, PropertyMap<S, D> propertyMap) {
		this.modelMapper.addMappings(propertyMap);
		return this.modelMapper.map(source, destination);
	}
}
