package com.wipro.priya.quizappmonorepo.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.priya.quizappmonorepo.ens.Category;
import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Response;
import com.wipro.priya.quizappmonorepo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
 
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question save(Question question) {
		
		return questionRepository.save(question);
	}
	@Override
	public List<Question> getQuestionByCategory(Category category) {
		return questionRepository.findByCategory(category);
	}
	@Override
	public List<Integer> getQuestionsForQuiz(String category, String difficult) {
		
		List<Integer> questions= questionRepository.findRandomQuestionByCategoryAndLevel(category,difficult);
	   return questions;
	
	}

	@Override
	public List<QuestionWrapper> getQuestionforQuizbyQuizIDService(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<Question> questions=new ArrayList<>();
		
		for(Integer id:questionIds) {
			questions.add (questionRepository.findById(id.longValue()).orElseThrow());
		}
		for(Question question:questions) {
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
		    wrappers.add(wrapper);
		}
		return wrappers;
	}
	@Override
	public Integer calculateUserScore(List<Response> responses) {
		int rightAnswers=0;
		for(Response response:responses) {
			Question questions=questionRepository.findById(Long.valueOf(response.getId())).orElseThrow();
			
			if(response.getResponse().equals(questions.getCorrectAnswer())){
				rightAnswers++;
			}
		}
		return rightAnswers;
	}
	

	
	}
