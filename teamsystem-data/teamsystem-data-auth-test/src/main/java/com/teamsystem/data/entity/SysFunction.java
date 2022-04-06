package com.teamsystem.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teamsystem.data.base.BaseEntity;
import lombok.*;

/**
 * 功能权限系统表
 *
 * @author Moment
 * @since 2022-04-03 02:22:13
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_function")
public class SysFunction extends BaseEntity {

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
    * 父功能ID
    */
      @TableField("parent_id")
    private Long parentId;

      /**
    * 名称
    */
      @TableField("name")
    private String name;

      /**
    * 路径
    */
      @TableField("path")
    private String path;

      /**
    * 图标
    */
      @TableField("icon")
    private String icon;


}
