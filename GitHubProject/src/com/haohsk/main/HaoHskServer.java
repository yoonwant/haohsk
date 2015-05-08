package com.haohsk.main;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

public class HaoHskServer {

	public static void main(String[]args){
		HaoHskServer hhs = new HaoHskServer();
		hhs.start();
	}
	
	public void start() {
		Vertx vertx = Vertx.vertx();

		HttpServer httpServer = vertx.createHttpServer();

		httpServer.requestHandler(req ->{
			System.out.println("vertx port = 9090");
			String filename = null;
			String dir = System.getProperty("user.dir");
			if (req.path().equals("/")) {
				filename = "/index.html";
			} else if (req.path().equals("/index")) {
				filename = "/index.html";
			}else if (req.path().equals("/boardcreate")) {
				
				filename = "/boardcreate.html";
			} else if (req.path().equals("/boarddelete")) {
				filename = "/boarddelete.html";
			}else if (req.path().equals("/boardread")) {
				filename = "/boardread.html";
			}else if (req.path().equals("/boardupdate")) {
				filename = "/boardupdate.html";
			}else if (req.path().equals("/formpage")) {
				filename = "/formpage.html";
			}else if (req.path().equals("/indexSiteMap")) {
				filename = "/indexSiteMap.html";
			} else if (req.path().equals("/loginpage")) {
				filename = "/loginpage.html";
			}else if (req.path().equals("/signpage")) {
				filename = "/signpage.html";
			}else if (req.path().equals("/loginpage")) {
				filename = "/loginpage.html";
			}else if (req.path().equals("/signprofile")) {
				filename = "/signprofile.html";
			}else if (req.path().equals("/signupdate")) {
				filename = "/signupdate.html";
			} else if (req.uri().startsWith("/form")) {
				req.response().setChunked(true);
				req.setExpectMultipart(true);

				req.endHandler((v) -> {
					MultiMap mm = req.formAttributes();
					for (String attr : mm.names()) {
						req.response().write("Got attr " + attr + " : " + req.formAttributes().get(attr) + "\n");
					}
					req.response().end();
				});
			} 

			else {
				req.response().setStatusCode(404).end();
			}
			if (filename != null) {
				System.out.println(dir + "/src/com/haohsk/main/web" + filename);
				req.response().sendFile(dir+"/src/com/haohsk/main/web"+filename);
			}

		});

		httpServer.listen(9090);
	}
}
