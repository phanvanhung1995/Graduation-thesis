package com.example.be.controller;

import com.example.be.dto.AnswerDto;
import com.example.be.dto.IAnswerDto;
import com.example.be.model.Answers;
import com.example.be.service.IAnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answers")
public class AnswerRestController {
    @Autowired
    private IAnswerService iAnswerService;

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : show answer by question_id
     *
     * @param questionId
     * @return HttpStatus.OK if result is not erroror HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("")
    public ResponseEntity<?> showAnswer(@RequestParam Integer questionId) {
        List<IAnswerDto> answersList = iAnswerService.findAll(questionId);
        if (answersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(answersList, HttpStatus.OK);
    }

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : create answer by id
     *
     * @param answersDto
     * @return HttpStatus.CREATED if result is not error or HttpStatus.BAD_REQUEST if result is error
     */
    @PostMapping("/save-answer")
    public ResponseEntity<?> saveAnswer(@RequestBody AnswerDto answersDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        answersDto.setDateTime(localDateTime);
        try {
            Answers answers = new Answers();
            BeanUtils.copyProperties(answersDto, answers);
            System.out.println(answers);
            iAnswerService.save(answersDto.getAnswerContent(), answersDto.getQuestionId(), answersDto.getTeacherId(), answersDto.getDateTime());
            return new ResponseEntity<>(answersDto,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
