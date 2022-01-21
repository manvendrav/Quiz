package src.demo;

import src.demo.mapper.Mapper;
import src.demo.pojo.Question;

import java.util.*;

public class QuizApp {

    public static void main(String[] args) {
        QuizApp quizAppObject = new QuizApp();
        quizAppObject.quizApp();

    }

    private void quizApp() {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        Iterator<Question> itr = Mapper.quizQuestionMapper.iterator();
        Map<String, String> optionAnswerMapper = new HashMap<>();
        while(itr.hasNext()) {
            Question question = itr.next();
            System.out.println(question.getId());
            System.out.println("");
            optionAnswerMapper.put("a", question.getOptionOne());
            optionAnswerMapper.put("b", question.getOptionTwo());
            optionAnswerMapper.put("c", question.getOptionThree());
            optionAnswerMapper.put("d", question.getOptionFour());
            System.out.println("a. "+question.getOptionOne());
            System.out.println("b. "+question.getOptionTwo());
            System.out.println("c. "+question.getOptionThree());
            System.out.println("d. "+question.getOptionFour());
            System.out.println("");
            System.out.println("Please choose the correct option");
            String candidateAnswer = sc.nextLine();
            if(optionAnswerMapper.get(candidateAnswer).equalsIgnoreCase(question.getAnswer())) {
                System.out.println("Your answer is correct");
                optionAnswerMapper.clear();
                System.out.println("");
                score +=10;
            } else {
                System.out.println("Wrong choice");
                System.out.println("");
            }
        }

        System.out.println("Your score is:"+score);

    }

}
