import java.net.*;
import java.io.*;
class client1
{
public static void main(String ar[]) throws Exception
{
try
{
System.out.println("waiting for server connection");
Socket  cs=new Socket("127.0.0.1",6000);
System.out.println("Connected");
PrintWriter sw=new PrintWriter(cs.getOutputStream(),true);
BufferedReader  sr=new BufferedReader(new InputStreamReader(cs.getInputStream()));
BufferedReader  kb=new BufferedReader(new InputStreamReader(System.in));
String msg="";
while(true)
{
System.out.println("To server:");   //send to server
msg=kb.readLine();
sw.println(msg);


msg=sr.readLine();                    //receive from server
if(msg.equals("quit"))
break;
System.out.println("From server:"+msg);
}
cs.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}