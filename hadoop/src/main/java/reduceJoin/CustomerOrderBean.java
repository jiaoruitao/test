package reduceJoin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class CustomerOrderBean implements Writable{
	private String flag;
	private String data;
	
	public void write(DataOutput out) throws IOException {
		out.writeUTF(flag);
		out.writeUTF(data);
	}

	public void readFields(DataInput in) throws IOException {
		this.flag = in.readUTF();
		this.data = in.readUTF();
	}
	
	@Override
	public String toString() {
		return flag + "," + data;
	}

	public void set(String flag, String data) {
		this.flag = flag;
		this.data = data;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}