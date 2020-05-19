package com.macys.survey.dao;

import com.macys.survey.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SurveyOptionDao extends CrudRepository<SurveyOption,Long> {
    public SurveyOption findByid(Long surveyQuizes);
    public List<SurveyOption> findAll();
    @Query("select new com.macys.survey.model.SurveyQuizesResponse(exp.id,exp.expName,quiz.id,quiz.question,quiz.surveyOption.id,op.id,op.option) FROM SurveyExperience exp join SurveyQuizes quiz on exp.id=quiz.surveyExperience join SurveyOption op on op.surveyQuizes=quiz.id where exp.id=?1 order by quiz.id,op.id ")
    public List<SurveyQuizesResponse> getData(Long expId);

}
