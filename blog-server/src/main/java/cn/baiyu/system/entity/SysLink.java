package cn.baiyu.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
@TableName("tb_link")
public class SysLink implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String url;
}
