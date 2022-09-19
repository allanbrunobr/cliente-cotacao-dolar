package br.com.abruno.client.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.abruno.client.exceptions.DataInvalidaException;

public class Utils {

	public static final String formatoData = "MM-dd-yyyy";


	public static String periodoValido(String data) throws ParseException, DataInvalidaException {

		try {

			Date convertedDataFinal = new SimpleDateFormat(formatoData).parse(data);
			Date dataAnterior = new Date(convertedDataFinal.getTime() - 86400000);

			GregorianCalendar gcDtFinal = new GregorianCalendar();
			gcDtFinal.setTime(convertedDataFinal);
			int diaSemanaDtFinal = gcDtFinal.get(Calendar.DAY_OF_WEEK);

			GregorianCalendar gcDtInicial = new GregorianCalendar();
			gcDtInicial.setTime(dataAnterior);
			int diaSemanaDtInicial = gcDtInicial.get(Calendar.DAY_OF_WEEK);

			if (diaSemanaDtFinal == Calendar.SATURDAY || diaSemanaDtFinal == Calendar.SUNDAY
					|| diaSemanaDtInicial == Calendar.SATURDAY
					|| diaSemanaDtInicial == Calendar.SUNDAY) {
				throw new DataInvalidaException("Data inválida");
			}

		} catch (DataInvalidaException ex) {
			throw new DataInvalidaException(
					"Data inválida. Nem a data da consulta e nem a data anterior pode ser num fim-de-semana", ex);
		}

		catch (ParseException | DateTimeParseException ex) {
			throw new DataInvalidaException("Data inválida. O formato é " + formatoData + ", ex");
		}

		return data;

	}

	public static String dataValida(String data) throws ParseException, DataInvalidaException {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoData);
			Date convertedDataFinal = new SimpleDateFormat("MM-dd-yyyy").parse(data.replace("\'", ""));

			GregorianCalendar gcDtFinal = new GregorianCalendar();
			gcDtFinal.setTime(convertedDataFinal);
			int diaSemanaDtFinal = gcDtFinal.get(GregorianCalendar.DAY_OF_WEEK);

			if (diaSemanaDtFinal == GregorianCalendar.SATURDAY || diaSemanaDtFinal == GregorianCalendar.SUNDAY) {
				throw new DataInvalidaException("Data inválida");
			}

		} catch (ParseException ex) {
			throw new DataInvalidaException(
					"Data inválida. O formato é MM-dd-yyyy e a data não pode ser em fim-de-semana");
		}

		catch (DateTimeParseException ex) {
			throw new DataInvalidaException("Data inválida. O formato é MM-dd-yyyy");
		}

		return "\'" + data + '\'';

	}

}
