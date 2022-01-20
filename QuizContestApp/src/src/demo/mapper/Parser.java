package src.demo.mapper;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.demo.pojo.Question;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Parser {

    private static final String PATH = "src//src//demo/quiz.xml";

    public static Set<Question> parse() throws ParserConfigurationException, IOException, SAXException {
        Set<Question> questionairre = new HashSet<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(PATH));

        document.getDocumentElement().normalize();
        NodeList list = document.getElementsByTagName("Question");

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                String id = element.getAttribute("id");
                String optionOne = element.getElementsByTagName("OptionOne").item(0).getTextContent();
                String optionTwo = element.getElementsByTagName("OptionTwo").item(0).getTextContent();
                String optionThree = element.getElementsByTagName("OptionThree").item(0).getTextContent();
                String optionFour = element.getElementsByTagName("OptionFour").item(0).getTextContent();
                String answer = element.getElementsByTagName("Answer").item(0).getTextContent();

                Question questionObj = new Question(id, answer, optionOne, optionTwo, optionThree, optionFour);
                questionairre.add(questionObj);
            }
        }
        return questionairre;
    }
}