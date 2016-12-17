package wepa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wepa.domain.AnswerOption;
import wepa.domain.DBQuestion;
import wepa.repository.AnswerOptionRepository;
import wepa.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerOptionRepository answerOptionRepository;

//    public DBQuestion createQuestion(List<AnswerOption> answerOptions) {
//        DBQuestion question = new DBQuestion();
//        question.setAnswerOptions(answerOptions);
//        return questionRepository.save(question);
//    }
    @Transactional
    public DBQuestion createQuestion(String content, Map<Integer, String> answerOptionMap) {
        List<AnswerOption> answerOptions = new ArrayList<>();
        DBQuestion DBQuestion = new DBQuestion();
        DBQuestion.setContent(content);
        DBQuestion = questionRepository.save(DBQuestion);
        for (Integer orderNumber : answerOptionMap.keySet()) {
            AnswerOption answerOption = new AnswerOption();
            answerOption = answerOptionRepository.save(answerOption);
            answerOption.setOrderNumber(orderNumber);
            System.out.println("AnswerText @ createQuestion(String content, Map<Integer, String> answerOptionMap): "
                    + answerOptionMap.get(orderNumber));
            answerOption.setAnswerText(answerOptionMap.get(orderNumber));
            answerOption.setDBQuestion(DBQuestion);
            answerOption = answerOptionRepository.save(answerOption);

            answerOptions.add(answerOption);
        }
        DBQuestion.setAnswerOptions(answerOptions);
        DBQuestion = questionRepository.save(DBQuestion);
        System.out.println("Answer options for DBQuestion @ QuestionService.createQuestion(Map<Integer, String> answerOptionMap) " + DBQuestion.getAnswerOptions());
        return DBQuestion;
    }
}
