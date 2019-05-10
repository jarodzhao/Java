package com.jarod.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="tb_emergency_node")
public class EmergencyNode {

    @Id
    private String nodeId;

    private String emergencyId;

    private String nodeName;

    private Byte nodeOrder;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(String emergencyId) {
        this.emergencyId = emergencyId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Byte getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(Byte nodeOrder) {
        this.nodeOrder = nodeOrder;
    }
}
