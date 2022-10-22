package br.com.desafio.iti;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ConsultaString {

	public static void main(String[] args) throws Exception {

/*
 * Xml usado na implementação
 
		 <Pessoas>
			<cpf>57708634040</cpf>
			<nome>João Antônio</nome>
			<cpf>81979064083</cpf>
			<nome>Maria Santos</nome>
			<cpf>55870678072</cpf>
			<nome>José Henrique</nome>	
		</Pessoas>		 
*/
		String xml = "<Pessoas>\r\n"
				+ "	<cpf>57708634040</cpf>\r\n"
				+ "	<nome>João Antônio</nome>\r\n"
				+ "	<cpf>81979064083</cpf>\r\n"
				+ "	<nome>Maria Santos</nome>\r\n"
				+ "	<cpf>55870678072</cpf>\r\n"
				+ "	<nome>José Henrique</nome>	\r\n"
				+ "</Pessoas>";
		String nomeTag = "nome";
		buscaValoresNoXML(xml, nomeTag);
	}

	public static List<String> buscaValoresNoXML(String xml, String nomeTag) {

		List<String> valores = new ArrayList<String>();
		String valorTag = new String();
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			NodeList nodes = doc.getElementsByTagName(nomeTag);

			for (int i = 0; i < nodes.getLength(); i++) {
				valorTag = new String();
				valorTag = nodes.item(i).getTextContent();
				valores.add(valorTag);
				System.out.println("Valor Tag " + nomeTag +":"+ valorTag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valores;
	}
}