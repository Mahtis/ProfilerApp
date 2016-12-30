package wepa.service.initservice;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import wepa.service.QuestionService;
import wepa.service.UserService;

@Service
@Profile("production")
public class ProductionInitService {

    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        userService.createDefaultUserForTesting();
        userService.createDefaultAdminForTesting();
        
        questionService.createQuestion("How old is this person?", Arrays.asList("<15", "15-20", "20-25", "25-30", "30-35", "35-40", "40-45", "45-50", "50-55", "55-60", "60>"));
        questionService.createQuestion("How tall is this person?", Arrays.asList("<140", "140-150", "150-160", "160-170", "170-180", "180-190", "190-200", "200>"));
        questionService.createQuestion("How much does this person weigh?", Arrays.asList("<40", "40-50", "50-60", "60-70", "70-80", "80-90", "90-100", "100-110", "110-120", "120-130", "130>"));
        questionService.createQuestion("Does this person look like a dog or a cat person?", Arrays.asList("Neither", "Dog", "Cat", "Both"));
        questionService.createQuestion("What kind of area does this person live in?", Arrays.asList("countryside", "small village", "large village", "small city", "big city"));
        questionService.createQuestion("On a scale of 1-10, how outgoing and social is this person?", Arrays.asList("1 total loner", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely social"));
        questionService.createQuestion("On a scale of 1-10, how neurotic is this person?", Arrays.asList("1 extremely neurotic", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely laid back"));
        questionService.createQuestion("On a scale of 1-10, how open to new things is this person?", Arrays.asList("1 extremely close minded", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely open-minded"));
        questionService.createQuestion("On a scale of 1-10, how conscientious/diligent/meticulous to new things is this person?", Arrays.asList("1 extremely easy-going and careless", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely diligent"));
        questionService.createQuestion("On a scale of 1-10, how agreeable/pleasant is this person?", Arrays.asList("1 extremely rude/unpleasant", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely pleasant/nice"));
        questionService.createQuestion("On a scale of 1-10, how physically demanding is this persons work?", Arrays.asList("1 not physical at all(desk job)", "2", "3", "4", "5", "6", "7", "8", "9", "10 extremely physical (proffesional athlete)"));
        questionService.createQuestion("On a scale of 1-10, how religious is this person?", Arrays.asList("1 not religious", "2", "3", "4", "5", "6", "7", "8", "9", "10 very religious"));
    }

}
