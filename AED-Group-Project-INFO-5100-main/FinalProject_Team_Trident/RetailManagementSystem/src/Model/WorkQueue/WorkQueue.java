/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author felicia
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public void addWorkRequest(WorkRequest workRequest)
    {
        workRequestList.add(workRequest);
    }
}