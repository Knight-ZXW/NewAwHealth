package com.think.awhealth.model.dataSource.remote;

import com.think.awhealth.bean.entity.Question;
import com.think.awhealth.model.IQuestionModel;
import com.think.awhealth.result.Result;

import java.util.List;

import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class QuestionRemoteModel implements IQuestionModel{
    @Override
    public Observable<Result<List<Question>>> getTopicQuestions(@Query("id") int id, @Query("rows") int row) {
        return null;
    }

    @Override
    public Observable<Result<Question>> getQuestionDetail(int questionId) {
        return null;
    }
}
