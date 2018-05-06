import java.net.*;
import java.io.*;
class server1
{
public static void main(String ar[]) throws Exception
{
try
{
System.out.println("waiting for Client connection");
ServerSocket  ss=new ServerSocket(6000);
Socket cs=ss.accept();
System.out.println("Connected");
PrintWriter sw=new PrintWriter(cs.getOutputStream(),true);
BufferedReader  sr=new BufferedReader(new InputStreamReader(cs.getInputStream()));
BufferedReader  kb=new BufferedReader(new InputStreamReader(System.in));
String msg="";
while(true)
{
msg=sr.readLine();                   //receive from client
if(msg.equals("quit"))
break;
System.out.println("From client::"+msg);


System.out.println("To Client::");               //send to server
msg=kb.readLine();
sw.println(msg);

}
cs.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}