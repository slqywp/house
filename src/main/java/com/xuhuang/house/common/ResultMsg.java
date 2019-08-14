package com.xuhuang.house.common;

import com.google.common.base.Joiner;
import com.google.common.base.Utf8;
import com.google.common.collect.Maps;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import javax.xml.transform.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultMsg
{
    public static final String ERROR_MSG_KEY = "errorMsg";

    public static final String SUCCESS_MSG_KEY = "successMsg";

    private String errorMsg;

    private String successMgs;

    private boolean isSuccess;

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getSuccessMgs()
    {
        return successMgs;
    }

    public void setSuccessMgs(String successMgs)
    {
        this.successMgs = successMgs;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public void setSuccess(boolean success)
    {
        isSuccess = success;
    }

    public static ResultMsg errorMsg(String msg)
    {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setErrorMsg(msg);
        resultMsg.setSuccess(false);
        return resultMsg;
    }

    public static ResultMsg successMsg(String msg)
    {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setSuccessMgs(msg);
        resultMsg.setSuccess(true);
        return resultMsg;
    }

    private Map<String, String> asMap()
    {
        Map<String, String> map = Maps.newHashMap();
        map.put(SUCCESS_MSG_KEY, successMgs);
        map.put(ERROR_MSG_KEY, errorMsg);
        return map;
    }

    public String asUrlParams()
    {
        Map<String, String> map = asMap();
        List<NameValuePair> params = new ArrayList<>();
        map.forEach((k, v) ->
        {
            if (v != null)
            {
                NameValuePair param = new NameValuePair()
                {
                    @Override
                    public String getName()
                    {
                        return k;
                    }

                    @Override
                    public String getValue()
                    {
                        return v;
                    }
                };
                params.add(param);

            }
        });
        return URLEncodedUtils.format(params, Charset.defaultCharset());
    }
}
