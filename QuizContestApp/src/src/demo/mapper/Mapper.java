package src.demo.mapper;

import org.xml.sax.SAXException;
import src.demo.pojo.Question;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Mapper {

    public static Set<Question> quizQuestionMapper = new HashSet<>();

    static {
        try {
            populateMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void populateMap() throws IOException, ParserConfigurationException, SAXException {
        quizQuestionMapper = Parser.parse();
    }
}
