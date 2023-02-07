/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.WorkRequest;

/**
 *
 * @author vipul
 */
public class WorkRequest {
    
    public int req_id;
    public String req_status;

    public WorkRequest(int id, String status) {
        
        this.req_id = id;
        this.req_status = status;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public String getReq_status() {
        return req_status;
    }

    public void setReq_status(String req_status) {
        this.req_status = req_status;
    }

    public WorkRequest() {
    }
    
    
    
}
