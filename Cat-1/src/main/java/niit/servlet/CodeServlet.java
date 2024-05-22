package niit.servlet;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应的内容类型
        response.setContentType("image/jpeg");

        // 随机生成4字符验证码
        String captcha = generateCaptcha();

        // 将验证码保存到Session中
        request.getSession().setAttribute("captcha", captcha);

        // 生成验证码图片
        BufferedImage image = generateCaptchaImage(captcha);

        // 将验证码图片输出到浏览器
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg", out);
        out.flush();
        out.close();
    }

    private String generateCaptcha() {
        Random random = new Random();
        StringBuilder captchaBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (random.nextBoolean()) {
                captchaBuilder.append((char) (random.nextInt(10) + 48)); // 生成数字
            } else {
                captchaBuilder.append((char) (random.nextInt(26) + 65)); // 生成大写字母
            }
        }
        return captchaBuilder.toString();
    }

    private BufferedImage generateCaptchaImage(String captcha) {
        int width = 80;
        int height = 28;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        // 绘制背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 绘制干扰线
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.setColor(getRandomColor());
            g.drawLine(x1, y1, x2, y2);
        }

        // 绘制验证码字符
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        for (int i = 0; i < captcha.length(); i++) {
            char c = captcha.charAt(i);
            g.setColor(getRandomColor());
            g.drawString(Character.toString(c), 15 * i + 10, 22);
        }

        // 绘制干扰点
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.setColor(getRandomColor());
            g.drawOval(x, y, 1, 1);
        }
        // 释放资源
        g.dispose();

        return image;
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}