package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.constantconf.ConstantConf;
import com.jk.dao.LoginDao;
import com.jk.pojo.AppointmentBean;
import com.jk.utils.stutas;
import com.jk.pojo.UserBean;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("logina")
public class LoginController {
    @Autowired
    private LoginDao loginDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("findduanxin")
    @ResponseBody
    public String findduanxin(@RequestParam Long phone) {
        /*用户手机号 key加上状态   判断用户是否登陆过*/
        Boolean aBoolean = redisTemplate.hasKey(ConstantConf.SMS_Login_STATUS_CODE + phone);
        if (aBoolean) {
            Integer stua = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
            if (stua == 1) {
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stua, 24, TimeUnit.HOURS);
                return "次数已用完";
            }

            Object lock = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_LOCK + phone);
            if (lock != null) {
                return "距离上一次获取验证码不超过一分钟";
            }
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("accountSid", ConstantConf.ACCOUNTSID);
            params.put("to", phone);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            params.put("timestamp", timestamp);
            String sig = Md5Util.getMd532(ConstantConf.ACCOUNTSID + ConstantConf.AUTH_TOKEN + timestamp);
            params.put("sig", sig);
            params.put("templateid", ConstantConf.TEMPLATEID);

            String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
            Random r = new Random();
            String arr[] = new String[4];
            String b = "";
            for (int i = 0; i < 4; i++) {
                int n = r.nextInt(62);

                arr[i] = str.substring(n, n + 1);
                b += arr[i];

            }
            params.put("param", b);
            System.out.println(b);
            //session.setAttribute(phone, b);
            redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_CODE + phone, b, ConstantConf.SMS_LOGIN_CODE_TIME_OUT, TimeUnit.MINUTES);
            String string = HttpClientUtil.post(ConstantConf.SMS_URL, params);
            JSONObject parseObject = JSON.parseObject(string);
            System.out.println(parseObject);
            String respCode = parseObject.getString("respCode");
            if ("00000".equals(respCode)) {
                Integer stuw = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
                Integer sta = stuw - 1;
                System.out.println(sta);
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, sta);
                //给当前用户加一个一分钟内不嫩获取验证码
                redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_LOCK + phone, "lock", ConstantConf.SMS_LOGIN_LOCK_TIME_OUT, TimeUnit.MINUTES);
                return "发送验证码成功!";
            }
            return "验证码发送失败！";

        } else {
            Integer stua = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
            if (stua != null) {
                if (stua == 1) {
                    redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stua, 24, TimeUnit.HOURS);
                    return "次数已用完";
                }
            }
            Object lock = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_LOCK + phone);
            if (lock != null) {
                return "距离上一次获取验证码不超过一分钟";
            }
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("accountSid", ConstantConf.ACCOUNTSID);
            params.put("to", phone);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            params.put("timestamp", timestamp);
            String sig = Md5Util.getMd532(ConstantConf.ACCOUNTSID + ConstantConf.AUTH_TOKEN + timestamp);
            params.put("sig", sig);
            params.put("templateid", ConstantConf.TEMPLATEID);

            String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
            Random r = new Random();
            String arr[] = new String[4];
            String b = "";
            for (int i = 0; i < 4; i++) {
                int n = r.nextInt(62);

                arr[i] = str.substring(n, n + 1);
                b += arr[i];

            }
            params.put("param", b);
            System.out.println(b);
            //session.setAttribute(phone, b);
            redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_CODE + phone, b, ConstantConf.SMS_LOGIN_CODE_TIME_OUT, TimeUnit.MINUTES);
            String string = HttpClientUtil.post(ConstantConf.SMS_URL, params);
            JSONObject parseObject = JSON.parseObject(string);
            System.out.println(parseObject);
            String respCode = parseObject.getString("respCode");
            if ("00000".equals(respCode)) {
                stutas stu = new stutas();
                Integer stuw = stu.getSts();
                System.out.println(stuw);
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stuw);
                //给当前用户加一个一分钟内不嫩获取验证码
                redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_LOCK + phone, "lock", ConstantConf.SMS_LOGIN_LOCK_TIME_OUT, TimeUnit.MINUTES);
                return "发送验证码成功!";
            }

            return "验证码发送失败！";
        }
    }

    //短信登录
    @RequestMapping("quicklogin")
    @ResponseBody
    public String quicklogin(@RequestParam Long phone, @RequestParam String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //Object attribute = session.getAttribute(phone);
        Object attribute = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_CODE + phone);
        if (!code.equals(attribute.toString()) && !code.equals("")) {
            return "验证码不存在";
        }
        //把用户存到redis
        redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_PHONE+phone,phone);
        session.setAttribute(session.getId(),phone);
        return "登录成功";
    }

    @RequestMapping("selectLoginUser")
    @ResponseBody
    public  AppointmentBean selectLoginUser(@RequestParam("carid")Integer carid, @RequestParam("toString")String toString){
        AppointmentBean appointmentBean=loginDao.selectLoginUser(carid,toString);
        return appointmentBean;
    }

}
