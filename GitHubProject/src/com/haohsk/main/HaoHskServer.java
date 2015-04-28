package com.haohsk.main;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.core.streams.Pump;
import org.vertx.java.platform.Verticle;

public class HaoHskServer extends Verticle {

	public void start() {
		HttpServer server = vertx.createHttpServer();

		server.requestHandler(new Handler<HttpServerRequest>() {
			public void handle(HttpServerRequest req) {
				String file = "";
				if (req.path().equals("/")) {
					file = "index.html";
				}else if(req.path().equals("/signpage")){
					System.out.println("start - signpage html");
					file = "signpage.html";
				}else if(req.path().equals("/signupdate")){
					System.out.println("start - signupdate");
					file = "signupdate.html";
				}else if(req.path().equals("/signprofile")){
					System.out.println("start -  signprofile");
					file = "signprofile.html";
				}else if(req.path().equals("/boardcreate")){
					System.out.println("start - boardcreate ");
					file = "boardcreate.html";
				}else if(req.path().equals("/boardread")){
					System.out.println("start -  boardread");
					file = "boardread.html";
				}else if(req.path().equals("/boardupdate")){
					System.out.println("start - boardupdate ");
					file = "boardupdate.html";
				}else if(req.path().equals("/boarddelete")){
					System.out.println("start - boarddelete ");
					file = "boarddelete.html";
				}else if(req.path().equals("/loginpage")){
					System.out.println("start - loginpage ");
					file = "loginpage.html";
				}else if (!req.path().contains("..")) {
					System.out.println(" ..");
					file = req.path();
				}
				req.response().sendFile("web/" + file);
			}
		}).listen(8080, "localhost");
	}
}
