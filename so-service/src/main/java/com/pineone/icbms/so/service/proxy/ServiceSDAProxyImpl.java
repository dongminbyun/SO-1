package com.pineone.icbms.so.service.proxy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pineone.icbms.so.util.address.ContextAddress;
import com.pineone.icbms.so.util.conversion.DataConversion;
import com.pineone.icbms.so.util.exception.BadRequestException;
import com.pineone.icbms.so.util.http.ClientService;
import com.pineone.icbms.so.util.session.DefaultSession;
import com.withwiz.beach.network.http.message.IHttpResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

/**
 * Created by melvin on 2016. 10. 13..
 */
public class ServiceSDAProxyImpl implements ServiceSDAProxy{

    public static final Logger logger = LoggerFactory.getLogger(ServiceSDAProxyImpl.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContextAddress contextAddress;

    //NOTE : PC Count
    @Override
    public String getDeviceUri() throws BadRequestException {
        // NOTE : TODO : SDA 연결주소 협의 , RequestData 형태 협의
        IHttpResponseMessage message = clientService.requestGetService(
                contextAddress.getAddress()  + DefaultSession.LOCATION_ID + "PC/?p=," );
        if(message.getStatusCode() == 200) {
            System.out.println(message.getBodyByteArray().toString());
            logger.debug("ResponseMessage : " + message);
            String readData = DataConversion.responseDataToString(message);
            Type type = new TypeToken<RequestData>() {
            }.getType();
            RequestData requestData = new Gson().fromJson(readData, type);
            return requestData.count;
        }
        else{
            throw new BadRequestException();
        }
    }
}
