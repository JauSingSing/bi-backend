# 数据库初始化
# @author <a href="https://github.com/liyupi">程序员鱼皮</a>
# @from <a href="https://yupi.icu">编程导航知识星球</a>

-- 创建库
create database if not exists bi_project;

-- 切换库
use bi_project;

-- 帖子表
create table if not exists chart
(
    id         bigint auto_increment comment 'id' primary key,
    goal       text null comment '分析目标',
    chartData  text null comment '图表数据',
    chartType   varchar(128) null comment '图表类型（折线图、直方图）',
    genChart   text null comment 'AI 生成的图表数据',
    genResult  text null comment '生成的分析结论',
    userId     bigint null comment '关联的用户id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '图表信息表' collate = utf8mb4_unicode_ci;
