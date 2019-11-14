package cn.baiyu.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryPage implements Serializable {

    /**
     * 当前页
     */
    private int page;

    /**
     * 每页的记录数
     */
    private int limit;
}
