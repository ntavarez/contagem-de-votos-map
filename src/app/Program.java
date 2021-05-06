package app;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/Votos.csv"));
			
			String linha = br.readLine();
			while(linha != null) {
				
				String[] campos = linha.split(", ");
				
				String nome = campos[0];
				Integer votos = Integer.parseInt(campos[1]);
				
				if(map.get(nome) == null) {
					map.put(nome, votos);
				} else {
					map.put(nome, votos + map.get(nome));
				}
				
				linha = br.readLine();
			}
			
			for(String chave : map.keySet()) {
				System.out.println(chave + ": " + map.get(chave));
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			

	}

}
