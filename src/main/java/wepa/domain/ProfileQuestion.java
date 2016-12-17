package wepa.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import wepa.repository.UUIDPersistable;
import javax.persistence.*;


@Entity
public class ProfileQuestion extends UUIDPersistable {

    @ManyToOne(cascade = javax.persistence.CascadeType.ALL)
    private Profile profile;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne(cascade = javax.persistence.CascadeType.ALL)
    private DBQuestion DBQuestion;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne
    private  AnswerOption answer;

    public AnswerOption getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerOption answer) {
        this.answer = answer;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public DBQuestion getDBQuestion() {
        return DBQuestion;
    }

    public void setDBQuestion(DBQuestion DBQuestion) {
        this.DBQuestion = DBQuestion;
    }
}
