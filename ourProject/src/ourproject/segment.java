package ourproject;
public class segment {
	private String segmentName;
	private float segmentBase;
	private float SegmentLimit;

	//CONSTRUCTOR
	public segment(String segmentName,float segmentBase,float segmentLimit) {
		this.segmentName = segmentName;
                this.segmentBase = segmentBase;
		this.SegmentLimit = segmentLimit;
	}
        
        public segment(String Name , float limit ){
        this.segmentName = Name;
        this.SegmentLimit = limit;                
        }
    
        public segment(){
         this.segmentName = null;
         this.SegmentLimit = 0;   
        }

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public float getSegmentBase() {
		return segmentBase;
	}

	public void setSegmentBase(float segmentBase) {
		this.segmentBase = segmentBase;
	}

	public float getSegmentLimit() {
		return SegmentLimit;
	}

	public void setSegmentLimit(float segmentLimit) {
		SegmentLimit = segmentLimit;
	}


}
