+++
pre = "<b>3.5. </b>"
title = "流量治理"
weight = 5
chapter = true
+++

## 背景

随着数据规模的不断膨胀，使用多节点集群的分布式方式逐渐成为趋势。
对集群整体视角的统一管理能力，和针对单独组件细粒度的控制能力，是基于存算分离的现代数据库体系中不可或缺的功能。

## 挑战

管控的挑战，在于对集群的集中化管理的统一管理能力以及在单点出现故障时精细化的操作能力。

集中化管理的挑战体现在将包括数据库存储节点和中间件计算节点的状态统一管理，并且能够实时的探测到分布式环境下最新的变动情况，进一步为集群的控制和调度提供依据。

面对超负荷的流量下，针对某一节点进行熔断和限流，以保证整个数据库集群得以继续运行，是分布式系统下对单一节点控制能力的挑战。

## 目标

实现从数据库到计算节点打通的一体化管理能力，在故障中为组件提供细粒度的控制能力，并尽可能的提供自愈的可能，是 Apache ShardingSphere 管控模块的主要设计目标。

## 应用场景

### 计算节点过载保护

当 ShardingSphere 集群内某个计算节点超过负载后，通过熔断功能，阻断应用到该计算节点的流量，保证整个集群继续提供稳定服务。

### 存储节点限流

在读写分离的场景下，当 ShardingSphere 集群内某个负责读流量的存储节点承接超负荷的请求时，通过限流功能，阻断集群内计算节点到该存储节点的流量，以保证存储节点集群正常响应。
