package com.courses.diplom.db.module.result;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.module.test.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    public Result getResult(Long userId, Long testId) {
        return resultRepository.getResult(userId, testId).orElse(null);
    }

    public void saveResult(User user, Test test, ResultDto dto) {
        Result result = dto.toEntity();
        if(Objects.nonNull(result.getId())){
            resultRepository.updateResult(user, test, result);
        } else {
            result.setUser(user);
            result.setTest(test);
            resultRepository.save(result);
        }
    }

    public int countTotalQuestion(Long userId) {
        return resultRepository.countTotalQuestion(userId).orElse(0);
    }
}
