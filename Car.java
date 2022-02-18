package bj;

import java.util.Comparator;

public class Car  implements Comparable<Car>{
    public static int carNum;
    private String carName;
    private String maker;
    public Car(int carNum, String carName, String maker) {
        super();
        this.carNum = carNum;
        this.carName = carName;
        this.maker = maker;
    }

    public int getCarNum() {
        return carNum;
    }

	public void setCarNum(int carNum) {
	    this.carNum = carNum;
	}
	
	public String getCarName() {
	    return carName;
	}
	
	public void setCarName(String carName) {
	    this.carName = carName;
	}
	
	public String getMaker() {
	    return maker;
	}
	
	public void setMaker(String maker) {
	    this.maker = maker;
	}
	
	@Override
	public int compareTo(Car o) {
	    // TODO Auto-generated method stub
	    
	    if(this.carNum> o.carNum)return -1;
	    else if(this.carNum< o.carNum)return 1;
	    return 0;
	}
	
	
	@Override
	public String toString() {
		return String.valueOf(this.carNum);
	}

//@OverrideS
//	public int compare(Car o1, Car o2) {
//	// TODO Auto-generated method stub
//	    
//	    if(o1.carNum> o2.carNum)return -1;
//	    else if(o1.carNum< o2.carNum)return 1;
//	    return 0;
//	}
}

