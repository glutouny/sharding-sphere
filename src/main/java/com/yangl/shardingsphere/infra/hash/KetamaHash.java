package com.yangl.shardingsphere.infra.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 基于Ketama算法的一致性hash
 *
 * @author li.yang01@hand-china.com 2020/9/16 2:23 下午
 */
public class KetamaHash {

    /**
     * 一致性节点分布
     */
    private TreeMap<Long, String> nodeMap = new TreeMap<>();

    /**
     * 虚拟节点与真实节点映射
     */
    private Map<String, String> virtualMappingActual = new HashMap<>();

    public KetamaHash(List<String> actualNodes) {
        init(actualNodes, DEFAULT_VIRTUAL_NODE_COUNT);
    }

    public KetamaHash(List<String> actualNodes, Integer virtualNodeCount) {
        init(actualNodes, virtualNodeCount);
    }

    /**
     * 初始化
     *
     * @param actualNodes      实际节点列表
     * @param virtualNodeCount 虚拟节点个数
     */
    private void init(List<String> actualNodes, Integer virtualNodeCount) {

        for (String actualNode : actualNodes) {

            for (int i = 0; i < virtualNodeCount; i++) {
                final String virtualNode = actualNode + SYMBOL + i;
                final long hash = Ketama.hash(virtualNode);
                this.nodeMap.put(hash, virtualNode);
                this.virtualMappingActual.put(virtualNode, actualNode);
            }
        }
    }

    /**
     * 获取正式节点
     *
     * @param key key
     * @return 真实节点
     */
    public String getActualNode(String key) {

        final long hash = Ketama.hash(key);
        final Long index = this.nodeMap.tailMap(hash).firstKey();
        final String virtualNode = this.nodeMap.get(index);
        return this.virtualMappingActual.get(virtualNode);
    }

    /**
     * 默认的虚拟节点个数
     */
    private final Integer DEFAULT_VIRTUAL_NODE_COUNT = 160;

    /**
     * 符号
     */
    private final String SYMBOL = "_VN_";

}
