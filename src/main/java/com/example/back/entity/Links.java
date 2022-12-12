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
public class Links implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("movieId")
    private Integer movieid;

    @TableField("imdbId")
    private Integer imdbid;

    @TableField("tmdbId")
    private Integer tmdbid;


}
