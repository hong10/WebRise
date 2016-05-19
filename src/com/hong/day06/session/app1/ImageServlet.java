package com.hong.day06.session.app1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ImageServlet", urlPatterns = {"/session/ImageServlet"})
public class ImageServlet extends HttpServlet {

	private static final int WIDTH = 120;
	private static final int HEIGHT = 25;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
			g.setColor(Color.BLUE);
			g.drawRect(0, 0, WIDTH, HEIGHT);

			g.setColor(Color.YELLOW);
			g.fillRect(1, 1, WIDTH-2, HEIGHT-2);

			g.setColor(Color.GRAY);
			Random r = new Random();
			for(int i=0;i<9;i++)
				g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r.nextInt(HEIGHT));

			g.setColor(Color.RED);
			g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 20));

			int x = 20;
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<4;i++){
				int num = r.nextInt(10);
				sb.append(num);
				g.drawString(num+"", x, 20);
				x+=20;
			}
			String code = sb.toString();//
			request.getSession().setAttribute("code", code);
		//HttpServletResponse
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
