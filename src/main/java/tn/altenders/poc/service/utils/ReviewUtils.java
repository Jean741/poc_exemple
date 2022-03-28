package tn.altenders.poc.service.utils;

import java.util.List;

import org.springframework.util.CollectionUtils;

import tn.altenders.poc.entities.Element;

public final class ReviewUtils {
	private ReviewUtils() {
	}

	public static void getAllChildElements(Element element, List<Element> childElements) {
		childElements.add(element);
		List<Element> childElts = element.getChildElements();
		if (!CollectionUtils.isEmpty(childElts)) {
			childElts.forEach(childElement->getAllChildElements(childElement, childElements));
		}
	}
}
