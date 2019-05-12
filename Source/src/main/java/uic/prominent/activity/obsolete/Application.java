package uic.prominent.activity.obsolete;

public class Application {

	private Integer pid;
	private String mainwindowtitle;
	private String name;
	
	private int width;
	private int height;
	
	private int top_left_x;
	private int top_left_y;
	
	
	public Application(Integer pid, String name, String mainwindowtitle){
		this.setPid(pid);
		this.name = name;
		this.mainwindowtitle = mainwindowtitle;
		this.width = 0;
		this.height= 0;
		this.top_left_x = 0;
		this.top_left_y = 0;
	}

	public String getMainwindowtitle() {
		return mainwindowtitle;
	}


	public void setMainwindowtitle(String mainwindowtitle) {
		this.mainwindowtitle = mainwindowtitle;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getTop_left_x() {
		return top_left_x;
	}


	public void setTop_left_x(int top_left_x) {
		this.top_left_x = top_left_x;
	}


	public int getTop_left_y() {
		return top_left_y;
	}


	public void setTop_left_y(int top_left_y) {
		this.top_left_y = top_left_y;
	}

	public String getName() {
		return this.name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}
