package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GenomeScores implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("movieId")
    private Integer movieid;

    @TableField("tagId")
    private Integer tagid;

    private Double relevance;


}
