package calculationParsing;

import java.util.Stack;

import utilities.AnsMemory;
import utilities.RecordMemory;

public class ShantingYard {
	
	private Stack<String> output=new Stack<String>();
	private Stack<String> stack= new Stack<String>();
	private StringBuilder builder= new StringBuilder();

	public void toRPN(String str) {
		
		String str1=str.replace("Ans", String.valueOf(AnsMemory.getAns()));
		String str2=str1.replace("M", String.valueOf(RecordMemory.getMemory()));
		String str3=str2.replace("\u00F7", "/");
		String str4=str3.replace("X", "*");
		String str5=str4.replace("*-(", "*-1*(");
		String str6=str5.replace("sqrt", "¬");
		String str7=str6.replace("Sen", "S");
		String str8=str7.replace("Cos", "C");
		String str9=str8.replace("Tan", "T");
		String str10=str9.replace("Log", "L");
		String str11=str10.replace("Ln", "l");
		String str12=str11.replace("\uD835\uDF0B", String.valueOf(Math.PI));
		String str13=str12.replace("e", String.valueOf(Math.E));
		
		int i=-1;
		for(char e:(str13+"#").toCharArray()) {
			i++;
			if(e=='#') {
				if(Character.isDigit(str13.charAt(str13.length()-1))) {
					output.add(builder.toString());
					builder.delete(0, builder.length());
					break;
				}else {
					break;
				}
				
			}else if(Character.isDigit(e) || e=='.') {
				builder.append(e);
				continue;
			}else if(e=='('){
				stack.add("(");
				continue;
			}else if(e==')') {
				
				if(isNumeric(builder.toString())) {
					output.add(builder.toString());
					builder.delete(0, builder.length());
				}
				
				while(stack.peek()!="(") {
					output.add(stack.peek());
					stack.pop();
				}
				stack.pop();  //pops left parenthesis "(" that was at the top of stack by now 
				continue;
				
			}else{
				switch(e) {
					case '+':
					case '-':
						if(i==0) {
							stack.add("*");
							if(e=='-') {
								output.add("-1");
							}else {
								output.add("1");
							}
							continue;
						}
						
						if(   isNumeric(String.valueOf(str13.charAt(i-1)))==false  &&  str13.charAt(i-1)!=')'   ) {
							builder.append(e);
							continue;
						}
						
						if(isNumeric(builder.toString())) {
							output.add(builder.toString());
							builder.delete(0, builder.length());
						}
						
						while( (stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/") ) 
								&& stack.peek()!="(") {
							
							output.add(stack.peek());
							stack.pop();
							break;
						}
						stack.add(String.valueOf(e));
						break;
						
					case '*':
					case '/':
						
						if(isNumeric(builder.toString())) {
							output.add(builder.toString());
							builder.delete(0, builder.length());
						}
						
						while((stack.contains("*") || stack.contains("/")) && stack.peek()!="(") {
							
							output.add(stack.peek());
							stack.pop();
							break;
						}
						
						stack.add(String.valueOf(e));
						break;
					
					case '^':
					case '¬':
						if(isNumeric(builder.toString())) {
							output.add(builder.toString());
							builder.delete(0, builder.length());
						}
						
						stack.add(String.valueOf(e));
						break;
						
					case 'S':
					case 'C':
					case 'T':
					case 'l':
					case 'L':
						stack.add(String.valueOf(e));
						break;
				}
			}
		}
		while(stack.isEmpty()==false) {
			output.add(stack.peek());
			stack.pop();
		}
			
	}
	public double solveRPN() {
		
			for(int i=0;i<=output.size();i++) {
				if(output.size()==1) {
					break;
				}
				
				if(isNumeric(output.get(i))) {
					continue;
					
				}else {
	
					switch(output.get(i)) {
					
						case "+":
							double suma=Double.parseDouble(output.get(i-2)) + Double.parseDouble(output.get(i-1));
							output.add(i-2, String.valueOf(suma));
							output.remove(i+1);
							output.remove(i);
							output.remove(i-1);
							i=0;
							break;
						case "-":
							double rest=Double.parseDouble(output.get(i-2)) - Double.parseDouble(output.get(i-1));
							output.add(i-2, String.valueOf(rest));
							output.remove(i+1);
							output.remove(i);
							output.remove(i-1);
							i=0;
							break;
						case "*":
							double mult=Double.parseDouble(output.get(i-2)) * Double.parseDouble(output.get(i-1));
							output.add(i-2, String.valueOf(mult));
							output.remove(i+1);
							output.remove(i);
							output.remove(i-1);
							i=0;
							break;
						case "/":
							double div=Double.parseDouble(output.get(i-2)) / Double.parseDouble(output.get(i-1));
							output.add(i-2, String.valueOf(div));
							output.remove(i+1);
							output.remove(i);
							output.remove(i-1);
							i=0;
							break;
						case "^":
							double exp= Math.pow(Double.parseDouble(output.get(i-2)), Double.parseDouble(output.get(i-1)));
							output.add(i-2, String.valueOf(exp));
							output.remove(i+1);
							output.remove(i);
							output.remove(i-1);
							i=0;
							break;
						case "¬":
							double root= Math.sqrt(Double.parseDouble(output.get(i-1)));
							output.add(i-1, String.valueOf(root));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
						case "S":
							double bsins=(Double.parseDouble(output.get(i-1)) * Math.PI) /180;
							double sin= Math.sin(bsins);
							if(Double.parseDouble(output.get(i-1))==180 || Double.parseDouble(output.get(i-1))==360) {
								sin=0;
							}
							output.add(i-1, String.valueOf(sin));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
						case "C":
							double bcons=(Double.parseDouble(output.get(i-1)) * Math.PI) /180;
							double cos= Math.cos(bcons);
							if(Double.parseDouble(output.get(i-1))==90 || Double.parseDouble(output.get(i-1))==270) {
								cos=0;
							}
							output.add(i-1, String.valueOf(cos));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
						case "T":
							double btan=(Double.parseDouble(output.get(i-1)) * Math.PI) /180;
							double tan= Math.tan(btan);
							if(Double.parseDouble(output.get(i-1))==180 || Double.parseDouble(output.get(i-1))==360) {
								tan=0;
							}
							if(Double.parseDouble(output.get(i-1))==90 || Double.parseDouble(output.get(i-1))==270) {
								tan=0/0;
							}
							output.add(i-1, String.valueOf(tan));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
						case "L":
							double log= Math.log10(Double.parseDouble(output.get(i-1)));
							output.add(i-1, String.valueOf(log));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
						case "l":
							double ln= Math.log(Double.parseDouble(output.get(i-1)));
							output.add(i-1, String.valueOf(ln));
							output.remove(i+1);
							output.remove(i);
							i=0;
							break;
					}
				}
			}
		
		return Double.parseDouble(output.peek());
	}
	private boolean isNumeric(String str) {
		try{
			Double.parseDouble(str);
			return true;
			}catch(Exception e) {
				return false;
			}
	}
	public void clearStacks() {
		output.clear();
		stack.clear();
	}
}
