package com.yupi.springbootinit.model.vo;

import lombok.Data;

/**
 * AI 返回对象
 */
@Data
public class BIResponse {
    // 图表代码
    private String genChart;

    // 分析结果
    private String genResult;

    private Long chartId;
}
