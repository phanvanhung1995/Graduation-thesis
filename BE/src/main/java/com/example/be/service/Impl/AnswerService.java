package com.example.be.service.Impl;

import com.example.be.dto.IAnswerDto;
import com.example.be.model.Answers;
import com.example.be.repository.IAnswerRepository;
import com.example.be.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private IAnswerRepository iAnswerRepository;

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all answer
     *
     * @param questionId
     */
    @Override
    public List<IAnswerDto> findAll(Integer questionId) {
        return iAnswerRepository.findAll(questionId);
    }

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param answerContent, questionId, teacherId, dateTime
     */
    @Override
    public void save(String answerContent, Long questionId, Long teacherId, LocalDateTime dateTime) {
        iAnswerRepository.saveAnswerByQuestion(answerContent, questionId, teacherId, dateTime);
    }
}
