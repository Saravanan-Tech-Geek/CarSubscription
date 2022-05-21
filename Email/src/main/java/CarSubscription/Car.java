package CarSubscription;

public class Car {
	
	private String carNo;
	private int seat;
	
	public Car(String carNo, int seat) {
		this.carNo = carNo;
		this.seat = seat;
	}
	

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public void displayCarInfo() {
		System.out.println("Car number - " + " " + carNo + " " + "Available seat - " + seat);
	}
}
