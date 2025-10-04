package com.courses.diplom.db.module.result;

import com.courses.diplom.db.MapperToEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto implements MapperToEntity<Result> {
    private Long id;
    private int total;
    private int correct;
    private int wrong;
    private int correctPercentage;
    private int wrongPercentage;


    @Override
    public Result toEntity() {
        return Result.builder()
                .id(this.id)
                .total(this.total)
                .correct(this.correct)
                .wrong(this.wrong)
                .correctPercentage(this.correctPercentage)
                .wrongPercentage(this.wrongPercentage)
                .build();
    }
}
