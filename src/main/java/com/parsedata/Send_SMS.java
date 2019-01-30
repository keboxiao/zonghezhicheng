package com.parsedata;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class Send_SMS {
	public String getXml(String CII_account, String CII_password, String SMS_content, String[] Array_receivers,
			String SMS_password, String SMS_sender, String SMS_areacode) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ByteArrayOutputStream os2 = new ByteArrayOutputStream();
		String xml = null;

		try {
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPHeader header = envelope.getHeader();
			header.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			header.addNamespaceDeclaration("Header", "Header");
			SOAPBody body = envelope.getBody();
			envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			envelope.addNamespaceDeclaration("mul", "http://www.muleumo.org");
			envelope.addNamespaceDeclaration("mes", "http://message.scape.gsta.com");
			envelope.addNamespaceDeclaration("sms", "http://sms.cap.scape.gsta.com");
			message.getMimeHeaders().addHeader("SOAPAction", "sendSMS");
			message.getMimeHeaders().addHeader("Content-Type", "text/html;charset=utf-8");
			SOAPElement method = body.addChildElement("sendSMS", "mul");
			SOAPElement in0 = method.addChildElement("in0", "mul");
			SOAPElement in1 = method.addChildElement("in1", "mul");
			SOAPElement in2 = method.addChildElement("in2", "mul");
			SOAPElement account = in0.addChildElement("account", "mes");
			account.addTextNode(CII_account);
			SOAPElement extendField = in0.addChildElement("extendField", "mes");
			extendField.addTextNode("");
			SOAPElement hashCode = in0.addChildElement("hashCode", "mes");
			hashCode.addTextNode("");
			SOAPElement password = in0.addChildElement("password", "mes");
			password.addTextNode(CII_password);
			SOAPElement timestamp = in0.addChildElement("timestamp", "mes");
			timestamp.addTextNode("");
			SOAPElement account1 = in1.addChildElement("account", "mes");
			account1.addTextNode("");
			SOAPElement id = in1.addChildElement("id", "mes");
			id.addTextNode("");
			SOAPElement content1 = in2.addChildElement("content", "sms");
			content1.addTextNode(SMS_content);
			SOAPElement contentFormat = in2.addChildElement("contentFormat", "sms");
			contentFormat.addTextNode("1");
			SOAPElement needFeedback = in2.addChildElement("needFeedback", "sms");
			needFeedback.addTextNode("1");
			SOAPElement password2 = in2.addChildElement("password", "sms");
			password2.addTextNode(SMS_password);
			SOAPElement receivers = in2.addChildElement("receivers", "sms");
			SOAPElement[] recv = new SOAPElement[Array_receivers.length];

			for (int i = 0; i < Array_receivers.length; ++i) {
				recv[i] = receivers.addChildElement("string", "mul");
				recv[i].addTextNode(Array_receivers[i]);
			}

			SOAPElement areacode = in2.addChildElement("areacode", "sms");
			areacode.addTextNode(SMS_areacode);
			SOAPElement sender = in2.addChildElement("sender", "sms");
			sender.addTextNode(SMS_sender);
			message.saveChanges();
			message.writeTo(os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			this.inputStream2String(is);
			if (is != null) {
				try {
					is.close();
				} catch (IOException var59) {
					var59.printStackTrace();
				}
			}

			String destination = "http://132.102.249.11:8081/sxt_webservice/services/SMSService?wsdl";
			SOAPMessage reply = null;
			reply = connection.call(message, destination);
			reply.writeTo(os2);
			InputStream is2 = new ByteArrayInputStream(os2.toByteArray());
			xml = this.inputStream2String(is2);
			if (is2 != null) {
				try {
					is2.close();
				} catch (IOException var58) {
					var58.printStackTrace();
				}
			}

			connection.close();
		} catch (Exception var60) {
			System.out.println(var60.toString());
			System.out.println("获取XML出错");
			var60.printStackTrace();
			xml = null;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException var57) {
					var57.printStackTrace();
				}
			}

			if (os2 != null) {
				try {
					os2.close();
				} catch (IOException var56) {
					var56.printStackTrace();
				}
			}

		}

		return xml;
	}

	private String inputStream2String(InputStream is) {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";

		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException var6) {
			var6.printStackTrace();
		}

		return buffer.toString();
	}

	public List readXmlValue(String xmlString) {
		ArrayList<String> arrList = new ArrayList();
		StringReader read = new StringReader(xmlString);
		InputSource source = new InputSource(read);
		SAXBuilder sb = new SAXBuilder();

		try {
			Document doc = sb.build(source);
			Element root = doc.getRootElement();
			List ls = root.getChildren();
			Element ele1 = (Element) ls.get(0);
			List ls1 = ele1.getChildren();
			Element ele2 = (Element) ls1.get(0);
			List ls2 = ele2.getChildren();
			Element ele3 = (Element) ls2.get(0);
			List ls3 = ele3.getChildren();
			Iterator it = ls3.iterator();

			while (it.hasNext()) {
				Object o = it.next();
				if (o instanceof Text) {
					Text t = (Text) o;
					System.out.println("Text: " + t.getText());
				} else if (o instanceof Attribute) {
					System.out.println("Attribute: " + o);
				} else if (o instanceof Element) {
					arrList.add(((Element) o).getName() + ":" + ((Element) o).getValue());
				}
			}
		} catch (Exception var18) {
			var18.printStackTrace();
		}

		return arrList;
	}
}
