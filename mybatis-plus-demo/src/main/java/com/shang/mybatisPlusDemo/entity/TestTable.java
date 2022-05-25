package com.shang.mybatisPlusDemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@Getter
@Setter
@TableName("test_table")
public class TestTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;
    private String code;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除  0未删除  1已删除
     */
    @TableField("is_deleted")
    private Boolean deleted;


}
