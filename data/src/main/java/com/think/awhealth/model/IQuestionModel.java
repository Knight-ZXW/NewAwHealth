package com.think.awhealth.model;

import com.think.awhealth.bean.entity.Question;
import com.think.awhealth.result.Result;

import java.util.List;

import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface IQuestionModel {
    /**
     *
     * @param id 该类别话题对应的id
     * @param row 数量
     * @return
     */
    Observable<Result<List<Question>>> getTopicQuestions(@Query("id") int id, @Query("rows") int row);

    /**
     *
     * @param questionId 查询的question的id
     * @return
     */
    Observable<Result<Question>> getQuestionDetail( int questionId);
}
