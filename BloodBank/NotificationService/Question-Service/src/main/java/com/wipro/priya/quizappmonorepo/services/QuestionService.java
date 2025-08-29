package com.wipro.priya.quizappmonorepo.services;

import java.util.List;

import com.wipro.priya.quizappmonorepo.ens.Category;
import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Response;

public interface QuestionService {

	Question save(Question question);
	
	List<Question> getQuestionByCategory(Category category);

	List<Integer> getQuestionsForQuiz(String category, String difficult);

	List<QuestionWrapper> getQuestionforQuizbyQuizIDService(List<Integer> questionIds);

	Integer calculateUserScore(List<Response> responses);

//	void getMeQuestionsWrappersBasedOnIDS(List<Integer> questionIds);
}
