package tn.altenders.poc.service.utils;

import static tn.altenders.poc.contants.PocConstants.DOCUMENT_TEXT_TABULATION;
import static tn.altenders.poc.contants.PocConstants.NEW_LINE;

import java.util.Comparator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import tn.altenders.poc.entities.Element;

public final class DocumentUtils {
	private DocumentUtils() {
	}
	public static String getElementContent(Element element, int profondeur) {
		StringBuilder elementContent = new StringBuilder();
		elementContent=elementContent.append(element.getContent()+" (id :"+element.getId()+")");
		List<Element> childElements = element.getChildElements();
		childElements.sort(Comparator.comparingLong(Element::getId));
		if (CollectionUtils.isEmpty(childElements)) {
			return elementContent.toString();
		}else {
			for (Element childElement : childElements) {
				elementContent.append(NEW_LINE);
				for (int i = 0; i < profondeur; i++) {
					elementContent.append(DOCUMENT_TEXT_TABULATION);
				}
				elementContent.append(getElementContent(childElement,profondeur+1));
			}
			return elementContent.toString();
		}
	}
}
