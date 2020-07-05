package com.app.demo.service;

import org.springframework.stereotype.Service;
import com.app.demo.pojo.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class UserService implements IUserService {
    private TestingService service;

    public UserService(TestingService service) {
        this.service = service;
    }

    public void startTest() {
        service.prepareQuestionsFromCSV();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите имя");
            String name = reader.readLine();
            System.out.println("введите фамилию");
            String lastName = reader.readLine();
            User user = new User(name, lastName);

            for (int i = 0; i < service.getQuestions().size(); i++) {
                String[] transit = service.getQuestions().get(i);
                service.showQuestionsFromRow(transit);
                System.out.println(user.getName() + ", выберите вариант ответа");
                String answer = reader.readLine();
                user.getUserAnswers().add(answer);
            }

            int rightAnswersCount = 0;
            for (int i = 0; i < user.getUserAnswers().size(); i++) {
                if (service.getAnswers().get(i).equals(user.getUserAnswers().get(i))) rightAnswersCount++;
            }
            double rightAnswersPercent = (double) rightAnswersCount / (double) user.getUserAnswers().size() * 100;
            boolean isDone = false;
            if (service.getAnswers().equals(user.getUserAnswers())) isDone = true;
            System.out.println(user.toString() + (isDone ? ", тест сдан успешно" : ", тест не сдан, попробуйте еще раз")
                    + "\nверных ответов: "
                    + rightAnswersCount + "\nпроцент выполнения теста составил:"
                    + Math.round(rightAnswersPercent) + "%");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
