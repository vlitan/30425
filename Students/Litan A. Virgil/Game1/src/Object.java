import java.awt.Point;

public class Object {
	
	static final int LEFT_UP = 0;
	static final int RIGHT_UP = 1;
	static final int RIGHT_DOWN = 2;
	static final int LEFT_DOWN = 3;
	
	public  Point corners[] = new Point[4];
	private Point size;
	
	public Object(Point origin, Point size){
		corners[LEFT_UP] = origin;
		this.size = size;
		updateCornersBySize(origin);
	}
	
	//********size manager*********\\
	public Point getSize(){
		return (new Point(this.size));
	}
	
	public int getWidth(){
		return (this.size.x);
	}
	
	public int getHeight(){
		return (this.size.y);
	}
	
	public boolean setSize(Point new_size){
		if ((new_size.x <= 0) || (new_size.y <= 0))
			return (false);
		setWidth(new_size.x);
		setHeight(new_size.y);
		return (true);
 	}
	
	public boolean setWidth(int width){
		if (width <= 0)
			return (false);
		this.corners[LEFT_UP].x += (this.size.x - width) / 2;
		this.size.x = width;
		updateCornersBySize(corners[LEFT_UP]);
		return (true);
	}
	
	public boolean setHeight(int height){
		if (height <= 0)
			return (false);
		this.corners[LEFT_UP].y += (this.size.y - height) / 2;
		this.size.y = height;
		updateCornersBySize(corners[LEFT_UP]);
		return (true);
	}
	//*******************************\\
	
	//*******position manager********\\
	public Point getPosition(){
		return (new Point(corners[LEFT_UP]));
	}
	//TODO add out of map bounds 
	public void setPosition(int x, int y){
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		for (int i = 0; i < 4; i++)
			setCorner(i, x, y);
	}
	
	public int getX(){
		return (corners[LEFT_UP].x);
	}
	
	public void setX(int x){
		setPosition(x, corners[LEFT_UP].y);
	}
	
	public int getY(){
		return (corners[LEFT_UP].y);
	}
	
	public void setY(int y){
		setPosition(y, corners[LEFT_UP].y);
	}
	
	public Point getCenter(){
		return (new Point(getCenterX(), getCenterY()));
	}
	
	public int getCenterX(){
		return ((corners[LEFT_UP].x +  corners[RIGHT_UP].x) / 2);
	}
	
	public int getCenterY(){
		return ((corners[LEFT_UP].y + corners[LEFT_DOWN].y) / 2);
	}

	public void move(int x, int y){
		for (int i = 0; i < 4; i++)
			moveCorner(i, x, y);
	}
	
	private void updateCornersBySize(Point origin){
		corners[RIGHT_UP] = new Point(origin.x + size.x, origin.y);
		corners[RIGHT_DOWN] = new Point(origin.x + size.x, origin.y + size.y);
		corners[LEFT_DOWN] = new Point(origin.x, origin.y + size.y);
	}
	
	private void moveCorner(int index, int x, int y){
		corners[index].x += x;
		corners[index].y += y;
	}
	
	private void setCorner(int index, int x, int y){
		corners[index].x = x;
		corners[index].y = y;
	}
	
	//******************************\\

	//******collision manager*********\\
	public boolean intersects(Object o){
		for (int i = 0; i < 4; i++){
			if (isOnShape(this.corners[i], o))
				return (true);
			if (isOnShape(o.corners[i], this))
				return (true);
		}
		return (false);
	}
	
	private boolean isOnShape(Point a, Object o){
		if ((isBetween(a.x, o.corners[LEFT_UP].x, o.corners[RIGHT_UP].x)) && (isBetween(a.y, o.corners[LEFT_UP].y, o.corners[RIGHT_DOWN].y))) 
			return (true);
		return (false);
	}
	
	private boolean isBetween(int x, int min, int max){
		return ((min < x) && (x < max));
	}
	//*********************************\\
	
}