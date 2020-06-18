/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourproject;

/**
 *
 * @author moh1969
 */
public class partition {
    
    private float start;
    private float end;
    
    
    public partition(float start, float end) {
        this.start = start;
        this.end = end;
    }
    
     public partition() {
        this.start = 0;
        this.end = 0;
    }
    
    public float getStart()
    {
        return this.start;
    }
    public float getEnd()
    {
        return this.end;
    }

    

    public void setStart(float start) {
        this.start = start;
    }

    public void setEnd(float end) {
        this.end = end;
    }
    
}
