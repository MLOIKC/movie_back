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
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GenomeTags implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("tagId")
    private Integer tagid;

    private String tag;


}
