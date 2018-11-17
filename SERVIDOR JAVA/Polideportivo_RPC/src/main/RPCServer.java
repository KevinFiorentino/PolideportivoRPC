package main;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import poli.PoliService;
import handler.PoliHandler;
import java.util.List;
import org.apache.thrift.TException;
import poli.Cancha;
import poli.Turno;

public class RPCServer {

	public static PoliHandler handler = new PoliHandler() {

        };
	public static PoliService.Processor<PoliHandler> processor = new PoliService.Processor<PoliHandler>(handler);
	
	public static void main(String[] args) {
		Runnable simple = new Runnable() {
	        public void run() {
	          simple(processor);
	        }
	      };      
	     
	      new Thread(simple).start();
	}

	public static void simple(PoliService.Processor<PoliHandler> processor) {
	    TServerTransport serverTransport;
		try {
			serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			System.out.println("Iniciando el servidor...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	  }
	
}
