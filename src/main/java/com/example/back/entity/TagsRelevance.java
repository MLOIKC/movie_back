package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagsRelevance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private Integer userid;

    @TableField("movieId")
    private Integer movieid;

    private String tag;

    private Double relevance;


}
