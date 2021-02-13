package tp01;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		double[][][]temp = new double[10][12][31];
		double[][][]maior_data = new double[10][12][31];
		double[][][]menor_data = new double[10][12][31];
		double media;
		double soma=0,maior,menor;
		int dia,mes,ano,pos_mes,pos_ano,ult_dia;
		int cont_dia,opcao,vazio=0;
		String menor_dia = new String();
		String maior_dia = new String();
		String mesextenso = new String();
				
		Scanner ler= new Scanner (System.in);
		
		System.out.println("Digite uma opção: 1- Entrada da média das temperaturas diarias, 2- Temperatura média mensal, 3- Temperatura mínima mensal, 4- Temperatura máxima mensal, 5- relatório mensal ou 0- saída");
		opcao = ler.nextInt();
		
		while(opcao !=0) {
		switch(opcao) {
		case 1:
			vazio++;
			
			System.out.println("Insira o ano:");
			ano = ler.nextInt();
			pos_ano = recupera_pos_ano(ano);
			
			System.out.println("Insira o mes:");
			mes = ler.nextInt();
			pos_mes = recupera_pos_mes(mes);
			
			ult_dia = recupera_ultimo_dia(ano,mes);
			
			for(cont_dia=0;cont_dia<ult_dia;cont_dia++) {
				System.out.println("Digite a temperatura do dia "+(cont_dia+1));
				dia = ler.nextInt();
				temp[pos_ano][pos_mes][cont_dia] = dia;
			}	
			break;
			
			case(2):
			if(vazio!=0) {
				System.out.println("Insira o ano:");
				ano = ler.nextInt();
				pos_ano = recupera_pos_ano(ano);
				
				System.out.println("Insira o mes:");
				mes = ler.nextInt();
				pos_mes = recupera_pos_mes(mes);
				
				ult_dia = recupera_ultimo_dia(ano,mes);
				
				for(cont_dia=0;cont_dia<ult_dia;cont_dia++){
					soma += temp[pos_ano][pos_mes][cont_dia];
				}
				
				media = soma/ult_dia;
				System.out.println("A média da temperatura desse mês é de "+media);
				
			}else {
				System.out.println("Dados não cadastrados!!!");
			}
			break;
			
		case 3:
			
			if(vazio!=0) {
				System.out.println("Insira o ano:");
				ano = ler.nextInt();
				pos_ano = recupera_pos_ano(ano);
				
				System.out.println("Insira o mes:");
				mes = ler.nextInt();
				pos_mes = recupera_pos_mes(mes);
				mesextenso = recupera_mes_extenso(mes);
								
				ult_dia = recupera_ultimo_dia(ano,mes);
				
				menor=temp[pos_ano][pos_mes][0];
				menor_dia =String.valueOf(1);
				
				for(cont_dia=1;cont_dia<ult_dia;cont_dia++){
					if(menor>temp[pos_ano][pos_mes][cont_dia]) {
						menor = temp[pos_ano][pos_mes][cont_dia];
						String contdia = String.valueOf(cont_dia+1);
						menor_dia = contdia;
					}else if(menor==temp[pos_ano][pos_mes][cont_dia]){
						String contdia = String.valueOf(cont_dia + 1);
						menor_dia = menor_dia +", "+contdia;
					}
				}
				System.out.println("Os dias que atingiram a temperatura mínima foram "+menor_dia+" de "+mesextenso+" de "+ano);
				
			}else {
				System.out.println("Dados não cadastrados!!!");
			}
			
			break;
		case 4:
			
			if(vazio!=0) {
				System.out.println("Insira o ano:");
				ano = ler.nextInt();
				pos_ano = recupera_pos_ano(ano);
				
				System.out.println("Insira o mes:");
				mes = ler.nextInt();
				pos_mes = recupera_pos_mes(mes);
				mesextenso = recupera_mes_extenso(mes);
				
				ult_dia = recupera_ultimo_dia(ano,mes);
				
				maior=temp[pos_ano][pos_mes][0];
				maior_dia =String.valueOf(1);
				
				for(cont_dia=1;cont_dia<ult_dia;cont_dia++){
					if(maior<temp[pos_ano][pos_mes][cont_dia]) {
						maior = temp[pos_ano][pos_mes][cont_dia];
						String contdia = String.valueOf(cont_dia+1);
						maior_dia = contdia;
					}else if(maior==temp[pos_ano][pos_mes][cont_dia]){
						String contdia = String.valueOf(cont_dia + 1);
						maior_dia = maior_dia +", "+contdia;
					}
				}
				System.out.println("Os dias que atingiram a temperatura máxima foram "+maior_dia+" de "+mesextenso+" de "+ano);
				
			}else {
				System.out.println("Dados não cadastrados!!!");
			}
			break;
			
		case 5:
			
			System.out.println("Insira o ano:");
			ano = ler.nextInt();
			pos_ano = recupera_pos_ano(ano);
			
			System.out.println("Insira o mes:");
			mes = ler.nextInt();
			System.out.println();
			pos_mes = recupera_pos_mes(mes);
			
			ult_dia = recupera_ultimo_dia(ano,mes);
			
			for(cont_dia=0;cont_dia<ult_dia;cont_dia++) {
				System.out.println("A temperatura do dia "+(cont_dia +1)+" é de "+temp[pos_ano][pos_mes][cont_dia]);
			}
			System.out.println();

			soma=0;
			for(cont_dia=0;cont_dia<ult_dia;cont_dia++){
				soma += temp[pos_ano][pos_mes][cont_dia];
			}
			media = soma/ult_dia;
			System.out.println("A média da temperatura desse mês é de "+media);
			
			menor=temp[pos_ano][pos_mes][0];
			menor_dia =String.valueOf(1);
			
			for(cont_dia=1;cont_dia<ult_dia;cont_dia++){
				if(menor>temp[pos_ano][pos_mes][cont_dia]) {
					menor = temp[pos_ano][pos_mes][cont_dia];
				}
			}
		System.out.println("A menor temperatura é "+menor);
		System.out.println();
		
		maior=temp[pos_ano][pos_mes][0];
		maior_dia =String.valueOf(1);
		
		for(cont_dia=1;cont_dia<ult_dia;cont_dia++){
			if(maior<temp[pos_ano][pos_mes][cont_dia]) {
				maior = temp[pos_ano][pos_mes][cont_dia];
			}
		}
		System.out.println("A maior temperatura é "+maior);
		System.out.println();	
			
			break;
		}
		System.out.println();
		System.out.println("Digite uma opção: 1- Entrada da média das temperaturas diarias, 2- Temperatura média mensal, 3- Temperatura mínima mensal, 4- Temperatura máxima mensal, 5- relatório mensal ou 0- saída");
		opcao = ler.nextInt();
		}
		ler.close();
	}
	
	public static int recupera_pos_ano(int ano) {

			if(ano==2011) {
				return 0;
			}else if(ano==2012) {
				return 1;
			}else if (ano==2013) {
				return 2;
			}else if(ano==2014) {
				return 3;
			}else if(ano==2015) {
				return 4;
			}else if(ano==2019){
				return 5;
			}else if(ano==2017){
				return 6;
			}else if(ano==2018){
				return 7;
			}else if(ano==2019){
				return 8;
			}else if(ano==2020){
				return 9;
			}else {
				return -1;
			}
	}
	
	
	public static int recupera_pos_mes(int mes) {

		 if(mes==1) {
			return 0;
		}else if(mes==2) {
			return 1;
		}else if (mes==3) {
			return 2;
		}else if(mes==4) {
			return 3;
		}else if(mes==5) {
			return 4;
		}else if(mes==9){
			return 5;
		}else if(mes==7){
			return 6;
		}else if(mes==8){
			return 7;
		}else if(mes==9){
			return 8;
		}else if(mes==10){
			return 9;
		}else if(mes==11){
			return 10;
		}else if(mes==12){
			return 11;
		}else {
			return -1;
		}
	}
	
	
	public static int recupera_ultimo_dia(int ano,int mes) {
		if(mes==1) {
			return 31;
		}else if(mes==2) {
			if(ano%4==0) {
				return 29;
			}else {
				return 28;
			}
		}else if(mes==3) {
			return 31;
		}else if(mes==4){
			return 30;
		}else if(mes==5){
			return 31;
		}else if(mes==6){
			return 30;
		}else if(mes==7){
			return 31;
		}else if(mes==8){
			return 31;
		}else if(mes==9){
			return 30;
		}else if(mes==10){
			return 31;
		}else if(mes==11){
			return 30;
		}else if(mes==12){
			return 31;
		}else {
			return -1;
		}
		}
	public static String recupera_mes_extenso(int mes) {
		switch(mes) {
		case 1:
			return "janeiro";
		case 2:
			return "fevereiro";
		case 3:
			return "março";
		case 4:
			return "abril";
		case 5:
			return "maio";
		case 6:
			return "junho";
		case 7:
			return "julho";
		case 8:
			return "agosto";
		case 9:
			return "setembro";
		case 10:
			return "outubro";
		case 11:
			return "novembro";
		case 12:
			return "dezembro";
		default:
			return "0";
		}
	}

	}