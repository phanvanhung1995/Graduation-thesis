package com.example.be.controller;

import com.example.be.dto.IQuestionDto;
import com.example.be.dto.QuestionDto;
import com.example.be.model.Question;
import com.example.be.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionRestController {
    @Autowired
    private IQuestionService iQuestionService;

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : show list question
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("")
    public ResponseEntity<Page<IQuestionDto>> showQuestion(Integer totalElement) {
        Pageable pageable = PageRequest.of(0, totalElement);
        Page<IQuestionDto> questionPage = iQuestionService.findAll(pageable);
        if (questionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(questionPage, HttpStatus.OK);
    }

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : create question by id
     *
     * @param questionDto
     * @return HttpStatus.CREATED if result is not error or HttpStatus.BAD_REQUEST if result is error
     */
    @PostMapping("/save-question")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionDto questionDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        questionDto.setDateTime(localDateTime);
        try {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);
            iQuestionService.save(questionDto.getQuestionContent(), questionDto.getQuestionTopic(), questionDto.getDateTime(), questionDto.getStudentId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
