package br.com.codenation;

import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

	public static int average(int[] elements) {
		double sum = 0;
		double average;
		double qtd = elements.length;
		for ( int i = 0; i < elements.length; i++){
			sum =  sum + elements[i];
		}
		 average = (sum/qtd);
		return (int) average;
	}

	public static int mode(int[] elements) {
		int mode = 0;
		Map<Integer, Integer> mapa = new HashMap<>();
		for (int i = 0; i < elements.length; i++){
			if( !mapa.containsKey(elements[i])){
				mapa.put(elements[i] ,1);
			} else {
				int ocorrencia = mapa.get(elements[i]);
				int novaOcorrencia = ocorrencia + 1;
				mapa.put(elements[i], novaOcorrencia);
			}
		}
		int maiorNumeroDeOcorrencias = 0;
		for (Map.Entry<Integer, Integer> entry : mapa.entrySet()){
			if (maiorNumeroDeOcorrencias < entry.getValue()){
				maiorNumeroDeOcorrencias = entry.getValue();
				mode = entry.getKey();
			}
		}
		return mode;
	}

	public static int median(int[] elements) {
		int median = 0;
		int atual = 0;
		for(int i = 0; i < elements.length; i++){
			for(int j = i + 1 ; j < elements.length;j++){
				if(elements[i] > elements[j] ){
					atual = elements[i];
					elements[i] = elements[j];
					elements[j] = atual;
				}
			}
		}
		int posicao = elements.length / 2;
		if (elements.length%2 == 0){
			median = ((elements[posicao -1] + elements[posicao])/2);
		} else {
			median = elements[posicao];
		}

		return median;
	}
}