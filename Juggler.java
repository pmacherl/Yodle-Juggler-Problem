import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Juggler {
int h,e,p,num;
ArrayList<Integer> rank=new ArrayList<>();
public ArrayList<Integer> getRank() {
	return rank;
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
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public Juggler(int h, int e, int p, int num, ArrayList<Integer> rank) {
	super();
	this.h = h;
	this.e = e;
	this.p = p;
	this.num = num;
	this.rank = rank;
}
@Override
public String toString() {
	return "Juggler [h=" + h + ", e=" + e + ", p=" + p + ", num=" + num + ", rank=" + rank + "]";
}



}
