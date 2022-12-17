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
 * @since 2022-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersRatings implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private Integer userid;

    private String gender;

    private String name;

    @TableField("movieId")
    private Integer movieid;

    private Double rating;

    private String title;

    private String genres;

    private Integer hot;
}
