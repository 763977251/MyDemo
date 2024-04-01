package com.shang.emaildemo.util;

import com.shang.emaildemo.config.MailReceiveConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * MailUtil
 *
 * @Description: 接收与发送邮件
 */
@Component
@RequiredArgsConstructor
public class MailUtil {
    //
//    @Value("${tangdou.isSSL:}")
//    private boolean isSSL;//使用SSL加密
//
//    @Value("${tangdou.host:}")
//    private String host;//QQ邮箱的pop3服务器
//
//    @Value("${tangdou.port:}")
//    private int port;//端口
//
//    @Value("${tangdou.username:}")
//    private String username;//邮件名
//
//    @Value("${tangdou.password:}")
//    private String password;//密码
//
//    @Value("${tangdou.pop3.protocol:}")
//    private String protocol;//使用pop3协议
//
//    @Value("${tangdou.dir:}")
//    private String DIR;//附件存放地址
//
//    @Value("${tangdou.sendaddress:}")
//    private String sendAddress;//收件人地址
//
    private final MailReceiveConfig mailReceiveConfig;
//
//    /**
//     * 发送邮件
//     * */
//    public void sendMail() throws Exception{
//        Properties properties = new Properties();
//        properties.put("mail.transport.protocol", "smtp");// 连接协议
//        properties.put("mail.smtp.host", "smtp.exmail.qq.com");// 主机名
//        properties.put("mail.smtp.port", 465);// 端口号
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
//        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
//        // 得到回话对象
//        Session session = Session.getInstance(properties);
//        // 获取邮件对象
//        Message message = new MimeMessage(session);
//        // 设置发件人邮箱地址
//        message.setFrom(new InternetAddress("liujt@tangdou.com"));
//        // 设置收件人地址
//        message.setRecipients(
//                MimeMessage.RecipientType.TO,
//                new InternetAddress[] { new InternetAddress(sendAddress) });//867742652@qq.com
//        // 设置邮件标题
//        message.setSubject("hello");
//        // 设置邮件内容
//        message.setText("哈哈哈哈哈");
//        // 得到邮差对象
//        Transport transport = session.getTransport();
//        // 连接自己的邮箱账户
//        transport.connect(username, password);// 密码为刚才得到的授权码
//        // 发送邮件
//        transport.sendMessage(message, message.getAllRecipients());
//    }

    /**
     * 接收当日邮件邮件
     */
    public void receive() {
        makeDir();

        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "imap");
        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.imap.host", mailReceiveConfig.getHost());
        // 需要请求认证
        props.setProperty("mail.imap.auth", String.valueOf(mailReceiveConfig.getIsSSL()));

