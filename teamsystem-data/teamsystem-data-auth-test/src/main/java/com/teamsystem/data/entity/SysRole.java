package com.teamsystem.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teamsystem.data.base.BaseEntity;
import lombok.*;

/**
 * 角色系统表
 *
 * @author Moment
 * @since 2022-04-03 02:22:13
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BaseEntity {

      /**
    * ID
    */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
    * 团队ID
    */
      @TableField("team_id")
    private Long teamId;

      /**
    * 角色名
    */
      @TableField("name")
    private String name;

      /**
    * 角色代码（英文大写）
    */
      @TableField("code")
    private String code;

      /**
    * 角色层级（越大级别越高）
    */
      @TableField("sort")
    private Integer sort;


}
