import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		String linha;
		String texto = "";
		
		Grafo grafo = new Grafo();
		
		Kruskal kruskal = new Kruskal();
		Prim prim = new Prim();

		System.out.println("Lista vertices na opcao para escolher");
		//aqui começa exercicio 1 e 2
		try {
			FileReader file = new FileReader("C:\\Users\\fernando.buonocore\\Desktop\\mapa.json");
			BufferedReader buffer = new BufferedReader(file);
			while ((linha = buffer.readLine()) != null) {
				texto += linha;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject map = new JSONObject(texto);
		JSONArray features;
		features = (JSONArray) map.get("features");

		DistanceCalculator distancia = new DistanceCalculator();
		
		String tipoDistancia = "K";
		String distancias;
		
		distancias = "Kilometro - escolha 'K' \n" + "Miles - escolha 'N' \n";
		
		try {
			tipoDistancia = JOptionPane.showInputDialog(distancias);
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        }
		
		
		for(int i = 0; i < features.length(); i++) {
			JSONObject feature = new JSONObject(features.get(i).toString());
            JSONObject geometry = feature.getJSONObject("geometry");
            JSONObject properties = feature.getJSONObject("properties");
            JSONArray coordinates = geometry.getJSONArray("coordinates");
            
            if (geometry.getString("type").equals("Point")) {
                double lat = coordinates.getDouble(0);
                double lon = coordinates.getDouble(1);
                Vertice vertice = new Vertice(properties.getInt("id"), properties.getString("tipo"), lat, lon);
                grafo.insereVertice(vertice);
            }
            if (geometry.getString("type").equals("LineString")) {
            	Vertice v1 = grafo.verticeValue(properties.getInt("v1"));
            	Vertice v2 = grafo.verticeValue(properties.getInt("v2"));
            	double dis = distancia.distance(v1.getLatitude(), v1.getLongitude(), v2.getLatitude(), v2.getLongitude(), tipoDistancia) * 1000 / 100;
                grafo.insereAresta(v1, v2, properties.getString("deslocamento"), dis);
            }
            
		}
		
		//exercicio 3
		kruskal.getMst(grafo);
		prim.prim(grafo.getaresta());
		
		String valoresDosVErtices = "";
		for(Vertice vertices : grafo.getVertice()){
			valoresDosVErtices = valoresDosVErtices + vertices.getId() + " - " + vertices.getTipo() + "\n";
		}
		int sairDaqui= 0;
		int irPara=0;
		try {
			JTextArea textArea = new JTextArea(12, 25);
			textArea.setText(valoresDosVErtices);
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			sairDaqui = Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Escolha local de origem", 3));
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        }
		
		try {
			JTextArea textArea = new JTextArea(12, 25);
			textArea.setText(valoresDosVErtices);
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			irPara = Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Escolha local de destino", 3));
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        }
		//aqui termina exercicio 1 e 2
		
		Vertice um = grafo.vertexValue(grafo, sairDaqui);
		Vertice dois = grafo.vertexValue(grafo, irPara);
		
		//exericio 4
		if (sairDaqui == 0 || irPara ==0) {
			System.out.println("locais invalidos");
		}else{
			BellmanFord bellmanFord = new BellmanFord(grafo, sairDaqui);
			
			LinkedList<Vertice> shortestPath = bellmanFord.shortestPath(irPara);
			
			for (int i = 0; i < shortestPath.size(); i++) {
				System.out.println(i + 1 + "º Vertice - " + shortestPath.get(i).getNome());
			}
			System.out.println("Distancia total: " + bellmanFord.getDistance(irPara));
		}
		
		
		BufferedReader br = null;
		String html = "";
		try {
			br = new BufferedReader(new FileReader("C:\\dev\\trabalho_GB\\Didi\\src\\Google.html"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while(br.ready()){
			   html = html + br.readLine();
			   html  = html +"\n";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String htmlNova = html.replaceAll("xyz1", "{lat: "+ um.getLongitude()   + ", lng: " + um.getLatitude()   + "}");
		htmlNova = htmlNova.replaceAll("xyz2"   , "{lat: "+ dois.getLongitude() + ", lng: " + dois.getLatitude() + "}");
		
		try {
			FileWriter fw = new FileWriter(new File("C:\\dev\\trabalho_GB\\Didi\\src\\Google.html"));
			fw.write(htmlNova);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);

		java.net.URL helpURL;
		
		helpURL = Main.class.getResource(
				"Google.html");

		try {
			editorPane.setPage(helpURL);
		} catch (IOException e) {

		}

		try {
			java.awt.Desktop.getDesktop().open(new File ("C:\\dev\\trabalho_GB\\Didi\\src\\Google.html"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		    Thread.sleep(8000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		try {
			FileWriter fw = new FileWriter(new File("C:\\dev\\trabalho_GB\\Didi\\src\\Google.html"));
			fw.write(html);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("");
	}

}
