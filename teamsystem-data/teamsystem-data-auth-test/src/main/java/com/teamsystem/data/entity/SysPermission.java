package com.teamsystem.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teamsystem.data.base.BaseEntity;
import lombok.*;

/**
 * 权限规则系统表
 *
 * @author Moment
 * @since 2022-04-03 02:22:13
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_permission")
public class SysPermission extends BaseEntity {

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
    * 路径规则
    */
      @TableField("path_rule")
    private String pathRule;

      /**
    * 操作规则
    */
      @TableField("function_rule")
    private String functionRule;


}
