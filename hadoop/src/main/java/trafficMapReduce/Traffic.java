package trafficMapReduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;



public class Traffic implements WritableComparable<Traffic>{
	String string="test";
	int i=2132;
    private int upNum;
    private int downNum;
    private int upPayload;
    private int downPayload;
    
	public void write(DataOutput out) throws IOException {
		out.writeInt(upNum);
		out.writeInt(downNum);
		out.writeInt(upPayload);
		out.writeInt(downPayload);
		
	}

	public void readFields(DataInput in) throws IOException {
		this.upNum=in.readInt();
		this.downNum=in.readInt();
		this.upPayload=in.readInt();
		this.downPayload=in.readInt();
	}
    
	@Override
	public String toString() {
		return (this.getUpNum()+this.getDownNum())+"\t"+(this.getUpPayload()+this.getDownPayload());
	}
	/**
	 * 自定义一个set方法
	 * @param upNum
	 * @param downNum
	 * @param upPayload
	 * @param downPayload
	 */
	public void set(int upNum, int downNum, int upPayload, int downPayload) {
		this.upNum = upNum;
		this.downNum = downNum;
		this.upPayload = upPayload;
		this.downPayload = downPayload;
	}
	
	
    
	public int getUpNum() {
		return upNum;
	}

	public void setUpNum(int upNum) {
		this.upNum = upNum;
	}

	public int getDownNum() {
		return downNum;
	}

	public void setDownNum(int downNum) {
		this.downNum = downNum;
	}

	public int getUpPayload() {
		return upPayload;
	}

	public void setUpPayload(int upPayload) {
		this.upPayload = upPayload;
	}

	public int getDownPayload() {
		return downPayload;
	}

	public void setDownPayload(int downPayload) {
		this.downPayload = downPayload;
	}

	//先排数据包的和 再排数据流量的和
		public int compareTo(Traffic o) {
			int num = (this.getUpNum()+this.getDownNum())-(o.getUpNum()+o.getDownNum());
			int num2 = (num == 0)?(this.getUpPayload()+this.getDownPayload())-(o.getUpPayload()+o.getDownPayload()) : num;
			return num2;
		}
	
	

}
