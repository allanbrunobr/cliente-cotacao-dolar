package br.com.abruno.client.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.abruno.client.exceptions.DataInvalidaException;

public class Utils {

	public static String periodoValido(String data) throws ParseException, DataInvalidaException {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			LocalDate d = LocalDate.parse(data, formatter);

			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			Date convertedDataFinal = new SimpleDateFormat("MM-dd-yyyy").parse(data);
			Date dataAnterior = new Date(convertedDataFinal.getTime() - 86400000);

			GregorianCalendar gcDtFinal = new GregorianCalendar();
			gcDtFinal.setTime(convertedDataFinal);
			int diaSemanaDtFinal = gcDtFinal.get(GregorianCalendar.DAY_OF_WEEK);

			GregorianCalendar gcDtInicial = new GregorianCalendar();
			gcDtInicial.setTime(dataAnterior);
			int diaSemanaDtInicial = gcDtInicial.get(GregorianCalendar.DAY_OF_WEEK);

			if (diaSemanaDtFinal == GregorianCalendar.SATURDAY || diaSemanaDtFinal == GregorianCalendar.SUNDAY
					|| diaSemanaDtInicial == GregorianCalendar.SATURDAY
					|| diaSemanaDtInicial == GregorianCalendar.SUNDAY) {
				throw new DataInvalidaException("Data inválida");
			}

		} catch (DataInvalidaException ex) {
			throw new DataInvalidaException(
					"Data inválida. Nem a data da consulta e nem a data anterior pode ser num fim-de-semana", ex);
		}

		catch (ParseException ex) {
			throw new DataInvalidaException("Data inválida. O formato é MM-dd-yyyy", ex);
		}

		catch (DateTimeParseException ex) {
			throw new DataInvalidaException("Data inválida. O formato é MM-dd-yyyy", ex);
		}

		return data;

	}

	public static String dataValida(String data) throws ParseException, DataInvalidaException {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			LocalDate d = LocalDate.parse(data.replace("\'", ""), formatter);

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
