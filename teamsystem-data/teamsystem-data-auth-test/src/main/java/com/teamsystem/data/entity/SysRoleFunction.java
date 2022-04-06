package com.teamsystem.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teamsystem.data.base.BaseEntity;
import lombok.*;

/**
 * 功能-角色联系表
 *
 * @author Moment
 * @since 2022-04-03 02:22:13
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_function")
public class SysRoleFunction extends BaseEntity {

      /**
    * ID
    */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
    * 角色ID
    */
      @TableField("role_id")
    private String roleId;

      /**
    * 功能ID
    */
      @TableField("function_id")
    private String functionId;


}
