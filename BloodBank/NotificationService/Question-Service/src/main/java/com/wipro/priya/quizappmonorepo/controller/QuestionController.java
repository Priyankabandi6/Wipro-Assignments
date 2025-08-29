package com.wipro.priya.quizappmonorepo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.priya.quizappmonorepo.ens.Category;
import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Response;
import com.wipro.priya.quizappmonorepo.services.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/question")
public class QuestionController {
	@Autowired
	private final QuestionService questionService;
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable Category category){
		return  questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
	@GetMapping("/generateQuestionsForQuiz")
	public List<Integer> getQuestionsForQuiz(@RequestParam String category ,@RequestParam String difficult)
	{
		return questionService.getQuestionsForQuiz(category,difficult);
		
	}
	@PostMapping("/getQuestions")
    public List<QuestionWrapper> getQuestionforQuizbyQuizID(@RequestBody List<Integer> questionIds)
    {
    	return  questionService.getQuestionforQuizbyQuizIDService(questionIds);
    }
	
	@PostMapping("/getScore")
	public  Integer  getScore(@RequestBody List<Response> responses) {
		return questionService.calculateUserScore(responses);
	}

}