        Session session = Session.getDefaultInstance(props);
        Store store = null;
        Folder folder = null;
        try {
            store = session.getStore("imap");
            store.connect(mailReceiveConfig.getUserName(), mailReceiveConfig.getPassWord());
            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);//在这一步，收件箱所有邮件将被下载到本地

//            Message[] messages = folder.getMessages(folder.getMessageCount() - folder.getUnreadMessageCount() + 1, folder.getMessageCount());
            Message[] messages = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN),false));
            System.out.println("[readEmails] 搜索结果-未读邮件数：" + messages.length);
            System.out.println("[readEmails] folder-未读邮件数：" + folder.getUnreadMessageCount());
            parseMessage(messages);//解析邮件内容

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (folder != null) {
                    folder.close(false);
                }
                if (store != null) {
                    store.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("接收完毕！");
    }

    /**
     * 解析邮件
     *
     * @param messages
     */
    public void parseMessage(Message[] messages) throws Exception {
        if (messages == null || messages.length == 0) {
            System.out.println("没有接收到邮件！");
            return;
        }

        for (int i = messages.length - 1; i >= 0; i--) {
            MimeMessage msg = (MimeMessage) messages[i];
//            if ("next".equals(getSentDate(msg, null))) {
//                break;
//            }
            msg.setFlag(Flags.Flag.SEEN, true);
            System.out.println("----------解析第" + msg.getMessageNumber() + "封邮件----------");
            System.out.println("主题：" + getSubject(msg));
            System.out.println("发件人: " + getFrom(msg));
            System.out.println("收件人：" + getReceiveAddress(msg, null));
            System.out.println("发送时间：" + getSentDate(msg, null));
            System.out.println("是否已读：" + isSeen(msg));
            System.out.println("邮件优先级：" + getPriority(msg));
            System.out.println("是否需要回执：" + isReplySign(msg));
            System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
            boolean isContainerAttachment = isContainAttachment(msg);
            System.out.println("是否包含附件：" + isContainerAttachment);
            if (isContainerAttachment) {
                saveAttachment(msg, mailReceiveConfig.getAttachmentDir() + msg.getSubject() + "_"); //保存附件
            }
            StringBuffer content = new StringBuffer(30);
            getMailTextContent(msg, content);
            System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
            System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
            System.out.println();
        }

    }

    /**
     * 获取邮件主题
     *
     * @param mimeMessage
     * @return String 邮件的主题
     */
    public String getSubject(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject();
    }

    /**
     * 获取邮件发件人
     *
     * @param mimeMessage
     */
    public String getFrom(MimeMessage mimeMessage) throws Exception {
        String from = "";
        Address[] froms = mimeMessage.getFrom();
        if (froms.length < 1) throw new MessagingException("没有发件人");

        InternetAddress address = (InternetAddress) froms[0];
        String person = address.getPersonal();
        if (person != null) {
            person = MimeUtility.decodeText(person) + " ";
        } else {
            person = "";
        }
        from = person + "<" + address.getAddress() + ">";

        return from;
    }

    /**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>Message.RecipientType.TO  收件人</p>
     * <p>Message.RecipientType.CC  抄送</p>
     * <p>Message.RecipientType.BCC 密送</p>
     *
     * @param msg  邮件内容
     * @param type 收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     */
    public static String getReceiveAddress(MimeMessage msg, Message.RecipientType type) throws MessagingException {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null) {
            addresss = msg.getAllRecipients();
        } else {
            addresss = msg.getRecipients(type);
        }

        if (addresss != null) {
            for (Address address : addresss) {
                InternetAddress internetAddress = (InternetAddress) address;
                receiveAddress.append(internetAddress.toUnicodeString()).append(",");
            }
            receiveAddress.deleteCharAt(receiveAddress.length() - 1); //删除最后一个逗号
            return receiveAddress.toString();
        }

        return "没有收件人！";
    }

    /**
     * 获得邮件发送时间
     *
     * @param msg 邮件内容
     * @return yyyy年mm月dd日 星期X HH:mm
     * @throws MessagingException
     */
    public static String getSentDate(MimeMessage msg, String pattern) throws MessagingException {
        Date receivedDate = msg.getSentDate();
        if (receivedDate == null) {
            return "";
        }

        if (pattern == null || pattern.isEmpty()) {
            pattern = "yyyy年MM月dd日";//yyyy年MM月dd日 E HH:mm
        }

        String mailTime = new SimpleDateFormat(pattern).format(receivedDate);//收件日期
        String today = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());//当前日期

        if (!today.equals(mailTime)) {
            return "next";
        }

        return mailTime;
    }

    /**
     * 判断邮件中是否包含附件
     *
     * @param part 邮件内容
     * @return 邮件中存在附件返回true，不存在返回false
     */
    public static boolean isContainAttachment(Part part) throws MessagingException, IOException {
        boolean flag = false;
        if (part.isMimeType("multipart/*")) {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*")) {
                    flag = isContainAttachment(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.contains("application")) {
                        flag = true;
                    }
                    if (contentType.contains("name")) {
                        flag = true;
                    }
                }
                if (flag) {
                    break;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            flag = isContainAttachment((Part) part.getContent());
        }
        return flag;
    }

    /**
     * 判断邮件是否已读
     *
     * @param msg 邮件内容
     * @return 如果邮件已读返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isSeen(MimeMessage msg) throws MessagingException {
        return msg.getFlags().contains(Flags.Flag.SEEN);
    }

    /**
     * 判断邮件是否需要阅读回执
     *
     * @param msg 邮件内容
     * @return 需要回执返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isReplySign(MimeMessage msg) throws MessagingException {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    /**
     * 获得邮件的优先级
     *
     * @param msg 邮件内容
     * @return 1(High):紧急  3:普通(Normal)  5:低(Low)
     * @throws MessagingException
     */
    public String getPriority(MimeMessage msg) throws MessagingException {
        String priority = "普通";
        String[] headers = msg.getHeader("X-Priority");
        if (headers != null) {
            String headerPriority = headers[0];
            if (headerPriority.indexOf("1") != -1 || headerPriority.indexOf("High") != -1)
                priority = "紧急";
            else if (headerPriority.indexOf("5") != -1 || headerPriority.indexOf("Low") != -1)
                priority = "低";
            else
                priority = "普通";
        }
        return priority;
    }

    /**
     * 获得邮件文本内容
     *
     * @param part    邮件体
     * @param content 存储邮件文本内容的字符串
     * @throws MessagingException
     * @throws IOException
     */
    public void getMailTextContent(Part part, StringBuffer content) throws MessagingException, IOException {
        //如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
        boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;
        if (part.isMimeType("text/*") && !isContainTextAttach) {
            content.append(part.getContent().toString());
        } else if (part.isMimeType("message/rfc822")) {
            getMailTextContent((Part) part.getContent(), content);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                getMailTextContent(bodyPart, content);
            }
        }
    }

    /**
     * 保存附件
     *
     * @param part    邮件中多个组合体中的其中一个组合体
     * @param destDir 附件保存目录
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveAttachment(Part part, String destDir) throws UnsupportedEncodingException, MessagingException,
            FileNotFoundException, IOException {
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();    //复杂体邮件
            //复杂体邮件包含多个邮件体
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                //获得复杂体邮件中其中一个邮件体
                BodyPart bodyPart = multipart.getBodyPart(i);
                //某一个邮件体也有可能是由多个邮件体组成的复杂体
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    InputStream is = bodyPart.getInputStream();
                    saveFile(is, destDir, decodeText(bodyPart.getFileName()));
                } else if (bodyPart.isMimeType("multipart/*")) {
                    saveAttachment(bodyPart, destDir);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("name") != -1 || contentType.indexOf("application") != -1) {
                        saveFile(bodyPart.getInputStream(), destDir, decodeText(bodyPart.getFileName()));
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment((Part) part.getContent(), destDir);
        }
    }

    /**
     * 读取输入流中的数据保存至指定目录
     *
     * @param is       输入流
     * @param fileName 文件名
     * @param destDir  文件存储目录
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void saveFile(InputStream is, String destDir, String fileName)
            throws FileNotFoundException, IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(new File(destDir + fileName)));
        int len = -1;
        while ((len = bis.read()) != -1) {
            bos.write(len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }

    /**
     * 文本解码
     *
     * @param encodeText 解码MimeUtility.encodeText(String text)方法编码后的文本
     * @return 解码后的文本
     * @throws UnsupportedEncodingException
     */
    public String decodeText(String encodeText) throws UnsupportedEncodingException {
        if (encodeText == null || "".equals(encodeText)) {
            return "";
        } else {
            return MimeUtility.decodeText(encodeText);
        }
    }

    /**
     * 创建存放PDF的文件夹
     */
    public void makeDir() {
        File dir = new File(mailReceiveConfig.getAttachmentDir());
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

}