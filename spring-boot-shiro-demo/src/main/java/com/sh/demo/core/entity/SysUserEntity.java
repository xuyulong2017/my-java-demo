package com.sh.demo.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Description 系统用户实体
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐值
	 */
	private String salt;
	/**
	 * 状态:NORMAL正常  PROHIBIT禁用
	 */
	private String state;

}
