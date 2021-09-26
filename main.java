import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {
	
	public static int getLineNumber(File operation, String word) throws Exception {
	    BufferedReader f = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(operation))));

	    String line;
	    int lineNumber = 0;
	    while ((line = f.readLine()) != null)   {
	        lineNumber++;
	        if (word.equals(line)) {
	            return lineNumber;
	        }
	    }
	    return -1;
	}
	
	private static String findInstruction(String find) throws FileNotFoundException {
		
		File ins = new File("list of operations.txt");
		
		Scanner scanIns = new Scanner(ins);
		String s = null;
		
		while(scanIns.hasNextLine()) {
			
			s = scanIns.nextLine();
			if(s.equals(find)) {
				break;
			}
			
		}
		return s;
		
	}
	
	private static String findRegister(String find) throws FileNotFoundException {
		
		File ins = new File("list of registers.txt");
		
		Scanner scanIns = new Scanner(ins);
		String s = null;
		
		while(scanIns.hasNextLine()) {
			
			s = scanIns.nextLine();
			if(s.equals(find)) {
				break;
			}
			
		}
		return s;
		
	}
	
	public static String deleteFirstChar(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		
		sb.deleteCharAt(0);		
		
		return sb.toString();	
		
	}
	
	public static String getFirstChar(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		int i;
		for(i=s.length()-1; i>0; i--) {
			
			sb.deleteCharAt(i);
			
		}
		
		return sb.toString();	
		
	}
	
	public static void RTypeEncription(String [] arr) throws Exception {
		
		//File input = new File("input instructions.txt");
		File operation = new File("list of operations.txt");
		File register = new File("list of registers.txt");
		File output = new File("output instruction.txt");
		
		//Scanner scaninput = new Scanner(input);
		
		
		
		//while(scaninput.hasNextLine()) {
			
			//String in = null;
			
			//in = scaninput.nextLine();
			
			//String[] arr = in.split(" ");    //splits the instruction into words
			
			if(arr[0].equals(findInstruction(arr[0]))) {
				
				arr[1] = arr[1].replace(",", "");
				
				if(arr[1].equals(findRegister(arr[1]))){
								
					arr[2] = arr[2].replace(",", "");
					
					if(arr[2].equals(findRegister(arr[2]))){
												
						arr[3] = arr[3].replace(",", "");
						
						if(arr[3].equals(findRegister(arr[3]))) {
							
													
							//Gets the line number of each word in the file
							int line0 = getLineNumber(operation , arr[0]);
							int line1 = getLineNumber(register , arr[1]);
							int line2 = getLineNumber(register , arr[2]);
							int line3 = getLineNumber(register , arr[3]);
							
							line0 = line0 - 1;
							line1 = line1 - 1;
							line2 = line2 - 1;
							line3 = line3 - 1;
							
							String bin0 = Files.readAllLines(Paths.get("input instructions binary.txt")).get(line0);
							String bin1 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line1);
							String bin2 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line2);
							String bin3 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line3);
							
							System.out.print(bin0 + " ");
							System.out.print(bin2 + " ");
							System.out.print(bin3 + " ");
							System.out.print(bin1 + " ");
							System.out.print("\n");
							
							System.out.print(Integer.toHexString(line0));
							System.out.print(" ");
							System.out.print(Integer.toHexString(line2));
							System.out.print(" ");
							System.out.print(Integer.toHexString(line3));
							System.out.print(" ");
							System.out.print(Integer.toHexString(line1));
							System.out.print(" ");
							System.out.print("\n");
																		
							//Converts and writes in the output file
							PrintWriter out = new PrintWriter(new FileWriter (output, true));
							out.print(arr[0] + " instruction:\n");
							out.print(bin0);
							out.print(" ");
							out.print(bin2);
							out.print(" ");
							out.print(bin3);
							out.print(" ");
							out.print(bin1);
							out.print(" ");
							out.print("\n");
							out.print(Integer.toHexString(line0));
							out.print(Integer.toHexString(line2));
							out.print(Integer.toHexString(line3));
							out.print(Integer.toHexString(line1));
							out.print("\n");
							out.close();
							
						}
						
						else {
							
							System.out.println("Wrong Instruction");
							
						}
						
					}
					
					else {
						
						System.out.println("Wrong Instruction");
						
					}
					
				}
				
				else {
					
					System.out.println("Wrong Instruction");
					
				}
				
			}
			else {
				
				System.out.println("Wrong Instruction");
				
			}
			
		}
		
	//}
	
	public static void  ITypeEncription(String [] arr) throws Exception {
		
		//File input = new File("input instructions.txt");
		File operation = new File("list of operations.txt");
		File register = new File("list of registers.txt");
		File output = new File("output instruction.txt");
		File constant = new File("constant.txt");
				
		//Scanner scaninput = new Scanner(input);
		
		
		
		//while(scaninput.hasNextLine()) {
			
			//String in = null;
			
			//in = scaninput.nextLine();
			
			//System.out.println(in);
			
			//String[] arr = in.split(" ");    //splits the instruction into words
			
			if(arr[0].equals(findInstruction(arr[0]))) {
				
				arr[1] = arr[1].replace(",", "");
				
				if(arr[1].equals(findRegister(arr[1]))){
								
					arr[2] = arr[2].replace(",", "");
					
					if(arr[2].equals(findRegister(arr[2]))){
												
						arr[3] = arr[3].replace(",", "");
						int a3 = Integer.parseInt(arr[3]);
						
						if(a3==0 || a3==1 || a3==2 || a3==3 || a3==4 || a3==5 || a3==6 || a3==7) {
							
							//Gets the line number of each word in the file
							int line0 = getLineNumber(operation , arr[0]);
							int line1 = getLineNumber(register , arr[1]);
							int line2 = getLineNumber(register , arr[2]);
							int line3 = getLineNumber(constant , Integer.toHexString(a3));
							
							line0 = line0 - 1;
							line1 = line1 - 1;
							line2 = line2 - 1;
							line3 = line3 - 1;
							
							String bin0 = Files.readAllLines(Paths.get("input instructions binary.txt")).get(line0);
							String bin1 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line1);
							String bin2 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line2);
							String bin3 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line3);
							
							System.out.print(bin0 + " ");
							System.out.print(bin2 + " ");
							System.out.print(bin3 + " ");
							System.out.print(bin1 + " ");
							System.out.print("\n");
										
							System.out.print(Integer.toHexString(line0));
							System.out.print(Integer.toHexString(line2));
							System.out.print(Integer.toHexString(a3));
							System.out.print(Integer.toHexString(line1));
																		
							//Converts and writes in the output file
							PrintWriter out = new PrintWriter(new FileWriter (output, true));
							out.print(arr[0] + " instruction:\n");
							out.print(bin0);
							out.print(" ");
							out.print(bin2);
							out.print(" ");
							out.print(bin3);
							out.print(" ");
							out.print(bin1);
							out.print(" ");
							out.print("\n");
							out.print(Integer.toHexString(line0));
							out.print(Integer.toHexString(line2));
							out.print(Integer.toHexString(a3));
							out.print(Integer.toHexString(line1));							
							out.print("\n");
							out.close();
							
						}
						
						else {
							
							System.out.println("Wrong Instruction");
							
						}
						
					}
					
					else {
						
						System.out.println("Wrong Instruction");
						
					}
					
				}
				
				else {
					
					System.out.println("Wrong Instruction");
					
				}
				
			}
			else {
				
				System.out.println("Wrong Instruction");
				
			}
			
		//}
		
	}
	
	public static void  loadStoreTypeEncription(String [] arr) throws Exception {
		
		//File input = new File("input instructions.txt");
		File operation = new File("list of operations.txt");
		File register = new File("list of registers.txt");
		File output = new File("output instruction.txt");
				
		//Scanner scaninput = new Scanner(input);
		
		//String in;
		
		//while(scaninput.hasNextLine()) {
			//in = scaninput.nextLine();
			
			//System.out.println(in);
			
			//String[] arr = in.split(" ");    //splits the instruction into words
			
			if(arr[0].equals(findInstruction(arr[0]))) {
				
				arr[1] = arr[1].replace(",", "");
				
				if(arr[1].equals(findRegister(arr[1]))){
								
					arr[2] = arr[2].replace("(", "");
					arr[2] = arr[2].replace(")", "");
					
					if(arr[2] != null){
						
						String testOffset = getFirstChar(arr[2]);
												
						int offset = Integer.parseInt(testOffset);
						
						if(offset >= 0) {
							
							String arr3 = deleteFirstChar(arr[2]);
														
							if(arr3.equals(findRegister(arr3))) {
								
								//Gets the line number of each word in the file
								int line0 = getLineNumber(operation , arr[0]);
								int line1 = getLineNumber(register , arr[1]);
								int line2 = getLineNumber(register , arr3);
								
								line0 = line0 - 1;
								line1 = line1 - 1;
								line2 = line2 - 1;
								
								String bin0 = Files.readAllLines(Paths.get("input instructions binary.txt")).get(line0);
								String bin1 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line1);
								String bin2 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line2);
								String bin3 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(offset);
								
								System.out.print(bin0 + " ");
								System.out.print(bin2 + " ");
								System.out.print(bin1 + " ");
								System.out.print(bin3 + " ");
								System.out.print("\n");
								
								System.out.print(Integer.toHexString(line0));
								System.out.print(Integer.toHexString(line2));
								System.out.print(Integer.toHexString(line1));
								System.out.print(Integer.toHexString(offset));
								System.out.print("\n");
																			
								//Converts and writes in the output file
								PrintWriter out = new PrintWriter(new FileWriter (output, true));
								out.print(arr[0] + " instruction:\n");
								out.print(bin0 + " ");
								out.print(bin2 + " ");
								out.print(bin1 + " ");
								out.print(bin3 + " ");
								out.print("\n");
								out.print(Integer.toHexString(line0));
								out.print(Integer.toHexString(line2));
								out.print(Integer.toHexString(line1));
								out.print(Integer.toHexString(offset));
								out.print("\n");
								out.close();
								
							}
							
							else {
								
								System.out.println("Wrong Instruction");
								
							}
														
						}
						
						else {
							
							System.out.println("Wrong Instruction");
							
						}
						
					}
					
					else {
						
						System.out.println("Wrong Instruction");
						
					}
					
				}
				
				else {
					
					System.out.println("Wrong Instruction");
					
				}
				
			}
			else {
				
				System.out.println("Wrong Instruction");
				
			}
			
		//}
		
	}
	
	public static void  inOutTypeEncription(String [] arr) throws Exception {
		
		//File input = new File("input instructions.txt");
		File operation = new File("list of operations.txt");
		File register = new File("list of registers.txt");
		File output = new File("output instruction.txt");
		
		//Scanner scaninput = new Scanner(input);
		
		//String in;
				
		//while(scaninput.hasNextLine()) {
			
			//String in;
			//in = scaninput.nextLine();
			
			//System.out.println(in);
			
			//String[] arr = in.split(" ");    //splits the instruction into words
			
			if(arr[0].equals(findInstruction(arr[0]))) {
				
				arr[1] = arr[1].replace(",", "");
				
				if(arr[1].equals(findRegister(arr[1]))){
					
					//Gets the line number of each word in the file
					int line0 = getLineNumber(operation , arr[0]);
					int line1 = getLineNumber(register , arr[1]);
										
					line0 = line0 - 1;
					line1 = line1 - 1;
					
					String bin0 = Files.readAllLines(Paths.get("input instructions binary.txt")).get(line0);
					String bin1 = Files.readAllLines(Paths.get("list of registers binary.txt")).get(line1);
					
					System.out.print(bin0 + " ");
					System.out.print(bin1 + " ");
					System.out.print("\n");
															
					System.out.print(Integer.toHexString(line0));
					System.out.print(Integer.toHexString(line1));
					System.out.print("\n");
																
					//Converts and writes in the output file
					
					PrintWriter out = new PrintWriter(new FileWriter (output, true));
					out.print(arr[0] + " instruction:\n");
				    out.print(bin0);
				    out.print(" ");
				    out.print(bin1);
				    out.print("\n");
					out.print(Integer.toHexString(line0));
				    out.print(Integer.toHexString(line1));
				    out.print("\n");
				    out.close();
				    
				}
				
				else {
					
					System.out.println("Wrong Instruction");
					
				}
				
			}
			else {
				
				System.out.println("Wrong Instruction");
				
			}
			
		//}
		
	}
	
	public static void  jTypeEncription(String [] arr) throws Exception {
		
		//File input = new File("input instructions.txt");
		File operation = new File("list of operations.txt");
		File register = new File("list of registers.txt");
		File output = new File("output instruction.txt");
		
		//Scanner scaninput = new Scanner(input);
		
		//String in;
				
		//while(scaninput.hasNextLine()) {
			//in = scaninput.nextLine();
			
			//System.out.println(in);
			
			//String[] arr = in.split(" ");    //splits the instruction into words
			
			if(arr[0].equals(findInstruction(arr[0]))) {
				
				arr[1] = arr[1].replace(",", "");
				
				int target = Integer.parseInt(arr[1]);
											
				//Gets the line number of each word in the file
				int line0 = getLineNumber(operation , arr[0]);
													
				line0 = line0 - 1;
				
				String bin0 = Files.readAllLines(Paths.get("input instructions binary.txt")).get(line0);
				String bin1 = Files.readAllLines(Paths.get("constant.txt")).get(target);
				
				System.out.print(bin0 + " ");
				System.out.print(bin1 + " ");
				System.out.print("\n");
													
				System.out.print(Integer.toHexString(line0));
				System.out.print(Integer.toHexString(target));
				System.out.print("\n");
															
				//Converts and writes in the output file
				
				PrintWriter out = new PrintWriter(new FileWriter (output, true));
				out.print(arr[0] + " instruction:\n");
				out.print(bin0);
				out.print(" ");
				out.print(bin1);
				out.print("\n");
				out.print(Integer.toHexString(line0));
				out.print(Integer.toHexString(target));
				out.print("\n");
				out.close();
				
			}
			else {
				
				System.out.println("Wrong Instruction");
				
			}
			
		//}
		
	}
	
	public static void main (String [] args) throws Exception {
		
		File input = new File("input instructions.txt");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		
		Scanner scaninput = new Scanner(input);
		
		String in;
		int lines = 0;
		
		while(scaninput.hasNextLine()==true) {
			in = scaninput.nextLine();
			
			String[] arr = in.split(" ");    //splits the instruction into words
						
			if(arr[0].equals("ADD") || arr[0].equals("SUB") || arr[0].equals("AND") || arr[0].equals("OR") || arr[0].equals("XOR")) {
				
				//System.out.println("R");
				RTypeEncription(arr);
								
			}
			
			else if(arr[0].equals("BEQ") || arr[0].equals("BNE")) {
				
				//System.out.println("B");
				ITypeEncription(arr);
				
			}
			
			else if(arr[0].equals("LW") || arr[0].equals("SW")){
				
				loadStoreTypeEncription(arr);
				
			}
			
			else if(arr[0].equals("Din") || arr[0].equals("Dout")) {
				
				inOutTypeEncription(arr);
				
			}
			
			else if(arr[0].equals("ADDi") || arr[0].equals("SUBi") || arr[0].equals("ANDi") || arr[0].equals("ORi") || arr[0].equals("XORi")) {
				
				//System.out.println("I");
				ITypeEncription(arr);
				
			}
			
			else if(arr[0].equals("J")) {
				
				jTypeEncription(arr);
				
			}
			
		}		
		
	}

}
