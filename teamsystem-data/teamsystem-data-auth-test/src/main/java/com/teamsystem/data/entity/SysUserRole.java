package com.teamsystem.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teamsystem.data.base.BaseEntity;
import lombok.*;

/**
 * 用户-角色联系表
 *
 * @author Moment
 * @since 2022-04-03 02:22:14
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

      /**
    * ID
    */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
    * 用户ID
    */
      @TableField("user_id")
    private Integer userId;

      /**
    * 角色ID
    */
      @TableField("role_id")
    private Integer roleId;


}
