package cn.ec.converter;

import cn.ec.pojo.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<User> {
    public MyMessageConverter() {
        // 新建一个我们自定义的媒体类型application/xxx-custom
        super(new MediaType("application", "xxx-custom", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        // 表明只处理User类型的参数。
        return User.class.isAssignableFrom(clazz);
    }

    /**
     * 重写readlntenal 方法，处理请求的数据。代码表明我们处理由“-”隔开的数据，并转成 User类型的对象。
     */
    @Override
    protected User readInternal(Class<? extends User> clazz,
                                HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");

        return new User(tempArr[0],Integer.parseInt(tempArr[1]));
    }

    /**
     * 重写writeInternal ，处理如何输出数据到response。
     */
    @Override
    protected void writeInternal(User userEntity,
                                 HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String out = "哈哈，就是你: " + userEntity.getUsername() + "-" + userEntity.getGender();
        outputMessage.getBody().write(out.getBytes());
    }


}
