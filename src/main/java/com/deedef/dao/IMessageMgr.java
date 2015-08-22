package com.deedef.dao;

import com.deedef.bean.MessageSms;

import java.util.List;

/**
 * Created by Saliou on 06/08/2015.
 */
public interface IMessageMgr {

    public MessageSms get(Long id);
    public List<MessageSms> getAllMessageByLogin(String login);
    // all methods about message


}
