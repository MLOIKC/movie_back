package com.example.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MoviesRatings implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private Integer userid;

    private Integer movieid;

    private String title;

    private String genres;

    private Double rating;


}
