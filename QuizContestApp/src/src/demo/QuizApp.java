package src.demo;

import src.demo.mapper.Mapper;
import src.demo.pojo.Question;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class QuizApp {

    public static void main(String[] args) {
        QuizApp quizAppObject = new QuizApp();
        quizAppObject.quizApp();

    }

    private void quizApp() {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        Iterator<Question> itr = Mapper.quizQuestionMapper.iterator();
        while(itr.hasNext()) {
            Question question = itr.next();
            System.out.println(question.getId());
            System.out.println("");
            System.out.println(question.getOptionOne());
            System.out.println(question.getOptionTwo());
            System.out.println(question.getOptionThree());
            System.out.println(question.getOptionFour());
            System.out.println("");
            System.out.println("Please enter the answer...");
            String candidateAnswer = sc.nextLine();
            if(question.getAnswer().equalsIgnoreCase(candidateAnswer)) {
                System.out.println("Your answer is correct");
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
