package com.flymanager.api.engins.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {
	private static MessageSource messageSource;

	public Translator(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public static String translate(String code, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(code, args, locale);
	}
}
