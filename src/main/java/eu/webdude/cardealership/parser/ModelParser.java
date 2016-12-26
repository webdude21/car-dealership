package eu.webdude.cardealership.parser;

import org.modelmapper.PropertyMap;

import java.util.List;

public interface ModelParser {
	<S, D> D convert(S source, Class<D> destination);

	<S, D> List<D> convert(List<S> source, Class<D> destination);

	<S, D> List<D> convert(List<S> source, Class<D> destination, PropertyMap<S, D> propertyMap);

	<S, D> D convert(S source, Class<D> destination, PropertyMap<S, D> propertyMap);
}
