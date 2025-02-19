package com.example.springblog.Controller;

import com.example.springblog.entity.Question;
import com.example.springblog.service.AnswerService;
import com.example.springblog.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable int id, @RequestParam String content) {
        Question question = this.questionService.getQuestionById(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);

    }
}
