package com.shang.mybatisPlusDemo.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author shang
 * @since 2022-07-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("car")
public class Car extends Model<Car> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 是否删除  0未删除  1已删除
     */
    @TableField("is_deleted")
    private Boolean isDeleted;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
