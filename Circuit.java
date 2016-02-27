import java.util.ArrayList;
import java.util.Comparator;

public class Circuit  {
Juggler min;
int h,e,p;
ArrayList<Juggler> members=new ArrayList<>();
public Circuit(int h, int e, int p) {
	super();
	this.h = h;
	this.e = e;
	this.p = p;
	
}
public Juggler getMin() {
	return min;
}
public void setMin(Juggler min) {
	this.min = min;
}
public int getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
}
public int getE() {
	return e;
}
public void setE(int e) {
	this.e = e;
}
public int getP() {
	return p;
}
public void setP(int p) {
	this.p = p;
}
public ArrayList<Juggler> getMembers() {
	return members;
}
public void setMembers(ArrayList<Juggler> members) {
	this.members = members;
}
@Override
public String toString() {
	return "Circuit [min=" + min + ", h=" + h + ", e=" + e + ", p=" + p + ", members=" + members + "]";
}

}
