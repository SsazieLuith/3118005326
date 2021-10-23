package caculator;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

import java.util.*;

public class Main {
	private static Random random = new Random();
	public static int range;
	public static String reductionofFraction(int a,int b) {  //结果的分数约分，用于计算结果
		int y =1 ;
		for (int i = a;i>= 1; i--) {
			if (a%i == 0 && b%i == 0) {
				y  = i;
				break;
			}
		}
		int z =a /y; //分子
		int m =b/y; //分母
		if(z == 0) {
			return "0";
		}
		if(m==1) 
			return z+"";
		else return biaodashi(z,m);
}
    public static String biaodashi(int a,int b) { //判断假分数，并且化假分数为带分数
		if(a>=b) {
			int c;
			c=a/b;
			int d;
			d=a%b;
			{if (d==0)
				{return c+"";}
			return c+"‘"+d+"/"+b;}
			
		}return a+"/"+b;
	
}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	     System.out.println("请输入产生几以内的数字：");
	     range=sc.nextInt();
	     System.out.println("请输入产生多少个运算表达式：");
	     int num=sc.nextInt();
	     int rightcount[]=new int[num+2];
	     int wrongcount[]=new int[num+2];
	     int right1=0;
	    int wrong1=0;
	    String[] results=new String[num];int i;
	     for( i=0;i<num;i++){           /*具体的功能如下面的代码（两个class除外）*/
			String expArr[] = new String[2];//定义生成的题目
			
			int a = (int) (random.nextInt(range));
			// 分子
			int b =(int) (random.nextInt(range));
			//分母
			int c =(int) (random.nextInt(range));
			//另一个分子
			int d =(int) (random.nextInt(range));
			//另一个分母
			int symbol; //运算符
			symbol = (int) (random.nextInt(4));
			
			if (b!=0&&d!=0) {/**分母均不为0时生成带有分数的计算题，同时计算结果
			下面还要分类讨论，记住这个括弧**/
				if(symbol==0) {
					int fenzi =a*d+b*c;
					int fenmu=b*d;
					expArr[0]=biaodashi(a,b)+'+'+biaodashi(c,d)+'=';
					System.out.println(expArr[0]);
					results[i] =reductionofFraction(fenzi,fenmu);
					
				}
			if(symbol==1&&a*d-b*c>=0) {
				int fenzi = a*d-b*c;
				int fenmu =b*d;
				expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
				System.out.println(expArr[0]);
				results[i] =reductionofFraction(fenzi,fenmu);
			}
			if(symbol==1&&a*d-b*c<0) {
				int fenzi =b*c-a*d;
				int fenmu =b*d;
				expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
				System.out.println(expArr[0]);
				results[i] =reductionofFraction(fenzi,fenmu);
			}
			if(symbol==2) {
				int fenzi=a*c;
				int fenmu=b*d;
				expArr[0]=biaodashi(a,b)+'x'+biaodashi(c,d)+'=';
				System.out.println(expArr[0]);
				results[i]=reductionofFraction(fenzi,fenmu);
			}
			if(symbol==3&&c!=0) {
				int fenzi=a*d;
				int fenmu=b*c;
				/*这里不太懂*/
				expArr[0]=biaodashi(a,b)+'÷'+biaodashi(c,d)+'=';
				System.out.println(expArr[0]);
				results[i] =reductionofFraction(fenzi,fenmu);
			}
			if(symbol==3&&c==0) {
	    		break;}

			}
					
			else {//分母至少一个为0时生成只含有整式的运算式，同时计算结果
						b=1; d=1;
						if(symbol==0) {
							int fenzi = a*d+b*c;
							int fenmu = b*d;
							expArr[0]=a+"-"+c+"=";
							System.out.println(expArr[0]);
							results[i]=reductionofFraction(fenzi,fenmu);
						}
						if(symbol==1&&a*d-b*c>=0) {
							int fenzi=a*d-b*c;
							int fenmu=b*d;
							expArr[0]=a+"-"+c+"=";
							System.out.println(expArr[0]);
							results[i]=reductionofFraction(fenzi,fenmu);
						}
						if(symbol==1&&a*d-b*c<0) {
							int fenzi=-a*d+b*c;
							int fenmu=b*d;
							expArr[0]=a+"-"+c+"=";
							System.out.println(expArr[0]);
							results[i]=reductionofFraction(fenzi,fenmu);
						}
						if(symbol==2) {
							int fenzi=a*c;
				    		int fenmu=b*d;
				    		expArr[0]=c+"×"+a+"=";
				    		System.out.println(expArr[0]);
				    		results[i]=reductionofFraction(fenzi, fenmu);
						}
						if(symbol==3&&c!=0) {
				    		int fenzi=a*d;
				    		int fenmu=b*c;
				    		expArr[0]=a+"÷"+c+"=";
				    		System.out.println(expArr[0]);
				    		results[i]=reductionofFraction(fenzi, fenmu);
				    		}
						if(symbol==3&&c==0) {
				    		break;
				    		}
			}
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in); //写入我的答案
		String myans    = scanner.nextLine();
		FileWriter ma=null;
		try {File f=new File("D:\\eclipse-workspace\\Pair Project\\MyAnswers.txt");
	     ma=new FileWriter(f,true);
	     PrintWriter mw = new PrintWriter(ma);
	     mw.println(myans);
	     mw.flush();
	     mw.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	FileWriter fw =null;
		try {
			File f = new File ("Exersies.txt"); // 题目写入
			fw = new FileWriter(f,true);
			
		}catch (IOException e) {
			e.printStackTrace();
		}if(expArr[0]!=null) {
			PrintWriter pw = new PrintWriter(fw);
			pw.println(i+1+"."+expArr[0]);
			pw.flush();
			try {
				fw.flush();
				pw.close();
				fw.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}FileWriter fn =null;
		try {
			File f  = new File("Answer.txt"); //写答案
			fn =new FileWriter(f,true);
			
		}catch (IOException e) {
			e.printStackTrace();
		
		}if(expArr[0]!=null) {
			PrintWriter pn = new PrintWriter (fn);
			pn.println(i+1+"."+results[i]);
			pn.flush();
			try {
				fn.flush();
				pn.close();
				fn.close();
			}catch (IOException e) {
				e.printStackTrace();
			}}
		}
		
		
		
		
		System.out.println("输出ok提交！");//答题完成后输入ok即可提交
			@SuppressWarnings("resource")
			Scanner sc1=new Scanner(System.in);
			String submit =sc1.nextLine();
				if (submit.equals("ok")) {
					String array [] = new String[num];
					try
					{
						int k=0;
						
						FileReader fr = new FileReader("D:\\eclipse-workspace\\Pair Project\\MyAnswers.txt");
						BufferedReader br = new BufferedReader(fr);
						String s;
						while ((s= br.readLine())!=null) {//读取答案
								array[k]=s; 	k++;
								}br.close();
						fr.close();		
						}catch(IOException e) {
							System.out.println("指定文件不存在");
						}
					//}
					for (int j=0;j<num;j++) {
						if(array[j].equals(results[j])) {//验证答案，统计正确和错误的个数
							
							rightcount[j]=j+1;
							right1++;
							
							
						}
						else {
							
							wrongcount[j]=j+1;
							wrong1++;
						}
					}
					FileWriter fg =null;
					try {
						//反馈正确与错误题目的信息
							
							File f=new File("D:\\eclipse-workspace\\Pair Project\\Grade.txt");

							fg = new FileWriter(f,true);
					} catch (IOException e) {
						e.printStackTrace();
					}System.out.println("撒比东西");
					PrintWriter pg = new PrintWriter(fg);
					pg.println("  ");
					pg.print("Correct:"+right1+"(");
				   for (int j =0 ; j<=num;j++) {
					   if (rightcount[j]!=0) {
						   pg.print(rightcount[j]+",");
					   }
					   
				   } 
					pg.print(")");	
					pg.print("Wrong:"+wrong1+"(");
					for(int j=0;j<=num;j++) {
						if(wrongcount[j]!=0) {
							pg.print(wrongcount[j]+",");
						}
					}
					pg.print(")");
					pg.flush();
				
				try {
					fg.flush();
					pg.close();
					fg.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
				}
}
	}
	
git remote add origin https://github.com/SsazieLuith/3118005326.git
	 git branch -M main 
	git push -u origin main