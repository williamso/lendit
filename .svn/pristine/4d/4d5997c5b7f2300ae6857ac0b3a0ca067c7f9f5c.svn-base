package com.mobiorama.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datas {
	
	public static final String ATRASADO = "ATRASADO";
	public static final String OK = "OK";
	public static final String VENCENDO = "VENCENDO";
	public static final String NODIA = "NODIA";	

	public Date getPegaDataAtual() {  
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");   
		System.out.print(formatarDate.format(data));  

		Calendar calendar = new GregorianCalendar();  
		Date date = new Date();  
		calendar.setTime(date);  
		return calendar.getTime();  
	} 
	
	public int getAno(){
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy");
		return Integer.parseInt(formatarDate.format(data));
	}
	
	public int getMes(){
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("MM");
		return Integer.parseInt(formatarDate.format(data));
	}
	
	public int getDia(){
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd");
		return Integer.parseInt(formatarDate.format(data));
	}

}
