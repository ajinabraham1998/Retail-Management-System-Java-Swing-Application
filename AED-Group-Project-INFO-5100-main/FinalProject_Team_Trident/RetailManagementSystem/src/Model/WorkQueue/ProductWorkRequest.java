/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

import Model.Location.Location;
import Model.Organization.Organization;
import java.util.Date;

/**
 *
 * @author felicia
 */
public class ProductWorkRequest {
    private Organization senderOrganization;
    private Organization recieverOrganization;
    private Location senderNetwork;
    private Location recieverNetwork;
    private String EquipmentRequestId;
    private String EquipmentId;
    private String EquipmentName;
    private String Reason;
    private int noOfUnits;
    private double equipmentPrice;
    private String status;
    Date requestdate;
    Date acknowledgeDate;
    Date resolveDate;
    int min = 100;
    int max = 999;
    
    
    public ProductWorkRequest() {
        int randomNum = (int)(Math.random() * (max - min + 1) + min);
        EquipmentRequestId= "EP"+randomNum;  
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    public Organization getRecieverOrganization() {
        return recieverOrganization;
    }

    public void setRecieverOrganization(Organization recieverOrganization) {
        this.recieverOrganization = recieverOrganization;
    }

    public Location getSenderNetwork() {
        return senderNetwork;
    }

    public void setSenderNetwork(Location senderNetwork) {
        this.senderNetwork = senderNetwork;
    }

    public Location getRecieverNetwork() {
        return recieverNetwork;
    }

    public void setRecieverNetwork(Location recieverNetwork) {
        this.recieverNetwork = recieverNetwork;
    }

    public String getEquipmentRequestId() {
        return EquipmentRequestId;
    }

    public void setEquipmentRequestId(String EquipmentRequestId) {
        this.EquipmentRequestId = EquipmentRequestId;
    }

    public String getEquipmentId() {
        return EquipmentId;
    }

    public void setEquipmentId(String EquipmentId) {
        this.EquipmentId = EquipmentId;
    }

    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String EquipmentName) {
        this.EquipmentName = EquipmentName;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public double getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(double equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

    public Date getAcknowledgeDate() {
        return acknowledgeDate;
    }

    public void setAcknowledgeDate(Date acknowledgeDate) {
        this.acknowledgeDate = acknowledgeDate;
    }
    
    @Override
    public String toString() {
        return EquipmentRequestId;
    }
    
    
}
