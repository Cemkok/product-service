package com.eliatech.stockmanagement.productservice.exception.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.eliatech.stockmanagement.productservice.enums.Language;
import com.eliatech.stockmanagement.productservice.exception.enums.IFriendlyMessageCode;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
@Slf4j
//Bu anatasyon kullanıldığında class final olarak işaretlenir classtaki 
//bütün metodlar inner classlar ve instance variablelar static olarak işaretleniyor
@UtilityClass 
public class FriendlyMessageUtils {
	
	   private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FriendlyMessageUtils.class);
	
	private static final String RESOURCE_BUNDLE_NAME="FriendlyMessage";
	private static final String SPECIAL_CHARACTER="__";
	
	public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode) {
		String messageKey = null;
		
		try {
			Locale locale = new Locale (language.name());
			ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
			messageKey= messageCode.getClass().getSimpleName() +SPECIAL_CHARACTER+ messageCode;
			
			return resourceBundle.getString(messageKey);
			
			
		} catch (MissingResourceException missingResourceException) {
			log.error("Friendly message not found for key :{}", messageKey);
			return null;
		}
	}

}
