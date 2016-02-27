import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;
public class IhaveMain {
	static BufferedReader ip = null;
    static PrintWriter op = null;
    static ArrayList<Circuit> allc=new ArrayList<>();
    static Stack<Juggler> allj=new Stack<>();
    static int circuitCount=0,jugglerCount=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the path of the input file");
Scanner sc=new Scanner(System.in);
String filepath=sc.nextLine();
            ip = new BufferedReader(new FileReader(filepath));
            System.out.println("Enter the path of the output file");
            filepath=sc.nextLine();
            op = new PrintWriter(new FileWriter(filepath));
            String l;
            while ((l = ip.readLine()) != null) {
            	if(!l.equals("")){
            	if(l.charAt(0)=='C'){
            		circuitCount++;
                	int h=0,e=0,p=0;
                	String[] tokens=l.split(" ");
                	for(int i=1;i<tokens.length;i++){
                		 if(tokens[i].charAt(0)=='H'){
                			 h=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		 }
                		else if(tokens[i].charAt(0)=='E'){
                			e=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		}
                		else if(tokens[i].charAt(0)=='P'){
                			p=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		}
                	}
                	Circuit cir=new Circuit(h, e, p);
                	allc.add(cir);
                }
                else if(l.charAt(0)=='J'){
                	jugglerCount++;
                	int h=0,e=0,p=0,num=0;
                	ArrayList<Integer> ar=new ArrayList<>();
                	String[] tokens=l.split(" ");
                	for(int i=1;i<tokens.length;i++){
                		if(tokens[i].charAt(0)=='J'){
                			num=Integer.parseInt(tokens[i].substring(1, tokens[i].length()));
                		}
                	else if(tokens[i].charAt(0)=='H'){
                			 h=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		 }
                		else if(tokens[i].charAt(0)=='E'){
                			e=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		}
                		else if(tokens[i].charAt(0)=='P'){
                			p=Integer.parseInt(tokens[i].substring(2, tokens[i].length()));
                		}
                		else if(tokens[i].charAt(0)=='C'){
                			String[] ranks=tokens[i].split(",");
                			for(int po=0;po<ranks.length;po++){
                			ar.add(Integer.parseInt(ranks[po].substring(1, ranks[po].length())));
                			}
                		}
                	}
                	Juggler jug=new Juggler(h, e, p,num, ar);
                	allj.push(jug);
                }
            }
            }
            while(!allj.empty()){
            	Juggler jug=allj.pop();
            	ArrayList<Integer> myrank=jug.getRank();
            	int pos=0;
            	boolean done=false;
            	while((!done)&&pos<myrank.size()){
            	Circuit cir=allc.get(myrank.get(pos));
            	if(cir.members.size()<(jugglerCount/circuitCount)){
            		cir.members.add(jug);
            		done=true;
            		if(cir.min==null){
            			cir.min=jug;
            		}
            		else{
            			int minval=cir.min.getH()*cir.getH()+cir.min.getE()*cir.getE()+cir.min.getP()*cir.getP();
            			int jugval=jug.getH()*cir.getH()+jug.getE()*cir.getE()+jug.getP()*cir.getP();
            			if(jugval<minval)
            				cir.min=jug;
            		}
            	}
            	else{
            		int minval=cir.min.getH()*cir.getH()+cir.min.getE()*cir.getE()+cir.min.getP()*cir.getP();
        			int jugval=jug.getH()*cir.getH()+jug.getE()*cir.getE()+jug.getP()*cir.getP();
        			if(jugval>minval){
        				done=true;
        				allj.push(cir.getMin());
        				cir.getMembers().remove(cir.min);
        				cir.getMembers().add(jug);
        				cir.setMin(jug);
        				Iterator<Juggler> it=cir.getMembers().iterator();
        				while(it.hasNext()){
        					Juggler temp=it.next();
        					int tempval=(temp.getH()*cir.getH())+(temp.getE()*cir.getE())+(temp.getP()*cir.getP());
        					 minval=cir.min.getH()*cir.getH()+cir.min.getE()*cir.getE()+cir.min.getP()*cir.getP();
        					 if(tempval<minval)
        						 cir.setMin(temp);
        				}
        				
        			}
        			else{
        				pos++;
        				
        			}
            	}
            }
            }
            for(int i=(allc.size()-1);i>=0;i--){
            	op.print("C"+i+" ");
            	ArrayList<Juggler> mem=allc.get(i).getMembers();
            	for(int p=0;p<mem.size();p++){
            		op.print("J"+mem.get(p).getNum()+" ");
            		ArrayList<Integer> rank=mem.get(p).getRank();
            		for(int pos=0;pos<rank.size();pos++){
            			op.print("C"+rank.get(pos)+":");
            			Circuit c=allc.get(rank.get(pos));
            			int val=(mem.get(p).getH()*c.getH())+(mem.get(p).getE()*c.getE())+(mem.get(p).getP()*c.getP());
            			op.print(val+" ");
            		}
            		if(p!=mem.size()-1)
            			op.print(", ");
            		
            	}
            	op.println();
            	
            }
            op.close();
	}

}
